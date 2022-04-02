package com.shiyi.mybatis_plus.config;


import com.shiyi.mybatis_plus.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 *
 * @author ShiYi
 * @date 2022/3/29 13:47
 */
@Configuration
public class RouterConfiguration {
    @Bean
    RouterFunction<ServerResponse> userRouterFunction(UserServiceImpl userService) {
        return RouterFunctions.nest(RequestPredicates.path("/user"),
                RouterFunctions.route(RequestPredicates.GET("/a"), userService::getAllUsers)
                        .andRoute(RequestPredicates.POST("/updatauser/{id}"), userService::updataUser)
                        .andRoute(RequestPredicates.POST("/adduser"), userService::addUser)
                        .andRoute(RequestPredicates.DELETE("/c/{id}"), userService::deleteUser));
    }
}
