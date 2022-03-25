package com.shiyi.mybatis_plus.controller;


import com.shiyi.mybatis_plus.pojo.Companyinfo;
import com.shiyi.mybatis_plus.service.impl.CompanyinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-22
 */
@RestController
@RequestMapping("/companyinfo")
public class CompanyinfoController {

    @Autowired
    CompanyinfoServiceImpl companyinfoService;

    /**
     *  获取公司信息
     *  增加公司热度
     * @author ShiYi
     * @param id   公司id
     * @return reactor.core.publisher.Mono<com.shiyi.mybatis_plus.pojo.Companyinfo>
     * @date 2022/3/24 11:56
     */
    @RequestMapping(value = "/getcomone", method = RequestMethod.POST)
    public Mono<Companyinfo> getComOne(@RequestParam("id") Integer id) {
        return Mono.just(companyinfoService.getComOne(id));
    }

}

