package com.shiyi.mybatis_plus.service.impl;

import com.shiyi.mybatis_plus.pojo.User;
import com.shiyi.mybatis_plus.mapper.UserMapper;
import com.shiyi.mybatis_plus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ShiYi
 * @since 2021-11-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
