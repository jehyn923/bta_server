package net.frankie.api.user.service;

import lombok.RequiredArgsConstructor;
import net.frankie.api.security.domain.SecurityProvider;
import net.frankie.api.security.exception.SecurityRuntimeException;
import net.frankie.api.user.domain.Role;
import net.frankie.api.user.domain.User;
import net.frankie.api.user.domain.UserDto;
import net.frankie.api.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final SecurityProvider provider;
    private final ModelMapper modelMapper;

    @Override
    public boolean existByUsername(String username) { return userRepository.existsByUsername(username); }

    @Override
    public Optional<User> findByUsername(String username) { return userRepository.findByUsername(username); }

    @Override
    public UserDto signin(User user) {
        try{
            UserDto userDto = modelMapper.map(user, UserDto.class);
            String token = (encoder.matches(user.getPassword(),
                    //entity로 들어오면 get()을 사용해서 한번 더 꺼내야함 (optional이 없으면 .get필요없는데, optional이 있으면 한번 더 꺼내줘야함)
                    //id 확인은 프런트에서 할 수 있음, pw 확인은 back에서 함
                    userRepository.findByUsername(user.getUsername()).get().getPassword()))
                    ? provider.createToken(user.getUsername(),userRepository.findByUsername(user.getUsername()).get().getRoles())
                    : "Wrong Password";
            userDto.setToken(token);
            return userDto;
        } catch(Exception e){
            throw new SecurityRuntimeException("유효하지 않는 아이디 / 비밀번호", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public String signup(User user) {
        if(!userRepository.existsByUsername(user.getUsername())){
            user.setPassword(encoder.encode(user.getPassword()));
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            list.add(Role.ADMIN);
            user.setRoles(list);
            userRepository.save(user);
            //Back 은 토큰을 발급만 해주지, 관리하지 않음 그렇기 떄문에 무상태라고 할 수 있는거임
            return provider.createToken(user.getUsername(),user.getRoles());
        }else{
            throw new SecurityRuntimeException("중복된 ID 입니다.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public List<User> findAll() { return userRepository.findAll(); }

    @Override
    public User getById(long id) { return userRepository.getById(id); }

    @Override
    public void save(User user) { userRepository.save(user); }

    @Override
    public void count() { userRepository.count(); }

    @Override
    public void deleteById(long id) { userRepository.deleteById(id); }
}
