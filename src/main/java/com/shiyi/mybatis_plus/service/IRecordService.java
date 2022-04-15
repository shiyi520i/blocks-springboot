package com.shiyi.mybatis_plus.service;

import com.shiyi.mybatis_plus.common.Result;
import com.shiyi.mybatis_plus.pojo.Record;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-24
 */
public interface IRecordService extends IService<Record> {

    Result<Record> applyPost(Integer rid, String eid, String rpost, String uid);

}
