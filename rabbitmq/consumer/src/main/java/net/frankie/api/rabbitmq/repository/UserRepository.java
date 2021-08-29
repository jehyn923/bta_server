package net.frankie.api.rabbitmq.repository;

import net.frankie.api.rabbitmq.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String> {
    Optional<User> findByAlias(String alias);
    Flux<User> findAll();
    Mono<User> findByUsername(String username);
}
