/**
 * lostingz
 * Created on 2016年7月7日
 */
package com.bala.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
@Controller
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);
    /**
     * 登录入口
     */
    @RequestMapping(value = {"/login"})
    public String login(@RequestParam(required = false) String error) {
        log.info("login......");
        if ("1".equals(error)) {
            log.info("验证失败！");
        } else if ("2".equals(error)) {
            log.info("你的帐号已登录，不允许重复登陆！");
        } else if ("3".equals(error)) {
            log.info("会话超时!");
        }
        return "login";
    }

    /**
     * 没有权限访问跳转url
     */
    @RequestMapping(value = "/denied")
    public String denied() {
        log.info("denied......");
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
