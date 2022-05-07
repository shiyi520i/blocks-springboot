package com.shiyi.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyi.mybatis_plus.Utils.Route;
import com.shiyi.mybatis_plus.common.Result;
import com.shiyi.mybatis_plus.pojo.Applylist;
import com.shiyi.mybatis_plus.mapper.ApplylistMapper;
import com.shiyi.mybatis_plus.pojo.Companyinfo;
import com.shiyi.mybatis_plus.pojo.Userrole;
import com.shiyi.mybatis_plus.service.IApplylistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-08
 */
@Service
public class ApplylistServiceImpl extends ServiceImpl<ApplylistMapper, Applylist> implements IApplylistService {

    @Autowired
    private ApplylistServiceImpl applylistService;
    @Autowired
    private UserroleServiceImpl userroleService;
    @Autowired
    private CompanyinfoServiceImpl companyinfoService;

    @Autowired
    private FileService fileService;

    public Mono<Boolean> saveApply(Applylist applylist) {
        applylist.setType(0);
        return Mono.just(applylistService.saveOrUpdate(applylist));
    }

    @SneakyThrows
    public Mono<String> uploadImg(Mono<FilePart> file) {
        return fileService.cosUpload(file, Route.APPLY);
    }

    public Mono<Page<Applylist>> getAll(Integer pageNo, Integer pageSize, Integer type) {
        QueryWrapper<Applylist> a = new QueryWrapper<>();
        if (type != 4)
            a.eq("type", type);
        return Mono.just(applylistService.page(
                new Page<Applylist>().setCurrent(pageNo).setSize(pageSize), a));
    }

    public Mono<Applylist> getByApplyId(Integer id) {
        return Mono.just(applylistService.getById(id));
    }

    public Mono<Result> passApplyId(Integer id) {
        Applylist apply= applylistService.getById(id);
        userroleService.saveOrUpdate(new Userrole().setLoginId(apply.getLoginid()).setType(1));
        companyinfoService.save(new Companyinfo()
                .setLoginId(apply.getLoginid())
                .setCompanyname(apply.getUnitname()));
       if( applylistService.saveOrUpdate(new Applylist().setType(2).setId(id))){
           return Mono.just(new Result<>().setCode(200));
       }else
           return Mono.just(new Result<>().setCode(400).setMsg("失败"));
    }
}
