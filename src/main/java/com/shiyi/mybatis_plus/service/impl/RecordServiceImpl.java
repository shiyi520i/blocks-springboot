package com.shiyi.mybatis_plus.service.impl;

import com.shiyi.mybatis_plus.common.Result;
import com.shiyi.mybatis_plus.pojo.Record;
import com.shiyi.mybatis_plus.mapper.RecordMapper;
import com.shiyi.mybatis_plus.service.IRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-24
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {
    @Autowired
    RecordServiceImpl recordService;

    @Override
    public Result<Record> applyPost(Integer rid, Integer eid, String rpost, String uid) {
        Result<Record> result = new Result<>();
        if (uid == null) {
            result.setMsg("申请失败,请先登录。").setCode(400);
        } else {

            Record record = new Record();
            record.setUid(uid).setCid(eid).setType(2).setPost(rpost);
            result.setMsg("成功").setCode(200);
            recordService.save(record);

        }
        return result;

    }

}
