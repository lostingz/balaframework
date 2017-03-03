/**
 * Chsi
 * Created on 2017年03月03日
 */
package com.bala.security.type;

/**
 * 登录错误信息枚举
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public enum LoginErrorType {
    
    AUTH_ERROR("1","验证失败"),
    HAS_LOGINED("2","你的帐号已登录，不允许重复登陆！"),
    SESSION_TIMEOUT("3","会话超时");
    
    private String code;
    private String desc;
    
    LoginErrorType(String code, String desc){
        this.code=code;
        this.desc=desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
