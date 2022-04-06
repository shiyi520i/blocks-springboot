package com.shiyi.mybatis_plus.support;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ：ShiYI
 * @date ：Created in 2022/4/6
 */
@Data
@ConfigurationProperties("cos")
public class CosProperties {

    /**
     * 存储对象id
     */
    private String secretId;

    /**
     * 存储对象秘钥
     */
    private String secretKey;

    /**
     * 存储对象地域
     */
    private String region;

    /**
     * 存储对象名称
     */
    private String bucket;
}
