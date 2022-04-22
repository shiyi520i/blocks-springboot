package com.shiyi.mybatis_plus.controller;


import com.shiyi.mybatis_plus.service.impl.UserroleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-21
 */
@RestController
@RequestMapping("/userrole")
public class UserroleController {
    @Autowired
    private UserroleServiceImpl userroleService;

    @RequestMapping(value = "/getRole",method = RequestMethod.GET)
    public Integer getRole(@RequestParam String id){
       return userroleService.getById(id).getType();
    }

}

