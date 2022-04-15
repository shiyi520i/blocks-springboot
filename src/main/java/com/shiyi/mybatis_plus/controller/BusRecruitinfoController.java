package com.shiyi.mybatis_plus.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shiyi.mybatis_plus.pojo.BusRecruitinfo;
import com.shiyi.mybatis_plus.pojo.Record;
import com.shiyi.mybatis_plus.pojo.ReqData;
import com.shiyi.mybatis_plus.service.impl.BusRecruitinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
     * @param time     发布时间
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
                                         @RequestParam("time") String time,
                                         @RequestParam("worktype") String worktype,
                                         @RequestParam("salary") String salary,
                                         @RequestParam("jobtype") String jobtype
    ) {
        return busRecruitinfoService.selectPage(keyword, pageNo, pageSize, time, worktype, salary, jobtype);
    }


    /**
     *  展示职位信息
     * @author ShiYi
     * @param rd   接收职位信息参数
     * @return com.shiyi.mybatis_plus.pojo.BusRecruitinfo
     * @date 2022/3/25 14:18
     */
    @RequestMapping(value = "/postone", method = RequestMethod.POST)
    public BusRecruitinfo getPostOne(@RequestBody Record rd) {

        return busRecruitinfoService.postOne(rd.getId(), rd.getCid(), rd.getUid(), rd.getPost());
    }

    /**
     *  保存或更新职位信息
     * @author ShiYi
     * @param busRecruitinfo 职位实体
     * @return boolean
     * @date 2022/4/13 15:35
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public boolean savePost(@RequestBody BusRecruitinfo busRecruitinfo) {

        return busRecruitinfoService.savePost(busRecruitinfo);
    }


}


