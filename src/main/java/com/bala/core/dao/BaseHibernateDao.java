/**
 * lostingz
 * Created on 2016年7月7日
 */
package com.bala.core.dao;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 * @param <T>
 */
public class BaseHibernateDao<T> extends HibernateDaoSupport implements IBaseHibernateDao<T> {
    // 注入SessionFactory
    @Resource(name = "sessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    private Class<T> entityClass;

    /**
     * 获取T对象的Class
     * 
     * @return
     */
    @SuppressWarnings({"unused", "unchecked"})
    private Class<T> getEntityClass() {
        if (entityClass == null) {
            entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return entityClass;

    }

    @Override
    public void save(T t) {
        super.getHibernateTemplate().save(t);
    }

    @Override
    public void update(T t) {
        super.getHibernateTemplate().update(t);
    }

    @Override
    public void saveOrUpdate(T t) {
        super.getHibernateTemplate().saveOrUpdate(t);
    }

    @Override
    public void delete(int id) {
        super.getHibernateTemplate().delete(this.getObjectById(id));
    }

    @Override
    public T getObjectById(int id) {
        return super.getHibernateTemplate().get(getEntityClass(), id);
    }
}
