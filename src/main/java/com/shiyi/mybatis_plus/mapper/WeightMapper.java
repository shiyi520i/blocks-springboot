package com.shiyi.mybatis_plus.mapper;
import org.apache.ibatis.annotations.Param;

import com.shiyi.mybatis_plus.pojo.Weight;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-18
 */
@Mapper
public interface WeightMapper extends BaseMapper<Weight> {

    Weight getOneByLoginid(@Param("loginid") String loginid);

}
