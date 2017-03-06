/**
 * lostingz
 * Created on 2016年7月7日
 */
package com.bala.user.dao;

import java.util.List;

import com.bala.user.model.User;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
public interface UserDao {
    User getUserByAccount(String account);

    void createUser(User u);

    User getUserById(String uid);

    void updateUser(User u);

    void saveOrUpdateUser(User u);
    
    List<User> getList();
}
