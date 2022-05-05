package com.shiyi.mybatis_plus.service.impl;

import com.shiyi.mybatis_plus.pojo.Chat;
import com.shiyi.mybatis_plus.mapper.ChatMapper;
import com.shiyi.mybatis_plus.service.IChatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-25
 */
@Service
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat> implements IChatService {

    @Select("")
    public void getChatMsg(){

    }

}
