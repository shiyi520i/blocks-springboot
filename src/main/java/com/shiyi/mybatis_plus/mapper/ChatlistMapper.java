package com.shiyi.mybatis_plus.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.shiyi.mybatis_plus.pojo.Chatlist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-25
 */
@Mapper
public interface ChatlistMapper extends BaseMapper<Chatlist> {

    List<Chatlist> getAllByLoginid(@Param("loginid") String loginid);

}
