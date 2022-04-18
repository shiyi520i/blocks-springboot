package com.shiyi.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-14
 */
@Getter
@Setter
@TableName("t_sys_parameter")
@ApiModel(value = "Parameter对象", description = "")
public class Parameter implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("子节点id")
    @TableId(value = "id")
    private Integer id;

    @ApiModelProperty("父节点id")
    @TableField("pid")
    private Integer pid;

    @ApiModelProperty("参数名称")
    @TableField("`name`")
    private String name;

    @ApiModelProperty("参数代号")
    @TableField("code")
    private String code;


}
