package com.shiyi.mybatis_plus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyi.mybatis_plus.pojo.Companyinfo;
import com.shiyi.mybatis_plus.service.impl.CompanyinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param ci  公司实体
     * @return reactor.core.publisher.Mono<com.shiyi.mybatis_plus.pojo.Companyinfo>
     * @date 2022/3/24 11:56
     */
    @RequestMapping(value = "/getcomone", method = RequestMethod.POST)
    public Mono<Companyinfo> getComOne(@RequestBody Companyinfo ci) {
        return Mono.just(companyinfoService.getComOne(ci.getLoginId()));
    }

    @RequestMapping(value = "/getallcom", method = RequestMethod.GET)
    public Mono<Page<Companyinfo>> getAllCom(@RequestParam("pageNo") Integer pageNo,
                                             @RequestParam("pageSize") Integer pageSize) {
        return Mono.just(companyinfoService.getAllCom(pageNo,pageSize));
    }

    @RequestMapping(value = "/saveCompany", method = RequestMethod.POST)
    public boolean saveCompany(@RequestBody Companyinfo companyinfo) {
        return companyinfoService.save(companyinfo);
    }

    @RequestMapping(value = "/getCompany", method = RequestMethod.GET)
    public Companyinfo getCompany(@RequestParam("loginId") String loginId) {
        return companyinfoService.getById(loginId);
    }
}

