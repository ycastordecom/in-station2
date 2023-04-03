package com.uspsassa.phishing.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class TbOrder {
    /**
    * sid
    */
    @Schema(description="sid")
    private Integer sid;

    /**
    * 订单json
    */
    @Schema(description="订单json")
    private String orderJson;
}