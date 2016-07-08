/**
 * Chsi
 * Created on 2016年7月7日
 */
package com.bala.role.service;

import java.util.List;

import com.bala.role.model.Role;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public interface RoleService {
    List<Role> getRolesByUserId(String userId);
}
