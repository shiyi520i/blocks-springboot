package com.shiyi.mybatis_plus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyi.mybatis_plus.common.Result;
import com.shiyi.mybatis_plus.pojo.Record;
import com.shiyi.mybatis_plus.service.impl.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-24
 */
@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordServiceImpl recordService;

    /**
     *  申请职位
     * @author ShiYi
     * @return com.shiyi.mybatis_plus.common.Result<com.shiyi.mybatis_plus.pojo.Record>
     * @date 2022/3/24 15:52
     */
    @RequestMapping(value = "applypost",method = RequestMethod.POST)
    public Result<Record> applyPost(@RequestBody Record record){
        return recordService.applyPost(record.getRid(),record.getCid(),record.getPost(),record.getUid());
    }

    /**
     *  根据类型返回记录
     * @author ShiYi
     * @param pageNo   当前页
     * @param pageSize 页大小
     * @param uid      用户id
     * @param type     查找类型
     * @return reactor.core.publisher.Mono<com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.shiyi.mybatis_plus.pojo.Record>>
     * @date 2022/4/2 11:33
     */
    @RequestMapping(value = "getrecords",method = RequestMethod.GET)
    public Mono<Page<Record>> getRecordsPage(@RequestParam("pageNo") Integer pageNo,
                                             @RequestParam("pageSize") Integer pageSize,
                                             @RequestParam("uid") String uid,
                                             @RequestParam("type") Integer type){
        return recordService.getRecordsPage(pageNo,pageSize,uid,type);
    }



}

