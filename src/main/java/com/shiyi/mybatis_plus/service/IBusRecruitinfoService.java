package com.shiyi.mybatis_plus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyi.mybatis_plus.pojo.BusRecruitinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-21
 */
public interface IBusRecruitinfoService extends IService<BusRecruitinfo> {


    IPage<BusRecruitinfo> selectPage(String keyword,Integer pageNo,Integer pageSize,String time,String worktype,String salary,String jobtype);

    Page<BusRecruitinfo> selectPageRec(Page page, QueryWrapper q);

    BusRecruitinfo findByEId(String eId);

    BusRecruitinfo findByRId(Integer eId);

}
