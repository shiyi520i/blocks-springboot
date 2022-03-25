package com.shiyi.mybatis_plus.mapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import com.shiyi.mybatis_plus.pojo.BusRecruitinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-21
 */
@Mapper
public interface BusRecruitinfoMapper extends BaseMapper<BusRecruitinfo> {

    List<BusRecruitinfo> findByEId(@Param("eId") Integer eId);

    List<BusRecruitinfo> findByRId(@Param("rId") Integer rId);

}
