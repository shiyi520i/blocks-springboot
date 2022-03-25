package com.shiyi.mybatis_plus.controller;


import com.alibaba.fastjson.JSON;
import com.shiyi.mybatis_plus.mapper.UserMapper;
import com.shiyi.mybatis_plus.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.time.Duration;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ShiYi
 * @since 2021-11-04
 */
@Slf4j
@RestController
@RequestMapping()
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("test1")
    public Mono<User> test() {
        User user1= User.builder()
                .username("")
                .build();
        return Mono
                .just(userMapper.getByUsername("zhangsan").get(0))
                .timeout(Duration.ofMillis(800))
                .filter(user -> user != null)
                //.switchIfEmpty()
                //.subscribe(System.out::println)
                ;
    }


    @GetMapping("test2")
    public Flux<Object> test2() {
        //handle 参数 流对象 skin
        Flux<Object> a = Flux
                .just(userMapper.getByUsername("zhangsan"))
                .handle((x, s) -> {
                    if (x != null) {
                        s.next(x);

                    } else {
                        s.error(
                                new Throwable()
                        );
                    }
                })
                /*   .doOnError(e -> {
                   log.info("uh oh, falling back, service failed for key ");
           })*/
                .doFinally(type -> {
                    System.out.println("dnmd");
                    if (type == SignalType.CANCEL) {

                    }
                })
                //去重
                .distinctUntilChanged()
                //从第一个元素开始，取一个元素
                .take(1)
                ;
        // .onErrorReturn
        //.onErrorResume(e->e.getMessage().)
                /*.onErrorResume(e-> Flux.error(
                        new Exception("oops, SLA exceeded", e)
                ));*/
                /*.create(s->{s.onRequest()})
                .timeout(Duration.ofMillis(100))*/
        return a;
    }

}

