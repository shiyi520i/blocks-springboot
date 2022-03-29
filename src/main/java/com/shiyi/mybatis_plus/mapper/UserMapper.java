package com.shiyi.mybatis_plus.mapper;

import com.shiyi.mybatis_plus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

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


     Flux<User> insertAll(@Param("id") Publisher<User> entityStream);

}
