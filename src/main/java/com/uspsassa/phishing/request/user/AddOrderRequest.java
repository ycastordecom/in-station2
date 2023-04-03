package com.uspsassa.phishing.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "订单添加请求体")
public class AddOrderRequest {
    @Schema(name = "sid")
    private String sid;
    @Schema(name = "orderJson",description = "订单json")
    private String orderJson;
}
