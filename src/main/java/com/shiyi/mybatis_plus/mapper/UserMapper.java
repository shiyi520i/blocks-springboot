package com.shiyi.mybatis_plus.mapper;

import com.shiyi.mybatis_plus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

     User getOneByLoginId(@Param("loginId") String loginId);

}
