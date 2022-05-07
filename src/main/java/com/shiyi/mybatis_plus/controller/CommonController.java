package com.shiyi.mybatis_plus.controller;

import com.shiyi.mybatis_plus.Utils.Route;
import com.shiyi.mybatis_plus.common.PasswordFrom;
import com.shiyi.mybatis_plus.service.impl.CommonServiceImpl;
import com.shiyi.mybatis_plus.service.impl.FileService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author ：ShiYI
 * @date ：Created in 2022/5/5
 */
@RestController("/upload")
public class CommonController {

    @Autowired
    private FileService fileService;
    @Autowired
    private CommonServiceImpl commonService;

    @SneakyThrows
    @RequestMapping(value = "avatar", method = RequestMethod.POST)
    public Mono<String> uploadAvatar(@RequestPart("file") Mono<FilePart> file) {
        return fileService.cosUpload(file, Route.APPLY);
    }

    @SneakyThrows
    @RequestMapping(value = "logo", method = RequestMethod.POST)
    public Mono<String> uploadLogo(@RequestPart("file") Mono<FilePart> file) {
        return fileService.cosUpload(file, Route.LOGO);
    }

    @SneakyThrows
    @RequestMapping(value = "CV", method = RequestMethod.POST)
    public Mono<String> uploadCV(@RequestPart("file") Mono<FilePart> file) {
        return fileService.cosUpload(file, Route.CV);
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.POST)
    public Boolean changePassword(@RequestBody PasswordFrom passwordFrom) {
        return commonService.changePassword(passwordFrom);
    }
}

