package com.shiyi.mybatis_plus.service.impl;

import com.shiyi.mybatis_plus.pojo.Companyinfo;
import com.shiyi.mybatis_plus.mapper.CompanyinfoMapper;
import com.shiyi.mybatis_plus.pojo.Weight;
import com.shiyi.mybatis_plus.service.ICompanyinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

import static java.lang.Long.parseLong;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

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

    @Override
    public List<Companyinfo> getById(Integer id) {
        return companyinfoMapper.getById(id);
    }

    @Override
    public Companyinfo getComOne(Integer id){
        Companyinfo b = companyinfoMapper.getById(id).get(0);
        Weight weight = weightService.getByCid(id);
        weight.setCid(id);
        weight.setWeight(weight.getWeight()+1);
        weightService.saveOrUpdate(weight);
        return b;
    }

}
