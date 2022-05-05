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
 * @since 2022-04-25
 */
@Accessors(chain = true)
@Getter
@Setter
@TableName("t_bus_chatlist")
@ApiModel(value = "Chatlist对象", description = "")
public class Chatlist implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @ApiModelProperty("联系人id")
    @TableField("`list`")
    private String list;

    @ApiModelProperty("登录id")
    @TableField("loginid")
    private String loginid;

    @ApiModelProperty("联系人姓名")
    @TableField(exist = false)
    private String name;

    @ApiModelProperty("联系人头像或logo")
    @TableField(exist = false)
    private String avatar;


}
