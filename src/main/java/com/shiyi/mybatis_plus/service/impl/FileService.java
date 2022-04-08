package com.shiyi.mybatis_plus.service.impl;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.shiyi.mybatis_plus.support.CosProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * @author ：ShiYI
 * @date ：Created in 2022/4/6
 */
@Component
public class FileService {

    @Autowired
    private FileService fileService;

    @Autowired
    private CosProperties cosProperties;

    public Mono<String> cosUpload(Mono<FilePart> file,String key) throws IOException {
        return file.map(filePart -> {
            Path tempFile = null;
            try {
                tempFile = Files.createTempFile(null, filePart.filename());
            } catch (IOException e) {
                e.printStackTrace();
            }
            AsynchronousFileChannel channel = null;
            try {
                channel = AsynchronousFileChannel.open(tempFile, StandardOpenOption.WRITE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            DataBufferUtils.write(filePart.content(), channel, 0).doOnComplete(() -> {
                System.out.println("finish");
            }).subscribe();
            return tempFile;
        }).map(Path::toFile).flatMap(f -> fileService.cosUpload(f,key));
    }


    public Mono<String> cosUpload(File file,String key) {
        //String key = "images/";
        COSCredentials cred = new BasicCOSCredentials(cosProperties.getSecretId(), cosProperties.getSecretKey());
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        ClientConfig clientConfig = new ClientConfig(new Region(cosProperties.getRegion()));
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        //  生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        //存储桶，文件夹，文件
        PutObjectRequest putObjectRequest = new PutObjectRequest(cosProperties.getBucket(), key + file.getName(), file);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        String calbackPath= "https://"+cosProperties.getBucket()+".cos."+cosProperties.getRegion()+".myqcloud.com/" + key + file.getName();
        return Mono.just(calbackPath);
    }
}