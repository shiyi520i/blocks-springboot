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

/**
 * <p>
 * 
 * </p>
 *
 * @author ShiYi
 * @since 2022-04-06
 */
@Getter
@Setter
@TableName("t_bus_news")
@ApiModel(value = "News对象", description = "")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("文章标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("作者id")
    @TableField("authorid")
    private String authorid;

    @ApiModelProperty("文章内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("夸")
    @TableField("greatnum")
    private Integer greatnum;

    @ApiModelProperty("浏览人数")
    @TableField("scannum")
    private Integer scannum;

    @ApiModelProperty("文章摘要")
    @TableField("summary")
    private String summary;

    @ApiModelProperty("作者")
    @TableField(exist = false)
    private String author;

    @TableField("html")
    private String html;

    @TableField("`time`")
    private LocalDateTime time;

    @ApiModelProperty("预览图")
    @TableField("image")
    private String image;

    @ApiModelProperty("头像")
    @TableField(exist = false)
    private String avatar;
}
