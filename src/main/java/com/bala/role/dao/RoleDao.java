/**
 * lostingz
 * Created on 2016年7月7日
 */
package com.bala.role.dao;

import java.util.List;

import com.bala.role.model.Role;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
public interface RoleDao {
    List<Role> getRolesByUserId(String userId);
}
