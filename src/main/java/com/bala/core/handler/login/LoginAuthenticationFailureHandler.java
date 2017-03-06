/**
 * lostingz
 * Created on 2016年7月7日
 */
package com.bala.core.handler.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.alibaba.fastjson.JSONObject;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException e) throws IOException, ServletException {
        // 根据AuthenticationException异常的类型
        // 进行出错业务逻辑处理
        // ...
        System.out.println("login auth error:"+e.getMessage());
        JSONObject object=new JSONObject();
        object.put("status","fail");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(object.toJSONString());
    }

}
