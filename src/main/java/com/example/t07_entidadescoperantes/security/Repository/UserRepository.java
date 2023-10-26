package com.example.t07_entidadescoperantes.security.Repository;

import com.example.t07_entidadescoperantes.security.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository  extends ReactiveCrudRepository<User,Integer> {
    Mono<User> findByUsernameOrEmail(String username, String email);
}
