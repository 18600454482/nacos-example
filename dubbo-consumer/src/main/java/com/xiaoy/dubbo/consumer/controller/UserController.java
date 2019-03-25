package com.xiaoy.dubbo.consumer.controller;

import com.xiaoy.dubbo.api.UserDTO;
import com.xiaoy.dubbo.api.UserDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private UserDubboService userDubboService;

    @GetMapping("/byName/{name}")
    public UserDTO get(@PathVariable("name") String name){
        return userDubboService.getByName(name);
    }

    @GetMapping("/application/properties")
    public String getProperties(){
        return userDubboService.getApplicationProperties();
    }

    @GetMapping("/value")
    public String getValue(){
        return userDubboService.getValue();
    }
}
