/**
 * Chsi
 * Created on 2016年7月7日
 */
package com.bala.user.dao;

import com.bala.user.model.User;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public interface UserDao {
    User getUserByAccount(String account);
}
