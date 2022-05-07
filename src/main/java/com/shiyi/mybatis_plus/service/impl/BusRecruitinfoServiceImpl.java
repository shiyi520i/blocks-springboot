package com.shiyi.mybatis_plus.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyi.mybatis_plus.Utils.SUtil;
import com.shiyi.mybatis_plus.pojo.BusRecruitinfo;
import com.shiyi.mybatis_plus.mapper.BusRecruitinfoMapper;
import com.shiyi.mybatis_plus.pojo.Companyinfo;
import com.shiyi.mybatis_plus.pojo.Record;
import com.shiyi.mybatis_plus.service.IBusRecruitinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-21
 */
@Service
public class BusRecruitinfoServiceImpl extends ServiceImpl<BusRecruitinfoMapper, BusRecruitinfo> implements IBusRecruitinfoService {

    @Autowired
    BusRecruitinfoMapper busRecruitinfoMapper;
    @Autowired
    CompanyinfoServiceImpl companyinfoService;
    @Autowired
    BusRecruitinfoServiceImpl busRecruitinfoService;
    @Autowired
    RecordServiceImpl recordService;
    @Autowired
    private ParameterServiceImpl parameterService;

    @Override
    public Page<BusRecruitinfo> selectPageRec(Page page, QueryWrapper q) {
        return busRecruitinfoMapper.selectPage(page, q);
    }

    @Override
    public BusRecruitinfo findByEId(String eId) {
        return busRecruitinfoMapper.findByEId(eId).get(0);
    }

    @Override
    public BusRecruitinfo findByRId(Integer eId) {
        List<BusRecruitinfo> b = busRecruitinfoMapper.findByRId(eId);
        return b.size() == 0 ? null : b.get(0);
    }

    @Override
    public IPage<BusRecruitinfo> selectPage(String keyword, Integer pageNo, Integer pageSize, Integer species, String worktype, String salary, String jobtype, String province) {
        Integer w = 0;
        if ("兼职".equals(worktype)) w = 1;
        List<Integer> s = SUtil.sToM(salary);
        Page<BusRecruitinfo> page = new Page<>();
        page.setCurrent(pageNo).setSize(pageSize);
        QueryWrapper<BusRecruitinfo> q = new QueryWrapper<>();
        q.like("r_post", keyword).like("r_ztype", jobtype).ge("r_minsalary", s.get(0)).le("r_maxsalary", s.get(1)).eq("r_worktype", w).eq("r_jexperience", species);
        if (!province.isEmpty())
            q.eq("r_province", province);
        Page<BusRecruitinfo> b = busRecruitinfoService.selectPageRec(page, q);
        b.getRecords().stream().map(x -> {

            Companyinfo c = companyinfoService.getOneByLoginId(x.getEId());
            //设置时间
            DateTime date = DateUtil.date(Calendar.getInstance());
            DateTime dateTime = DateUtil.offsetDay(date, -1);
            String r_time = x.getRTime();
            long betweenDay = DateUtil.between(DateUtil.parse((r_time)), date, DateUnit.DAY);
            x.setRTime(betweenDay + "天前");
            //福利条件切割
            String[] r_welfares = x.getRWelfares().split(",");
            x.setWelfares(r_welfares);
            //设置公司名称
            x.setRname(c.getCompanyname());
            //显示公司logo
            x.setRlogo(c.getLogo());
            //实现高亮
            x.setPost(x.getRPost().replace(keyword, "<span style=\"color:red;\">" + keyword + "</span>"));
            //转工作年龄要求
            x.setJexperience(parameterService.getById(x.getRJexperience()).getName());
            //转学历要求
            x.setErequirement(parameterService.getById(x.getRErequirement()).getName());
            //显示类型
            x.setType(parameterService.getById(c.getType()).getName());
            return x;
        }).collect(Collectors.toList());

        return b;
    }

    public BusRecruitinfo postOne(Integer id, String cid, String uid, String postname) {
        BusRecruitinfo b = busRecruitinfoService.findByRId(id);
        //转工作年龄要求
        b.setJexperience(parameterService.getById(b.getRJexperience()).getName());
        //转学历要求
        b.setErequirement(parameterService.getById(b.getRErequirement()).getName());
        //返回统计记录
        b.setCount(busRecruitinfoService.countPostAndRecord(cid));
        if (uid != null) {
            Record r = new Record();
            r.setUid(uid).setPost(postname).setCid(cid).setType(3).setRid(id);
            recordService.save(r);
        }
        return b;
    }

    public BusRecruitinfo postOne(Integer id) {
        BusRecruitinfo b = busRecruitinfoService.findByRId(id);
        //转工作年龄要求
        b.setJexperience(parameterService.getById(b.getRJexperience()).getName());
        //转学历要求
        b.setErequirement(parameterService.getById(b.getRErequirement()).getName());
        String[] r_welfares = b.getRWelfares().split(",");
        b.setWelfares(r_welfares);

        return b;
    }

    public boolean savePost(BusRecruitinfo busRecruitinfo) {
        return busRecruitinfoService.saveOrUpdate(busRecruitinfo);
    }

    public List<Long> countPostAndRecord(String cid) {
        long postCount = busRecruitinfoMapper.selectCount(new QueryWrapper<BusRecruitinfo>().eq("e_id", cid));
        long recordCount = recordService.count(new QueryWrapper<Record>().eq("cid", cid).eq("type", 3));
        List<Long> count = new ArrayList<>();
        count.add(postCount);
        count.add(recordCount);

        return count;
    }


    public IPage<BusRecruitinfo> selectPageSim(String keyword, Integer pageNo, Integer pageSize, String companyName, String uid) {
        QueryWrapper<Object> q = new QueryWrapper<>();
        if (keyword != null)
            q.eq("e_id", keyword);
        if (!uid.isEmpty())
            q.eq("e_id", uid);
        Page<BusRecruitinfo> b = busRecruitinfoService.selectPageRec(new Page<>().setCurrent(pageNo).setSize(pageSize), q);
        b.getRecords().stream().map(x -> {
            Companyinfo c = companyinfoService.getOneByLoginId(x.getEId());
            //福利条件切割
            String[] r_welfares = x.getRWelfares().split(",");
            x.setWelfares(r_welfares);
            //设置公司名称
            x.setRname(c.getCompanyname());
            //显示公司logo
            x.setRlogo(c.getLogo());
            //实现高亮
            x.setPost("<span style=\"color:#FA509F;\">" + x.getRPost() + "</span>");
            //转工作年龄要求
            x.setJexperience(parameterService.getById(x.getRJexperience()).getName());
            //转学历要求
            x.setErequirement(parameterService.getById(x.getRErequirement()).getName());
            //显示类型
            x.setType(parameterService.getById(c.getType()).getName());
            return x;
        }).collect(Collectors.toList());

        return b;
    }
}
