package com.shiyi.mybatis_plus.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：ShiYI
 * @date ：Created in 2022/5/7
 */
@Data
@Accessors(chain = true)
public class PasswordFrom {
    private String loginId;
    private String originalPassword;
    private String password;
}
