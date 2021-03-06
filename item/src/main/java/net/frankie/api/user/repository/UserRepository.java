package net.frankie.api.user.repository;

import net.frankie.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByUsername (String username);
    Optional<User> findByUsername(String username);

    @Query("select u from User u where u.username = :username and u.password = :password")
    User signin(@Param("username") String username, @Param("password") String password);

}
