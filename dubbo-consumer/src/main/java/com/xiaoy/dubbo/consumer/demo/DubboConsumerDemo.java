package com.xiaoy.dubbo.consumer.demo;

import com.xiaoy.dubbo.api.DubboDemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @Auther: 小y
 * @Date: 2019/3/24 21:35
 * @Description:
 */
@Component
public class DubboConsumerDemo {

    @Reference(version = "1.0.0", url = "dubbo://192.168.190.1:12345")
    private DubboDemoService dubboDemoService;

    public String demoInvoke(String str){
        return dubboDemoService.demo(str);
    }
}
