package com.shiyi.mybatis_plus.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 返回结果类
 *
 * @author ：ShiYI
 * @date ：Created in 2022/3/24
 */
@Data
@Accessors(chain = true)
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;
}
