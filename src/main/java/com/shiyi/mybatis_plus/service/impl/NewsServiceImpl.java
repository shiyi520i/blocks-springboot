package com.shiyi.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyi.mybatis_plus.common.Result;
import com.shiyi.mybatis_plus.mapper.UserMapper;
import com.shiyi.mybatis_plus.pojo.News;
import com.shiyi.mybatis_plus.mapper.NewsMapper;
import com.shiyi.mybatis_plus.pojo.User;
import com.shiyi.mybatis_plus.service.INewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-06
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

    @Autowired
    private NewsServiceImpl newsService;
    @Autowired
    private UserMapper userMapper;

    public Mono<String> saveNews(News news) {
        return newsService.save(news) ? Mono.just("发布成功") : Mono.just("发布失败");
    }

    public Mono<IPage<News>> getSimple(Integer pageNo, Integer pageSzie) {
        Page<News> page = newsService.page(new Page<News>().setCurrent(pageNo).setSize(pageSzie));
        page.getRecords().stream().map(y -> {
            User user = userMapper.getOneByLoginId(y.getAuthorid());
            y.setAvatar(user.getAvatar());
            y.setAuthor(user.getUsername());
            return y;
        }).collect(Collectors.toList());
        return Mono.just(page);
    }

    public Mono<News> getByNewsId(Integer id) {
        News byId = newsService.getById(id);
        User user = userMapper.getOneByLoginId(byId.getAuthorid());
        byId.setAuthor(user.getUsername());
        byId.setAvatar(user.getAvatar());
        return Mono.just(byId);
    }

    public Mono<Result> remove(News news) {
        return newsService.removeById(news.getId()) ?
                Mono.just(new Result().setCode(200).setMsg("删除成功")) :
                Mono.just(new Result().setCode(400).setMsg("删除失败"));
    }
}
