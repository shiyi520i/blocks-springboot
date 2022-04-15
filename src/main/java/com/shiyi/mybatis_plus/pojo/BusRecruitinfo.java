package com.shiyi.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
 * @since 2022-03-21
 */
@Getter
@Setter
@TableName("t_bus_recruitinfo")
@ApiModel(value = "BusRecruitinfo对象", description = "")
public class BusRecruitinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "r_id", type = IdType.AUTO)
    private Integer rId;

    @ApiModelProperty("企业信息表id  外键")
    @TableField("e_id")
    private String eId;

    @ApiModelProperty("岗位名称")
    @TableField("r_post")
    private String rPost;

    @ApiModelProperty("职位描述")
    @TableField("r_jdescript")
    private String rJdescript;

    @ApiModelProperty("工作地址")
    @TableField("r_jaddress")
    private String rJaddress;

    @ApiModelProperty("范围（几年到几年或）")
    @TableField("r_jexperience")
    private Integer rJexperience;

    @ApiModelProperty("学历要求")
    @TableField("r_erequirement")
    private Integer rErequirement;

    @ApiModelProperty("工作职责")
    @TableField("r_jduty")
    private String rJduty;

    @ApiModelProperty("工作要求")
    @TableField("r_jrequirement")
    private String rJrequirement;

    @ApiModelProperty("招聘人数")
    @TableField("r_number")
    private Integer rNumber;

    @ApiModelProperty("最低薪资  0：面议")
    @TableField("r_minsalary")
    private String rMinsalary;

    @ApiModelProperty("0:关闭   1：开放")
    @TableField("r_status")
    private Integer rStatus;

    @ApiModelProperty("发布时间")
    @TableField("r_time")
    private String rTime;

    @ApiModelProperty("0:全职  1：兼职")
    @TableField("r_worktype")
    private Integer rWorktype;

    @ApiModelProperty("0:包吃 1：包住 2：包吃住")
    @TableField("r_welfare")
    private Integer rWelfare;

    @ApiModelProperty("1:已认证   0：未认证")
    @TableField("r_ischeck")
    private Integer rIscheck;

    @ApiModelProperty("是否急招   0：是  1：否")
    @TableField("r_stats")
    private Integer rStats;

    @ApiModelProperty("招聘年龄")
    @TableField("r_age")
    private String rAge;

    @ApiModelProperty("招聘开始时间")
    @TableField("r_starttime")
    private LocalDateTime rStarttime;

    @ApiModelProperty("招聘结束时间")
    @TableField("r_endtime")
    private LocalDateTime rEndtime;

    @ApiModelProperty("最高薪资  ：面议")
    @TableField("r_maxsalary")
    private String rMaxsalary;

    @TableField("r_province")
    private String rProvince;

    @TableField("r_city")
    private String rCity;

    @TableField("r_area")
    private String rArea;

    @ApiModelProperty("职业类型")
    @TableField("r_ztype")
    private String rZtype;

    @ApiModelProperty("职位福利")
    @TableField("r_welfares")
    private String rWelfares;

    @ApiModelProperty("联系人姓名")
    @TableField("conname")
    private String conName;

    @ApiModelProperty("联系人电话")
    @TableField("conphone")
    private String conPhone;

    @ApiModelProperty("联系人邮箱")
    @TableField("conemail")
    private String conEmail;

    @ApiModelProperty("公司名称")
    @TableField(exist = false)
    private String rname;

    @ApiModelProperty("工作logo")
    @TableField(exist = false)
    private String rlogo;

    @ApiModelProperty("公司类型")
    @TableField(exist = false)
    private String type;

    @ApiModelProperty("工作福利")
    @TableField(exist = false)
    private String[] welfares;

    @ApiModelProperty("工作年龄")
    @TableField(exist = false)
    private String jexperience;

    @ApiModelProperty("学历要求")
    @TableField(exist = false)
    private String erequirement;

    @ApiModelProperty("职位名称")
    @TableField(exist = false)
    private String post;

    @ApiModelProperty("统计记录")
    @TableField(exist = false)
    private List<Long> count;


}
