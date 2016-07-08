/**
 * Chsi
 * Created on 2016年7月7日
 */
package com.bala.role.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bala.core.dao.BaseHibernateDao;
import com.bala.role.dao.RoleDao;
import com.bala.role.model.Role;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
@Repository("roleDao")
public class RoleDaoImpl extends BaseHibernateDao implements RoleDao {

    @Override
    public List<Role> getRolesByUserId(String userId) {
        //for test
        List<Role> roles=new ArrayList<Role>();
        roles.add(new Role("111", "admin"));
        return roles;
    }

}
