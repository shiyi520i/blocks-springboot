package com.shiyi.mybatis_plus.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.shiyi.mybatis_plus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ShiYi
 * @since 2021-11-04
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> getByUsername(@Param("username") String username);

}
