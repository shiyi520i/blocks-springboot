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
 * @since 2022-03-24
 */
@Getter
@Setter
@TableName("t_bus_sortpost")
@ApiModel(value = "Sortpost对象", description = "")
public class Sortpost implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @ApiModelProperty("职位id")
    @TableField("postid")
    private Integer postid;

    @ApiModelProperty("职位名称")
    @TableField("`name`")
    private String name;

    @ApiModelProperty("权重")
    @TableField("weight")
    private Double weight;


}
