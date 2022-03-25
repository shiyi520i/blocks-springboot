package com.shiyi.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shiyi.mybatis_plus.mapper.WeightMapper;
import com.shiyi.mybatis_plus.pojo.Sortpost;
import com.shiyi.mybatis_plus.mapper.SortpostMapper;
import com.shiyi.mybatis_plus.pojo.Weight;
import com.shiyi.mybatis_plus.service.ISortpostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SortpostServiceImpl extends ServiceImpl<SortpostMapper, Sortpost> implements ISortpostService {

    @Autowired
    SortpostMapper sortpostMapper;

    public List<Sortpost> getWeight(){
        QueryWrapper<Sortpost> w = new QueryWrapper<>();
        w.orderByDesc("weight").last("limit 5");
        return sortpostMapper.selectList(w);
    }
}
