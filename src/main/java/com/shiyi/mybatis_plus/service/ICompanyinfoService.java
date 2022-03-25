package com.shiyi.mybatis_plus.service;

import com.shiyi.mybatis_plus.pojo.Companyinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shiyi.mybatis_plus.pojo.Weight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-22
 */
public interface ICompanyinfoService extends IService<Companyinfo> {

    List<Companyinfo> getById(@Param("id") Integer id);

     Companyinfo getComOne(Integer id);

}
