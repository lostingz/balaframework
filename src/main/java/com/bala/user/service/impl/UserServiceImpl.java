/**
 * Chsi
 * Created on 2016年7月7日
 */
package com.bala.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bala.user.dao.UserDao;
import com.bala.user.model.User;
import com.bala.user.service.UserService;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByAccount(String account) {
        return userDao.getUserByAccount(account);
    }

}
