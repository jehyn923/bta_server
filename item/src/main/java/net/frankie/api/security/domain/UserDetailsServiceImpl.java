package net.frankie.api.security.domain;

import lombok.RequiredArgsConstructor;
import net.frankie.api.user.domain.User;
import net.frankie.api.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
    private final UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(repository.findByUsername(username))
                .orElseThrow(()-> new UsernameNotFoundException(username + "에 해당하는 객체가 존재하지 않습니다."));

        //user.get은 Optional에서 User 꺼내오는 것
        return UserDetailsImpl.build(user.get());
    }
}
