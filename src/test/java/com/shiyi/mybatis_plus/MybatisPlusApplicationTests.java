package com.shiyi.mybatis_plus;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.Bucket;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.shiyi.mybatis_plus.mapper.ParameterMapper;
import com.shiyi.mybatis_plus.pojo.Parameter;
import com.shiyi.mybatis_plus.service.impl.ParameterServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private ParameterServiceImpl parameterService;
    @Autowired
    private ParameterMapper parameterMapper;

    @Test
    void test2() {
        String[] arr = {"ma", "zhi", "chu", "is", "java", "developer", "family"};
        Stream<String> stream1 = Arrays.stream(arr);

        String sentence = "ma zhi chu is a Java wechat official account.";
        //匹配非单词\W
        Stream<String> wordStream = Pattern.compile("\\W")
                .splitAsStream(sentence);
        String[] wordArr = wordStream.toArray(String[]::new);
        System.out.println(Arrays.toString(wordArr));


    }

    @Test
    void test3() {
        // 1 初始化用户身份信息（secretId, secretKey）。
        // SECRETID和SECRETKEY请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String secretId = "AKIDrWv4xYswjFvLVNyHK6bpnUt1sTnqc8MJ";
        String secretKey = "h8LHwJQGp68sLXT8VbQyEDvMWP1MQDLC";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-guangzhou");
        ClientConfig clientConfig = new ClientConfig(region);
        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        List<Bucket> buckets = cosClient.listBuckets();
        for (Bucket bucketElement : buckets) {
            String bucketName = bucketElement.getName();
            System.out.println(bucketName);
            String bucketLocation = bucketElement.getLocation();
            System.out.println(bucketLocation);
        }

        // 指定要上传的文件
        File localFile = new File("C:\\Users\\shiyi520\\Desktop\\论文材料\\logo.png");
        // 指定文件将要存放的存储桶
        String bucketName = "1-1310671968";
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = "images/logo.png";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        System.out.println(putObjectResult);

    }

    @Test
    public void test4() {
        Map<String,List<Parameter>> a = new HashMap() {
        };
        List<Parameter> p = parameterMapper.getAllByPid(0);
        for (Parameter parameter : p) {
            a.put(parameter.getCode(),parameterMapper.selectList(new QueryWrapper<Parameter>().eq(parameter.getPid().toString(), parameter.getId())));
        }

        System.out.println(JSON.toJSONString(p));
        System.out.println(JSON.toJSONString(a));


    }


    @Test
    public void test5() {

    }
}
