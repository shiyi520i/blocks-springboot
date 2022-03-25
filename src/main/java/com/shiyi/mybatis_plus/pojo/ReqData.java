package com.shiyi.mybatis_plus.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ：ShiYI
 * @date ：Created in 2022/3/25
 */
@Data
public class ReqData {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("uid")
    String uid;
    @JsonProperty("postname")
    String postname;
}
