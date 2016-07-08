/**
 * lostingz
 * Created on 2016年7月7日
 */
package com.bala.role.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bala.role.dao.RoleDao;
import com.bala.role.model.Role;
import com.bala.role.service.RoleService;


/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getRolesByUserId(String userId) {
        return roleDao.getRolesByUserId(userId);
    }

}
