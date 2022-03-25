package com.shiyi.mybatis_plus.controller;


import com.shiyi.mybatis_plus.pojo.Sortpost;
import com.shiyi.mybatis_plus.service.impl.SortpostServiceImpl;
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
@RequestMapping("/sortpost")
public class SortpostController {
    @Autowired
    SortpostServiceImpl sortpostService;

    /**
     *  获取公司热度排序
     * @author ShiYi
     * @return java.util.List<com.shiyi.mybatis_plus.pojo.Weight>
     * @date 2022/3/24 9:54
     */
    @RequestMapping(value = "getweight",method = RequestMethod.GET)
    public Mono<List<Sortpost>> getWeight(){
        return Mono.just(sortpostService.getWeight());

    }

}

