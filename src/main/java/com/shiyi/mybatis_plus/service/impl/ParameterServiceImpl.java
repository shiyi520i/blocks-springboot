package com.shiyi.mybatis_plus.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shiyi.mybatis_plus.pojo.Parameter;
import com.shiyi.mybatis_plus.mapper.ParameterMapper;
import com.shiyi.mybatis_plus.service.IParameterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-14
 */
@Service
public class ParameterServiceImpl extends ServiceImpl<ParameterMapper, Parameter> implements IParameterService {

    @Autowired
    private ParameterServiceImpl parameterService;
    @Autowired
    private ParameterMapper parameterMapper;

    public void getByPid(Integer pid) {
        List<Parameter> p = parameterMapper.getAllByPid(pid);
    }

    public Parameter getPaById(Integer id){
       return parameterService.getById(id);
    }

    public String getParameterJson(){
        Map<String,List<Parameter>> a = new HashMap() {};
        List<Parameter> p = parameterMapper.getAllByPid(0);
        for (Parameter parameter : p) {
            a.put(parameter.getCode(),parameterMapper.selectList(new QueryWrapper<Parameter>().eq("pid", parameter.getId())));
        }
        return JSON.toJSONString(a);
    }

}
