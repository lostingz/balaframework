/**
 * Chsi
 * Created on 2017年03月06日
 */
package com.bala.user.model;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class SaltedUser extends org.springframework.security.core.userdetails.User {
    private String salt;

    public SaltedUser(String username, String password, boolean enabled,
                      boolean accountNonExpired, boolean credentialsNonExpired,
                      boolean accountNonLocked, Set<GrantedAuthority> authorities, String salt) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}  