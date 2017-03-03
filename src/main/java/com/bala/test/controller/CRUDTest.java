/**
 * lostingz
 * Created on 2016年7月11日
 */
package com.bala.test.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bala.user.model.User;
import com.bala.user.service.UserService;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
@Controller
@RequestMapping(value = "/crud")
public class CRUDTest {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add")
    @ResponseBody
    public String add() {
        // userService.createUser(new User());
        userService.createUser(new User(UUID.randomUUID().toString(),"admin", "admin"));
        return "add success";
    }

    @RequestMapping(value = "/get")
    @ResponseBody
    public User get() {
        User u = userService.getUserById("2c908a9e55d824f30155d82521f50000");
        if (u == null) {
            return null;
        }
        return u;
    }

}
