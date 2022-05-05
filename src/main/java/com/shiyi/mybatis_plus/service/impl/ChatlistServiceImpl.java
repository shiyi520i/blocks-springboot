package com.shiyi.mybatis_plus.service.impl;

import com.shiyi.mybatis_plus.pojo.Chatlist;
import com.shiyi.mybatis_plus.mapper.ChatlistMapper;
import com.shiyi.mybatis_plus.service.IChatlistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-25
 */
@Service
public class ChatlistServiceImpl extends ServiceImpl<ChatlistMapper, Chatlist> implements IChatlistService {

    @Autowired
    private ChatlistMapper chatlistMapper;

    public List<Chatlist> getChatList(String loginid){
        List<Chatlist> id = chatlistMapper.getAllByLoginid(loginid);
        id.stream().map(x->{x.getList();return x;}).collect(Collectors.toList());
        return null;
    }

}
