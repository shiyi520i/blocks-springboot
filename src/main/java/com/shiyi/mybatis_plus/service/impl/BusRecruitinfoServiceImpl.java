package com.shiyi.mybatis_plus.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
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

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>
 *  服务实现类
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

    @Override
    public Page<BusRecruitinfo> selectPageRec(Page page, QueryWrapper q){
        return busRecruitinfoMapper.selectPage(page, q);
    }

    @Override
    public BusRecruitinfo findByEId( Integer eId){
        return busRecruitinfoMapper.findByEId(eId).get(0);
    }

    @Override
    public BusRecruitinfo findByRId( Integer eId){
        List<BusRecruitinfo> b = busRecruitinfoMapper.findByRId(eId);
        return b.size()==0?null:b.get(0);
    }

    @Override
    public IPage<BusRecruitinfo> selectPage(String keyword,Integer pageNo,Integer pageSize,String time,String worktype,String salary,String jobtype) {
        Integer w=0;
        if ("全职".equals(worktype))
            w = 0;
        if ("兼职".equals(worktype))
            w = 1;
        List<Integer> s = SUtil.sToM(salary);
        Page<BusRecruitinfo> page = new Page<>();
        page.setCurrent(pageNo).setSize(pageSize);
        QueryWrapper<BusRecruitinfo> q = new QueryWrapper<>();
        q.like("r_post",keyword).like("r_ztype",jobtype).ge("r_minsalary",s.get(0)).le("r_maxsalary",s.get(1)).eq("r_worktype",w);
        Page<BusRecruitinfo> b = busRecruitinfoService.selectPageRec(page, q);
         b.getRecords().stream().map(x -> {

            //Companyinfo c = companyinfoService.getById(x.getEId()).get(0);
            Companyinfo c = companyinfoService.getById(x.getEId());
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
            x.setRlogo("http://localhost:86/rlzygl/" + c.getLogo());
            // x.put("r_logo", "logo.png");
            x.setRold(x.getRJexperience());
            //实现高亮
            x.setRPost(x.getRPost().replace(keyword, "<span style=\"color:red;\">" + keyword + "</span>"));
            return x;
        }).collect(Collectors.toList());

         return b;
    }

    public BusRecruitinfo postOne(Integer id,Integer cid,String uid,String postname){

        if(uid!=null){
            Record r = new Record();
            r.setUid(uid).setPost(postname).setCid(cid).setType(3);
            recordService.save(r);
        }
        return busRecruitinfoService.findByRId(id);
    }


    public boolean savePost(BusRecruitinfo busRecruitinfo){

        return busRecruitinfoService.saveOrUpdate(busRecruitinfo);
    }
}
