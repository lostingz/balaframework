/**
 * lostingz
 * Created on 2016年7月7日
 */
package com.bala.user.dao.impl;

import java.util.List;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.bala.core.hibernate.dao.BaseHibernateDao;
import com.bala.user.dao.UserDao;
import com.bala.user.model.User;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
@Repository("userDao")
public class UserDaoImpl extends BaseHibernateDao<User> implements UserDao {

    
    @Override
    public User getUserByAccount(String account) {
        // just for test
        return new User("1", "111", new ShaPasswordEncoder().encodePassword("1234",null));
    }

    @Override
    public void createUser(User u) {
        save(u);
    }

    @Override
    public User getUserById(String uid) {
        List<User> l = findByHql("from User where id=?", uid);
        return l.isEmpty() ? null : l.get(0);
    }

    @Override
    public void updateUser(User u) {
        update(u);
    }

    @Override
    public void saveOrUpdateUser(User u) {
        saveOrUpdate(u);
    }

}
