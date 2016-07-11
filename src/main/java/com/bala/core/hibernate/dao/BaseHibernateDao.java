/**
 * lostingz
 * Created on 2016年7月7日
 */
package com.bala.core.hibernate.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

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

    @Override
    public void save(T t) {
        currentSession().save(t);
    }

    @Override
    public void update(T t) {
        currentSession().update(t);
    }

    @Override
    public void saveOrUpdate(T t) {
        currentSession().saveOrUpdate(t);
    }

    @Override
    public void delete(Class<T> cls,int id) {
        currentSession().delete(this.getObjectById(cls, id));
    }

    @Override
    public T getObjectById(Class<T> cls, int id) {
        return (T) currentSession().get(cls, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findByHql(String hql, Object... values) {
        HibernateTemplate hibernateTemplate = super.getHibernateTemplate();
        Query q = createQuery(hql);
        if (null == values) {
            return (List<T>) hibernateTemplate.find(hql);
        }
        return (List<T>) hibernateTemplate.find(hql, values);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findBySql(String sql, Object[] args, Type[] types) {
        SQLQuery q = currentSession().createSQLQuery(sql);
        if (null != args && args.length > 0) {
            q.setParameters(args, types);
        }
        return q.list();
    }

    public SQLQuery createSQLQuery(String sql) {
        Session session = currentSession();
        session.flush();
        return session.createSQLQuery(sql);
    }

    public Query createQuery(String hql) {
        Session session = currentSession();
        session.flush();
        return session.createQuery(hql);
    }
}