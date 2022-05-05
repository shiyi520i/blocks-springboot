package com.shiyi.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
 * @since 2022-04-08
 */
@Accessors(chain = true)
@Getter
@Setter
@TableName("t_bus_applylist")
@ApiModel(value = "Applylist对象", description = "")
public class Applylist implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("营业执照号码")
    @TableId("id")
    private Integer id;

    @ApiModelProperty("登录id")
    @TableField("loginid")
    private String loginid;

    @ApiModelProperty("单位名称")
    @TableField("unitname")
    private String unitname;

    @ApiModelProperty("证件地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("营业执照照片")
    @TableField("license")
    private String license;

    @ApiModelProperty("法定代表人姓名")
    @TableField("represent")
    private String represent;

    @ApiModelProperty("法定代表人电话")
    @TableField("representphone")
    private String representphone;

    @ApiModelProperty("身份证号码")
    @TableField("`number`")
    private Integer number;

    @ApiModelProperty("身份证正面照地址")
    @TableField("frontimg")
    private String frontimg;

    @ApiModelProperty("身份证反面照地址")
    @TableField("backimg")
    private String backimg;

    @ApiModelProperty("手持身份证照地址")
    @TableField("handimg")
    private String handimg;

    @ApiModelProperty("联系人电话号码")
    @TableField("phone")
    private Integer phone;

    @ApiModelProperty("提交时间")
    @TableField("`time`")
    private LocalDateTime time;

    @ApiModelProperty("审核状态，0:未审核，1：未通过，2：已通过")
    @TableField("`type`")
    private Integer type;


}
