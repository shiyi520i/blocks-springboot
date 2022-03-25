package com.shiyi.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
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
@Builder
@Data
@TableName("t_bus_weight")
@ApiModel(value = "Weight对象", description = "")
public class Weight implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @ApiModelProperty("公司id")
    @TableField("cid")
    private Integer cid;

    @ApiModelProperty("公司名称")
    @TableField("`name`")
    private String name;

    @ApiModelProperty("行业类型")
    @TableField("`type`")
    private String type;

    @ApiModelProperty("权重")
    @TableField("weight")
    private Double weight;


}
