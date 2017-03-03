/**
 * lostingz
 * Created on 2016年7月7日
 */
package com.bala.security.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bala.security.type.LoginErrorType;


/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
@Controller
public class LoginController {

    private static Logger log = Logger.getLogger(LoginController.class);

    /**
     * 登录入口
     */
    @RequestMapping(value = {"/login"})
    public String login(@RequestParam(required = false) String error) {
        for (LoginErrorType loginErrorType : LoginErrorType.values()) {
            if (StringUtils.equals(loginErrorType.getCode(), error)) {
                log.info(loginErrorType.getDesc());
            }
        }
        return "login";
    }

    /**
     * 没有权限访问跳转url
     */
    @RequestMapping(value = "/denied")
    public String denied() {
        User u= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info(String.format("Access Denied UserName:%s",u.getUsername()));
        return "denied";
    }

    /**
     * 超时跳转url
     */
    @RequestMapping(value = "/timeout")
    public String timedout() {
        log.info("timeout......");
        return "timedout";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
