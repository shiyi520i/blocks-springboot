package com.shiyi.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shiyi.mybatis_plus.pojo.Weight;
import com.shiyi.mybatis_plus.mapper.WeightMapper;
import com.shiyi.mybatis_plus.service.IWeightService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-24
 */
@Service
public class WeightServiceImpl extends ServiceImpl<WeightMapper, Weight> implements IWeightService {

    @Autowired
    WeightMapper weightMapper;

    @Override
    public List<Weight> getWeight(){
        QueryWrapper<Weight> w = new QueryWrapper<>();
        w.orderByDesc("weight").last("limit 5");
        return weightMapper.selectList(w);
    }

    @Override
    public Weight getByCid(Integer cid){
        return weightMapper.getByCid(cid).get(0);
    }
}
