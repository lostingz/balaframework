/**
 * Chsi
 * Created on 2016年7月7日
 */
package com.bala.core.handler.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
            throws IOException, ServletException {
        // response.sendRedirect(request.getContextPath()+url);
        System.out.println("login success");
        request.getRequestDispatcher(url).forward(request, response);
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
