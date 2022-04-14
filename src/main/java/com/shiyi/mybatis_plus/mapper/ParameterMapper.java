package com.shiyi.mybatis_plus.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.shiyi.mybatis_plus.pojo.Parameter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-14
 */
@Mapper
public interface ParameterMapper extends BaseMapper<Parameter> {

    List<Parameter> getAllByPid(@Param("pid") Integer pid);

}
