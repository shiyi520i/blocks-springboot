package com.shiyi.mybatis_plus.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shiyi.mybatis_plus.pojo.BusRecruitinfo;
import com.shiyi.mybatis_plus.pojo.Record;
import com.shiyi.mybatis_plus.service.impl.BusRecruitinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-21
 */
@RestController
@RequestMapping("/busRecruitinfo")
public class BusRecruitinfoController {

    @Autowired
    BusRecruitinfoServiceImpl busRecruitinfoService;

    /**
     * 显示职位分页信息
     *
     * @param keyword  搜索关键字
     * @param pageNo   页面大小
     * @param pageSize 当前页
     * @param species  学历要求
     * @param worktype 是否全职
     * @param salary   薪资范围
     * @param jobtype  职位类型
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.shiyi.mybatis_plus.pojo.BusRecruitinfo>
     * @author ShiYi
     * @date 2022/3/23 15:38
     */
    @RequestMapping(value = "/getpage", method = RequestMethod.GET)
    public IPage<BusRecruitinfo> getPage(@RequestParam("keyword") String keyword,
                                         @RequestParam("pageNo") Integer pageNo,
                                         @RequestParam("pageSize") Integer pageSize,
                                         @RequestParam("species") Integer species,
                                         @RequestParam("worktype") String worktype,
                                         @RequestParam("salary") String salary,
                                         @RequestParam("jobtype") String jobtype,
                                         @RequestParam(value = "province",required = false) String province
    ) {
        return busRecruitinfoService.selectPage(keyword, pageNo, pageSize, species, worktype, salary, jobtype,province);
    }


    /**
     * 展示职位信息
     *
     * @param rd 接收职位信息参数
     * @return com.shiyi.mybatis_plus.pojo.BusRecruitinfo
     * @author ShiYi
     * @date 2022/3/25 14:18
     */
    @RequestMapping(value = "/postone", method = RequestMethod.POST)
    public BusRecruitinfo getPostOne(@RequestBody Record rd) {
        return busRecruitinfoService.postOne(rd.getRid(), rd.getCid(), rd.getUid(), rd.getPost());
    }

    @RequestMapping(value = "/postinfo", method = RequestMethod.GET)
    public BusRecruitinfo getPostInfo(@RequestParam("rid") Integer rid) {
        return busRecruitinfoService.postOne(rid);
    }

    /**
     * 保存或更新职位信息
     *
     * @param busRecruitinfo 职位实体
     * @return boolean
     * @author ShiYi
     * @date 2022/4/13 15:35
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public boolean savePost(@RequestBody BusRecruitinfo busRecruitinfo) {
        return busRecruitinfoService.savePost(busRecruitinfo);
    }


    /**
     * @param keyword  公司id关键字
     * @param pageNo   当前页
     * @param pageSize 页大小
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.shiyi.mybatis_plus.pojo.BusRecruitinfo>
     * @author ShiYi
     * @date 2022/4/19 9:28
     */
    @RequestMapping(value = "/getpagesim", method = RequestMethod.GET)
    public IPage<BusRecruitinfo> getPageSim(@RequestParam(value = "keyword", required = false) String keyword,
                                            @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                            @RequestParam("pageSize") Integer pageSize,
                                            @RequestParam(value = "uid",required = false) String uid,
                                            @RequestParam(value = "cn", required = false) String companyName) {
        return busRecruitinfoService.selectPageSim(keyword, pageNo, pageSize, companyName,uid);
    }

    /**
     * @param loginId 公司id
     * @return java.util.List<java.lang.Long>
     * @author ShiYi
     * @date 2022/4/19 9:28
     */
    @RequestMapping(value = "/getcount", method = RequestMethod.GET)
    public List<Long> getCount(@RequestParam("loginId") String loginId) {
        return busRecruitinfoService.countPostAndRecord(loginId);
    }

    /**
     * 删除职位信息
     *
     * @param busRecruitinfo 职位信息
     * @return boolean
     * @author ShiYi
     * @date 2022/4/19 16:16
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public boolean remove(@RequestBody BusRecruitinfo busRecruitinfo) {
        return busRecruitinfoService.removeById(busRecruitinfo);
    }
}


