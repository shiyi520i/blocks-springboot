package com.shiyi.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyi.mybatis_plus.common.Result;
import com.shiyi.mybatis_plus.pojo.News;
import com.shiyi.mybatis_plus.mapper.NewsMapper;
import com.shiyi.mybatis_plus.service.INewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

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

    public Mono<String> saveNews(News news) {
        return newsService.save(news)?Mono.just("发布成功"):Mono.just("发布失败");

    }

    public Mono<IPage<News>> getSimple(Integer pageNo,Integer pageSzie) {
        return Mono.just(newsService.page(new Page<News>().setCurrent(pageNo).setSize(pageSzie)));
    }

    public Mono<News> getByNewsId(Integer id) {
        return Mono.just(newsService.getById(id));
    }

    public Mono<String> remove(News news) {
        return newsService.removeById(news.getId())?Mono.just("删除成功"):Mono.just("删除失败");
    }
}
