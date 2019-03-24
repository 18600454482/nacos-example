package com.xiaoy.dubbo.provider;

import com.xiaoy.dubbo.api.DubboDemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Auther: 小y
 * @Date: 2019/3/24 21:08
 * @Description:
 */
@Service(version = "1.0.0")
public class DubboDemoServiceImpl implements DubboDemoService {
    @Value("${xiaoy}")
    private String name;

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Autowired
    private DemoProperties properties;

    public String demo(String str) {
        return str + ":" + this.name + ":" + properties.getName() + ":" + properties.getAge() + ":" + jdbcUrl;
    }
}
