package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> routes(ItemController itemController){

        return route(GET("/items"), itemController::all)
                .andRoute(POST("/items"), itemController::create)
                .andRoute(GET("/items/{id}"), itemController::get);

    }
}
