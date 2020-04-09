package com.pet.lovepet.base;

import com.pet.lovepet.entity.User;
import com.pet.lovepet.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * @Author: 彭志鹏
 * @DateTime: 2020/4/9 10:03
 * @Description:
 */
@Slf4j
@Controller
public abstract class BaseController<T> {

    public static final String CURRENT_USER = "CURRENT_USER";
    @Value("${server.title}")
    public String serverTitle;


    @Value("${server.logo}")
    public String serverLogo;

    @Autowired
    private UserService userService;

    public User getCurrentUser() {
        String loginName= SecurityUtils.getSubject().getPrincipal().toString();
        return userService.findUserByLoginName(loginName);
    }
}
