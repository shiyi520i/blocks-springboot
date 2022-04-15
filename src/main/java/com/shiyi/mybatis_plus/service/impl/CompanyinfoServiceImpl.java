package com.shiyi.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyi.mybatis_plus.pojo.Companyinfo;
import com.shiyi.mybatis_plus.mapper.CompanyinfoMapper;
import com.shiyi.mybatis_plus.pojo.Weight;
import com.shiyi.mybatis_plus.service.ICompanyinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Long.parseLong;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-22
 */
@Service
public class CompanyinfoServiceImpl extends ServiceImpl<CompanyinfoMapper, Companyinfo> implements ICompanyinfoService {

    @Autowired
    CompanyinfoMapper companyinfoMapper;
    @Autowired
    WeightServiceImpl weightService;
    @Autowired
    CompanyinfoServiceImpl companyinfoService;
    @Autowired
    private ParameterServiceImpl parameterService;

    @Override
    public List<Companyinfo> getById(Integer id) {
        return companyinfoMapper.getById(id);
    }

    public Companyinfo getOneByLoginId(String loginId){
        return companyinfoMapper.getOneByLoginId(loginId);
    }

    @Override
    public Companyinfo getComOne(String id){
        Companyinfo b = companyinfoMapper.getOneByLoginId(id);
        b.setTType(parameterService.getById(b.getType()).getName());
/*        Weight weight = weightService.getByCid(id);
        weight.setCid(id);
        weight.setWeight(weight.getWeight()+1);
        weightService.saveOrUpdate(weight);*/
        return b;
    }

    public Page<Companyinfo> getAllCom(Integer pageNo,Integer pageSize){
        return companyinfoService.page(new Page<Companyinfo>().setCurrent(pageNo).setSize(pageSize));
    }

}
