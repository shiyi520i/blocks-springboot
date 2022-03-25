package com.shiyi.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2022-03-24
 */
@Getter
@Setter
@TableName("t_bus_record")
@Accessors(chain = true)
@ApiModel(value = "Record对象", description = "")
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("公司id")
    @TableField("cid")
    private Integer cid;

    @ApiModelProperty("用户id")
    @TableField("uid")
    private String uid;

    @ApiModelProperty("职位名称")
    @TableField("post")
    private String post;

    @ApiModelProperty("类型，0：公司邀请面试，1：公司查看个人，2：个人投递简历")
    @TableField("`type`")
    private Integer type;

    @ApiModelProperty("时间")
    @TableField("`time`")
    private LocalDateTime time;


}
