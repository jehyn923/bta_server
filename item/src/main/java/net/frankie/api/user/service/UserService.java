package net.frankie.api.user.service;

import net.frankie.api.user.domain.User;
import net.frankie.api.user.domain.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {
    boolean existByUsername(String username);
    Optional<User> findByUsername(String username);
    UserDto signin(User user);
    String signup(User user);
    //pagination 확인 할 것
    List<User> findAll();

    //전체 데이터 안에서 특정 데이터를 갖고올 때, get을 사용한다.
    //그렇기 때문에 get~은 Optional을 붙여주면 안된다. 속도의 효율성 저하.
    User getById(long id);
    void save(User user);
    void count();
    void deleteById(long id);

}
