package com.shiyi.mybatis_plus.config;


import com.shiyi.mybatis_plus.common.CosUpload;
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
                RouterFunctions.route(RequestPredicates.GET("/getAllUser"), userService::getAllUsers)
                        .andRoute(RequestPredicates.GET("/getUser/{id}"), userService::getUser)
                        .andRoute(RequestPredicates.POST("/updatauser/{id}"), userService::updataUser)
                        .andRoute(RequestPredicates.POST("/adduser"), userService::addUser)
                        .andRoute(RequestPredicates.DELETE("/delete/{id}"), userService::deleteUser));
    }

    @Bean
    RouterFunction<ServerResponse> uploadRouterFunction(CosUpload cosUpload) {
        return RouterFunctions.nest(RequestPredicates.path("/user"),
                RouterFunctions.route(RequestPredicates.POST("/upload"), cosUpload::cosUpload));
    }
}
