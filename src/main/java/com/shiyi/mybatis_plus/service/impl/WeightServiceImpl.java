package com.shiyi.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shiyi.mybatis_plus.pojo.Companyinfo;
import com.shiyi.mybatis_plus.pojo.Weight;
import com.shiyi.mybatis_plus.mapper.WeightMapper;
import com.shiyi.mybatis_plus.service.IWeightService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-18
 */
@Service
public class WeightServiceImpl extends ServiceImpl<WeightMapper, Weight> implements IWeightService {

    @Autowired
    private WeightMapper weightMapper;
    @Autowired
    private ParameterServiceImpl parameterService;
    @Autowired
    private CompanyinfoServiceImpl companyinfoService;


    public List<Weight> getWeight() {
        QueryWrapper<Weight> w = new QueryWrapper<>();
        w.orderByDesc("weight").last("limit 5");
        List<Weight> weights = weightMapper.selectList(w);
        weights.stream()
                .map(x -> {
                    Companyinfo c = companyinfoService.getOneByLoginId(x.getLoginid());
                    x.setType(parameterService.getById(c.getType()).getName());
                    x.setName(c.getCompanyname());
                    return x;
                }).collect(Collectors.toList());
        return weights;
    }

    public Weight getOneByLoginid(String loginid) {
        return weightMapper.getOneByLoginid(loginid);
    }


}
