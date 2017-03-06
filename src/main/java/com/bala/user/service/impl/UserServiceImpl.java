/**
 * lostingz
 * Created on 2016年7月7日
 */
package com.bala.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bala.user.dao.UserDao;
import com.bala.user.model.User;
import com.bala.user.service.UserService;
import com.bala.user.vo.UserVO;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
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

    @Override
    public void createUser(User u) {
        userDao.createUser(u);
    }

    @Override
    public User getUserById(String uid) {
        return userDao.getUserById(uid);
    }

    @Override
    public void updateUser(User u) {
        userDao.updateUser(u);
    }

    @Override
    public void saveOrUpdateUser(User u) {
        userDao.saveOrUpdateUser(u);
    }

    @Override
    public List<UserVO> queryAll() {
        List<User> list=userDao.getList();
        List<UserVO> result=new ArrayList<>();
        list.forEach(user -> {
            UserVO vo=new UserVO();
            vo.setUserName(user.getAccount());
            result.add(vo);
        });
        return result;
    }
}
