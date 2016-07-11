/**
 * lostingz
 * Created on 2016年7月7日
 */
package com.bala.user.service;

import com.bala.user.model.User;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
public interface UserService {
    public User getUserByAccount(String account);

    void createUser(User u);

    void updateUser(User u);

    void saveOrUpdateUser(User u);

    User getUserById(String uid);
}
