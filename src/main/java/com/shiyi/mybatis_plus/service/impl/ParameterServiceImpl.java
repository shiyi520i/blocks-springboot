package com.shiyi.mybatis_plus.service.impl;

import com.shiyi.mybatis_plus.pojo.Parameter;
import com.shiyi.mybatis_plus.mapper.ParameterMapper;
import com.shiyi.mybatis_plus.service.IParameterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
