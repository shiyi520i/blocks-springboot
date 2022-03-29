package com.shiyi.mybatis_plus.controller;


import com.shiyi.mybatis_plus.pojo.Weight;
import com.shiyi.mybatis_plus.service.impl.WeightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-24
 */
@RestController
@RequestMapping("/weight")
public class WeightController {

    @Autowired
    WeightServiceImpl weightService;

    /**
     *  获取公司热度排序
     * @author ShiYi
     * @return java.util.List<com.shiyi.mybatis_plus.pojo.Weight>
     * @date 2022/3/24 9:54
     */
    @RequestMapping(value = "getweight",method = RequestMethod.GET)
    public Mono<List<Weight>> getWeight(){
       return Mono.just(weightService.getWeight());

    }

    /*@GetMapping("test1")
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
                *//*   .doOnError(e -> {
                log.info("uh oh, falling back, service failed for key ");
    })*//*
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
                *//*.onErrorResume(e-> Flux.error(
                        new Exception("oops, SLA exceeded", e)
                ));*//*
            *//*.create(s->{s.onRequest()})
            .timeout(Duration.ofMillis(100))*//*
            return a;
}

}*/

}

