/**
 * lostingz
 * Created on 2016年7月7日
 */
package com.bala.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.bala.core.dao.BaseHibernateDao;
import com.bala.user.dao.UserDao;
import com.bala.user.model.User;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
@Repository("userDao")
public class UserDaoImpl extends BaseHibernateDao implements UserDao {

    @Override
    public User getUserByAccount(String account) {
        // just for test
        return new User("1", "111", "6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2");
    }
}
