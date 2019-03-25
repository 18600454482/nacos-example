package com.xiaoy.dubbo.provider.service;

import com.alibaba.fastjson.JSON;
import com.xiaoy.dubbo.api.UserDTO;
import com.xiaoy.dubbo.api.UserDubboService;
import com.xiaoy.dubbo.provider.config.ApplicationProperties;
import com.xiaoy.dubbo.provider.dao.UserRepository;
import com.xiaoy.dubbo.provider.entity.User;
import com.xiaoy.dubbo.provider.utils.BeansUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.Objects;

/**
 * @Auther: 小y
 * @Date: 2019/3/24 21:08
 * @Description:
 */
@Service(version = "1.0.0")
@RefreshScope
public class UserDubboServiceImpl implements UserDubboService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Value("${xiaoy.name}")
    private String value;

    public String getApplicationProperties(){
        return JSON.toJSONString(applicationProperties);
    }

    public UserDTO getByName(String name) {
        User user = userRepository.findByName(name);
        if(Objects.isNull(user)) return null;
        return BeansUtils.convert(user, UserDTO.class);
    }

    @Override
    public String getValue() {
        return value;
    }
}
