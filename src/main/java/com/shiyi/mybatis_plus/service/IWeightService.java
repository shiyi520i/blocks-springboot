package com.shiyi.mybatis_plus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shiyi.mybatis_plus.pojo.Weight;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-24
 */
public interface IWeightService extends IService<Weight> {

    public List<Weight> getWeight();

    Weight getByCid(Integer cid);
}
