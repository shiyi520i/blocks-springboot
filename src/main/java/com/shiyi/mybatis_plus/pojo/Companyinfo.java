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
 * @since 2022-03-22
 */
@Getter
@Setter
@TableName("t_bus_companyinfo")
@ApiModel(value = "Companyinfo对象", description = "")
public class Companyinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("login_id")
    private String loginId;

    @ApiModelProperty("公司名称")
    @TableField("companyname")
    private String companyname;

    @ApiModelProperty("类型")
    @TableField("`type`")
    private Integer type;

    @ApiModelProperty("公司规模")
    @TableField("`number`")
    private Integer number;

    @ApiModelProperty("座机")
    @TableField("landline")
    private String landline;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("省")
    @TableField("province")
    private String province;

    @ApiModelProperty("市")
    @TableField("city")
    private String city;

    @ApiModelProperty("区县")
    @TableField("area")
    private String area;

    @ApiModelProperty("具体地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("logo")
    @TableField("logo")
    private String logo;

    @ApiModelProperty("行业类型转换")
    @TableField(exist = false)
    private String TType;

}
