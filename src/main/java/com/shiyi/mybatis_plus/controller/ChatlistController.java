package com.shiyi.mybatis_plus.controller;


import com.shiyi.mybatis_plus.pojo.Chatlist;
import com.shiyi.mybatis_plus.service.impl.ChatlistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-25
 */
@RestController
@RequestMapping("/chatlist")
public class ChatlistController {
    @Autowired
    private ChatlistServiceImpl chatlistService;

    @RequestMapping(value = "getChatList",method = RequestMethod.GET)
    public List<Chatlist> getChatList(@RequestParam("loginid") String loginid){
        return chatlistService.getChatList(loginid);
    }

}

