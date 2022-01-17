package com.yxpj.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T date;

    public CommonResult(Integer code,String message){
        this.code=code;
        this.message = message;
    }

    public static <T> CommonResult<T> success(){
        return new CommonResult<>(200,"success");
    }

    public static <T> CommonResult<T> success(T result){
        return new CommonResult<>(200,"success",result);
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
