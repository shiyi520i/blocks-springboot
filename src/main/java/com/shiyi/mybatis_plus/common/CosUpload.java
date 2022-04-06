package com.shiyi.mybatis_plus.common;

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
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author ：ShiYI
 * @date ：Created in 2022/4/6
 */
@Component
public class CosUpload {
    @Autowired
    private CosProperties cosProperties;

    public  String cosUpload(File file) {
        String key = "images/";
        COSCredentials cred = new BasicCOSCredentials(cosProperties.getSecretId(), cosProperties.getSecretKey());
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        ClientConfig clientConfig = new ClientConfig(new Region(cosProperties.getRegion()));
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        PutObjectRequest putObjectRequest = new PutObjectRequest(cosProperties.getBucket(), key + file.getName(), file);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        return "https://1-1310671968.cos.ap-guangzhou.myqcloud.com/"+key+file.getName();

    }
}
