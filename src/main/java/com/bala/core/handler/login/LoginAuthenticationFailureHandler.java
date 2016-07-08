/**
 * Chsi
 * Created on 2016年7月7日
 */
package com.bala.core.handler.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException arg2) throws IOException, ServletException {
        // 根据AuthenticationException异常的类型
        // 进行出错业务逻辑处理
        // ...
        System.out.println("login auth error");
        response.sendRedirect(request.getContextPath() + "/login");
    }

}
