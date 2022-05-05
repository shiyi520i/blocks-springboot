package com.shiyi.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyi.mybatis_plus.pojo.Companyinfo;
import com.shiyi.mybatis_plus.mapper.CompanyinfoMapper;
import com.shiyi.mybatis_plus.pojo.Weight;
import com.shiyi.mybatis_plus.service.ICompanyinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.Long.parseLong;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-22
 */
@Service
public class CompanyinfoServiceImpl extends ServiceImpl<CompanyinfoMapper, Companyinfo> implements ICompanyinfoService {

    @Autowired
    private CompanyinfoMapper companyinfoMapper;
    @Autowired
    private WeightServiceImpl weightService;
    @Autowired
    private CompanyinfoServiceImpl companyinfoService;
    @Autowired
    private ParameterServiceImpl parameterService;


    public Companyinfo getOneByLoginId(String loginId) {
        return companyinfoMapper.getOneByLoginId(loginId);
    }

    @Override
    public Companyinfo getComOne(String id) {
        Companyinfo b = companyinfoMapper.getOneByLoginId(id);
        b.setTType(parameterService.getById(b.getType()).getName());
        Weight weight = weightService.getOneByLoginid(id);
        weight.setLoginid(id);
        weight.setWeight(weight.getWeight() + 1);
        weightService.saveOrUpdate(weight);
        return b;
    }

    public Page<Companyinfo> getAllCom(Integer pageNo, Integer pageSize) {
        return companyinfoService.page(new Page<Companyinfo>().setCurrent(pageNo).setSize(pageSize));
    }

    public Companyinfo getLogoAndName(String id){
        return companyinfoMapper.getLogoAndCompanyname(id);

    }

}
