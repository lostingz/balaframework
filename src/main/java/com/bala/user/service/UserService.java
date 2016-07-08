/**
 * Chsi
 * Created on 2016年7月7日
 */
package com.bala.user.service;

import com.bala.user.model.User;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public interface UserService {
    public User getUserByAccount(String account);
}
