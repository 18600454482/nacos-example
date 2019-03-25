package com.xiaoy.dubbo.api;

/**
 * @Auther: 小y
 * @Date: 2019/3/24 21:02
 * @Description:
 */
public interface UserDubboService {
    String getApplicationProperties();

    UserDTO getByName(String name);

    String getValue();
}
