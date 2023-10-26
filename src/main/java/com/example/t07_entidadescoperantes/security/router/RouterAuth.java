package com.example.t07_entidadescoperantes.security.router;

import com.example.t07_entidadescoperantes.security.handler.AuthHandler;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
@Slf4j
public class RouterAuth {
    private static final Logger logger = LoggerFactory.getLogger(RouterAuth.class);
    @Bean
    public RouterFunction<ServerResponse> routerAuthentic(AuthHandler handler) {
        logger.info("Este es un mensaje de información.");
        return RouterFunctions
                .route(POST("/auth/login").and(accept(MediaType.APPLICATION_JSON)), handler::login)
                .andRoute(POST("/auth/create").and(accept(MediaType.APPLICATION_JSON)), handler::create);
    }
}
