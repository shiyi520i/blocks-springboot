package com.shiyi.mybatis_plus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shiyi.mybatis_plus.pojo.Sortpost;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-24
 */
public interface ISortpostService extends IService<Sortpost> {
    public List<Sortpost> getWeight();
}
