package com.shiyi.mybatis_plus.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.shiyi.mybatis_plus.pojo.Weight;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-24
 */
@Mapper
public interface WeightMapper extends BaseMapper<Weight> {

    List<Weight> getByCid(@Param("cid") Integer cid);
}
