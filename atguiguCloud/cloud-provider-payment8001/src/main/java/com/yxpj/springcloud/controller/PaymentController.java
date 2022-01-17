package com.yxpj.springcloud.controller;

import com.yxpj.springcloud.common.CommonResult;
import com.yxpj.springcloud.entities.Payment;
import com.yxpj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("********insert payment to db: "+result);
        if (result>0) {
            //方法体内部会new，这里就不用写new 了
            return CommonResult.success(result);
        }else{
            return new CommonResult(444,"插入数据库失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("********get payment from db: "+paymentById+"O(∩_∩)O~,好耶!");
        if (paymentById!=null) {
            //方法体内部会new，这里就不用写new 了
            return CommonResult.success(paymentById);
        }else{
            return new CommonResult(555,"查询数据库失败啦");
        }
    }
}
