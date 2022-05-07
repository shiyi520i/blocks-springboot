package com.shiyi.mybatis_plus.service.impl;

import cn.authing.core.mgmt.ManagementClient;
import cn.authing.core.types.UpdateUserInput;
import cn.authing.core.types.User;
import com.shiyi.mybatis_plus.common.PasswordFrom;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

/**
 * @author ：ShiYI
 * @date ：Created in 2022/5/7
 */
@Service
public class CommonServiceImpl {

    /**
     *  修改用户密码
     * @author ShiYi
     * @param passwordFrom 用户密码表单
     * @return java.lang.Boolean
     * @date 2022/5/7 13:06
     */
    @SneakyThrows
    public Boolean changePassword(PasswordFrom passwordFrom){
        ManagementClient managementClient = new ManagementClient("6225994033dc7822bc36710f", "3a04ac71dccce0cadc30fb67e18230ce");
        // 获取管理员权限
        managementClient.requestToken().execute();
        User result = managementClient.users()
                .update(passwordFrom.getLoginId(), new UpdateUserInput().withPassword(passwordFrom.getPassword()))
                .execute();
        return true;
    }
}
