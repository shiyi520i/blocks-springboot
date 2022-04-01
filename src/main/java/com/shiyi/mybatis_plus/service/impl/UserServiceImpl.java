package com.shiyi.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyi.mybatis_plus.pojo.User;
import com.shiyi.mybatis_plus.mapper.UserMapper;
import com.shiyi.mybatis_plus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserServiceImpl userService;

    public Mono<ServerResponse> getAllUsers(ServerRequest serverRequest) {
        return ok().contentType(APPLICATION_JSON)
                .body(Mono.just(userMapper.selectPage(new Page<User>()
                        .setCurrent(parseInt(serverRequest.queryParam("pageNo").get()))
                        .setSize(parseLong(serverRequest.queryParam("pageSize").get())), null)), User.class);
    }

    public Mono<ServerResponse> addUser(ServerRequest serverRequest) {
        return ok().contentType(APPLICATION_JSON)
                .body(serverRequest.bodyToMono(User.class).flatMap(x -> {
                    userService.getOneByLoginId(x.getLoginId())
                            .switchIfEmpty(Mono.just(userService.saveOrUpdate(x)));
                    return Mono.empty();
                }), User.class);
    }


    public Mono<ServerResponse> updataUser(ServerRequest serverRequest) {
        return Mono.just(userMapper.selectById(parseLong(serverRequest.pathVariable("id"))))
                .flatMap(user -> Mono.just(userMapper.updateById(user)).then(ok().build()))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> deleteUser(ServerRequest serverRequest) {
        return Mono.just(userMapper.selectById(parseLong(serverRequest.pathVariable("id"))))
                .flatMap(user -> Mono.just(userMapper.deleteById(user)).then(ok().build()))
                .switchIfEmpty(notFound().build());
    }

    public Mono<Object> getOneByLoginId(String id) {
        return userMapper.getOneByLoginId(id) == null ? Mono.empty() : Mono.just(true);
    }
}
