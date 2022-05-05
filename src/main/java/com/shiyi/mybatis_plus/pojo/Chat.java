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
 * @since 2022-04-25
 */
@Getter
@Setter
@TableName("t_bus_chat")
@ApiModel(value = "Chat对象", description = "")
public class Chat implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("发送者id")
    @TableField("sender")
    private String sender;

    @ApiModelProperty("接收者id")
    @TableField("receiver")
    private String receiver;

    @ApiModelProperty("时间")
    @TableField("`time`")
    private String time;

    @ApiModelProperty("消息内容")
    @TableField("message")
    private String message;


}
