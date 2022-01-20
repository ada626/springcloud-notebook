package com.yxpj.springcloud.service.impli;

import com.yxpj.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-------client order8080 exception handler to paymentInfo_TimeOut,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-------client order8080 exception handler to paymentInfo_OK,/(ㄒoㄒ)/~~";
    }
}
