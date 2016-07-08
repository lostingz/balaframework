/**
 * lostingz
 * Created on 2016年7月7日
 */
package com.bala.security.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bala.role.model.Role;
import com.bala.role.service.RoleService;
import com.bala.user.model.User;
import com.bala.user.service.UserService;


/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        User user = userService.getUserByAccount(account);
        // 账号密码错误，可以在这里手动抛出异常，让验证失败处理器AuthenticationFailureHandler进行处理
        Collection<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(user);
        boolean enables = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getAccount(),
                user.getPassword(), enables,
                accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return userDetails;
    }

    /**
     * 根据用户获取该用户拥有的角色
     * 
     * @param user
     * @return
     */
    private Set<GrantedAuthority> getGrantedAuthorities(User user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        List<Role> roles = roleService.getRolesByUserId(user.getId());
        if (roles != null) {
            for (Role role : roles) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        }
        return grantedAuthorities;
    }

}
