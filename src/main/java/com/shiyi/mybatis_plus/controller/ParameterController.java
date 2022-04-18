package com.shiyi.mybatis_plus.controller;



import com.shiyi.mybatis_plus.service.impl.ParameterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-14
 */
@RestController
@RequestMapping("/parameter")
public class ParameterController {
    @Autowired
    private ParameterServiceImpl parameterService;


    @RequestMapping(value = "/getparameter",method = RequestMethod.GET)
    public String getParameterJson() {
        return parameterService.getParameterJson();
    }

}

