package com.shiyi.mybatis_plus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyi.mybatis_plus.pojo.Applylist;
import com.shiyi.mybatis_plus.service.impl.ApplylistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-08
 */
@RestController
@RequestMapping("/applylist")
public class ApplylistController {

    @Autowired
    private ApplylistServiceImpl applylistService;

    @RequestMapping(value = "imgupload", method = RequestMethod.POST)
    public Mono<String> uploadImg(@RequestPart("file") Mono<FilePart> file) {
        return applylistService.uploadImg(file);
    }

    @RequestMapping(value = "saveapply", method = RequestMethod.POST)
    public Mono<Boolean> saveApply(@RequestBody Applylist applylist) {
        return applylistService.saveApply(applylist);
    }

    @RequestMapping(value = "getall", method = RequestMethod.GET)
    public Mono<Page<Applylist>> getAll(@RequestParam("pageNo") Integer pageNo,
                                        @RequestParam("pageSize") Integer pageSize,
                                        @RequestParam(value = "type",required = false) Integer type) {
        return applylistService.getAll(pageNo, pageSize,type);
    }

    @RequestMapping(value = "getone", method = RequestMethod.GET)
    public void getByApplyId(@RequestParam("id") Integer id) {
        applylistService.getByApplyId(id);
    }

}

