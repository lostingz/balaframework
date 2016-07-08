/**
 * Chsi
 * Created on 2016年7月7日
 */
package com.bala.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.bala.core.dao.BaseHibernateDao;
import com.bala.user.dao.UserDao;
import com.bala.user.model.User;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
@Repository("userDao")
public class UserDaoImpl extends BaseHibernateDao implements UserDao {

    @Override
    public User getUserByAccount(String account) {
        return new User("1", "111", "111");// for test
    }
}
