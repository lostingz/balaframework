/**
 * Chsi
 * Created on 2017年03月06日
 */
package com.bala.core.hibernate.interceptor;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

/**
 * 拦截hibernate事件
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class EventInterceptor extends EmptyInterceptor{
    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("execute save start");
        boolean flag= super.onSave(entity, id, state, propertyNames, types);
        System.out.println("execute save end");
        return flag;
    }
}
