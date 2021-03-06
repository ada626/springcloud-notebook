package com.yxpj.springcloud.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import com.yxpj.springcloud.common.CommonResult;
import com.yxpj.springcloud.entities.Payment;
import com.yxpj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if (result>0) {
            return new CommonResult(200,"插入成功，使用端口："+serverPort, result);
        }else{
            return new CommonResult(444,"插入数据库失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById!=null) {
            return new CommonResult(200,"插入成功，使用端口："+serverPort, paymentById);
        }else{
            return new CommonResult(555,"查询数据库失败啦");
        }
    }

    @GetMapping("/lb")
    public String getPayemntLb(){
        return serverPort;
    }

}
