package com.xiaoy.dubbo.provider;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: 小y
 * @Date: 2019/3/24 21:57
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "xiaoy")
public class DemoProperties {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
