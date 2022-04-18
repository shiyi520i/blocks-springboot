package com.shiyi.mybatis_plus.pojo;

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
 * @since 2022-04-18
 */
@Getter
@Setter
@TableName("t_bus_weight")
@ApiModel(value = "Weight对象", description = "")
public class Weight implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("公司id")
    @TableId("loginid")
    private String loginid;

    @ApiModelProperty("权重")
    @TableField("weight")
    private Double weight;

    @ApiModelProperty("公司类型")
    @TableField(exist = false)
    private String type;

    @ApiModelProperty("公司名称")
    @TableField(exist = false)
    private String name;

}
