package com.shiyi.mybatis_plus.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ShiYi
 * @since 2022-03-29
 */
@Accessors(chain = true)
@Getter
@Setter
@TableName("t_sys_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("登录id")
    @TableId("login_id")
    private String loginId;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty("地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("简历地址")
    @TableField("cvurl")
    private String cvurl;

    @ApiModelProperty("毕业时间")
    @TableField("grtime")
    private String grtime;

    @ApiModelProperty("毕业学校")
    @TableField("graduate")
    private String graduate;

    @ApiModelProperty("期望职位")
    @TableField("position")
    private String position;

    @ApiModelProperty("头像地址")
    @TableField("avatar")
    private String avatar;

}
