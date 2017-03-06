/**
 * Chsi
 * Created on 2017年03月06日
 */
package com.bala.user.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bala.user.model.User;
import com.bala.user.service.UserService;
import com.bala.user.vo.UserVO;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/list")
    @ResponseBody
    public List<UserVO> list(){
        return userService.queryAll();
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public boolean add(@RequestParam(value = "account",required = true)String account, @RequestParam(value = "passwd",required = true)String passwd){
        if(StringUtils.isNoneBlank(account)&&StringUtils.isNotBlank(passwd)){
            User user=new User(account,passwd);
            userService.createUser(user);
            return true;
        }
        return false;  
    }
}
