package com.shiyi.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-21
 */
@Accessors(chain = true)
@Getter
@Setter
@TableName("t_sys_userrole")
@ApiModel(value = "Userrole对象", description = "")
public class Userrole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("登录id，与三表关联")
    @TableId("login_id")
    private String loginId;

    @ApiModelProperty("用户角色，0：管理员，1：企业，2：用户")
    @TableField("`type`")
    private Integer type;


}
