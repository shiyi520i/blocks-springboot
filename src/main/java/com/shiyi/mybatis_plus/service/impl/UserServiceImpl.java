package com.shiyi.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyi.mybatis_plus.Utils.Route;
import com.shiyi.mybatis_plus.pojo.Companyinfo;
import com.shiyi.mybatis_plus.pojo.User;
import com.shiyi.mybatis_plus.mapper.UserMapper;
import com.shiyi.mybatis_plus.pojo.Userrole;
import com.shiyi.mybatis_plus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private UserroleServiceImpl userroleService;
    @Autowired
    private CompanyinfoServiceImpl companyinfoService;

    public Mono<ServerResponse> getAllUsers(ServerRequest serverRequest) {
        return ok().contentType(APPLICATION_JSON)
                .body(Mono.just(userMapper.selectPage(new Page<User>()
                        .setCurrent(parseInt(serverRequest.queryParam("pageNo").get()))
                        .setSize(parseLong(serverRequest.queryParam("pageSize").get())), null)), User.class);
    }

    public Mono<ServerResponse> addUser(ServerRequest serverRequest) {
        return ok().contentType(APPLICATION_JSON)
                .body(serverRequest.bodyToMono(User.class).flatMap(x -> {
                    userService.saveOrUpdate(x);
                    userroleService.save(new Userrole().setLoginId(x.getLoginId()).setType(2));
                    return Mono.empty();
                }), User.class);
    }


    public Mono<ServerResponse> updataUser(ServerRequest serverRequest) {
        return Mono.just(userMapper.selectById(serverRequest.pathVariable("id")))
                .flatMap(user -> Mono.just(userMapper.updateById(user)).then(ok().build()))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> deleteUser(ServerRequest serverRequest) {
        return Mono.just(userMapper.selectById(serverRequest.pathVariable("id")))
                .flatMap(user -> Mono.just(userMapper.deleteById(user)).then(ok().build()))
                .switchIfEmpty(notFound().build());
    }

    public Mono<Object> getOneByLoginId(String id) {
        return userMapper.getOneByLoginId(id) == null ? Mono.empty() : Mono.just(true);
    }

    public Mono<ServerResponse> getUser(ServerRequest serverRequest) {
        return ok().contentType(APPLICATION_JSON)
                .body(Mono.just(userMapper.selectById(serverRequest.pathVariable("id"))), User.class);
    }

    public Mono<ServerResponse> getUserAvatar(ServerRequest serverRequest) {
        List<String> list = new ArrayList<>();
        if (parseInt(serverRequest.queryParam("roleType").get()) == 2) {
            User id = userMapper.selectById(serverRequest.pathVariable("id"));
            list.add(id.getAvatar());
            list.add(id.getUsername());

        } else {
            Companyinfo id = companyinfoService.getLogoAndName(serverRequest.pathVariable("id"));
            list.add(id.getLogo());
            list.add(id.getCompanyname());

        }
        return ok().contentType(APPLICATION_JSON)
                .body(Mono.just(list), User.class);
    }

}
