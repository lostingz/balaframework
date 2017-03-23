/**
 * Chsi
 * Created on 2017年03月23日
 */
package com.bala.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bala.user.vo.UserVO;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
@Controller
@RequestMapping(value = "/freemarker")
public class FreeMarkerTest {
    @RequestMapping(value = "/get")
    public String get(Model model) {
        model.addAttribute("name","Jack");
        UserVO u=new UserVO();
        u.setUserName("Birkhoff");
        u.setAge("23");
        u.setAddress("北京市朝阳区");
        model.addAttribute("user",u);
        return "freemarker/test/index";   
    }
}
