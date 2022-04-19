package com.shiyi.mybatis_plus.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shiyi.mybatis_plus.Utils.Route;
import com.shiyi.mybatis_plus.common.Result;
import com.shiyi.mybatis_plus.pojo.News;
import com.shiyi.mybatis_plus.service.impl.FileService;
import com.shiyi.mybatis_plus.service.impl.NewsServiceImpl;
import lombok.SneakyThrows;
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
 * @since 2022-04-06
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsServiceImpl newsService;
    @Autowired
    private FileService fileService;


    @RequestMapping(value = "savenews", method = RequestMethod.POST)
    public Mono<String> saveNews(@RequestBody News news) {
        return newsService.saveNews(news);
    }

    @RequestMapping(value = "getsimple", method = RequestMethod.GET)
    public Mono<IPage<News>> getSimple(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return newsService.getSimple(pageNo, pageSize);
    }

    @RequestMapping(value = "getone", method = RequestMethod.GET)
    public Mono<News> getByNewsId(@RequestParam("id") Integer id) {
        return newsService.getByNewsId(id);
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public Mono<Result> remove(@RequestBody News news) {
        return newsService.remove(news);
    }

    @SneakyThrows
    @RequestMapping(value = "image", method = RequestMethod.POST)
    public Mono<String> single(@RequestPart("file") Mono<FilePart> file) {
        return fileService.cosUpload(file, Route.NEWS);
    }

}

