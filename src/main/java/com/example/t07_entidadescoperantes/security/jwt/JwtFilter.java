package com.example.t07_entidadescoperantes.security.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class JwtFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request =  exchange.getRequest();
        String path = request.getPath().value();
        if (path.contains("auth"))
            return chain.filter(exchange);
        String auth = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (auth == null)
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "no token not found"));
        if (!auth.startsWith("Bearer "))
            return  Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST,"invalidate auth"));
        String token = auth.replace("Bearer ", "");
        exchange.getAttributes().put("token" , token);
        return chain.filter(exchange);
    }
}
