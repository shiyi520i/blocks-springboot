package com.shiyi.mybatis_plus.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.shiyi.mybatis_plus.pojo.Companyinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-22
 */
@Mapper
public interface CompanyinfoMapper extends BaseMapper<Companyinfo> {

    List<Companyinfo> getById(@Param("id") Integer id);

}
