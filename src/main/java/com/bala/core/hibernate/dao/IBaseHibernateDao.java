/**
 * lostingz
 * Created on 2016年7月8日
 */
package com.bala.core.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.type.Type;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 * @param <T>
 */
public interface IBaseHibernateDao<T> {
    void save(T t);

    void update(T t);

    void saveOrUpdate(T t);

    void delete(Class<T> cls, int id);

    T getObjectById(Class<T> cls, int id);

    List<T> findByHql(String hql, Object... values);

    /**
     * @param types
     *            {org.hibernate.type.*}
     */
    List<T> findBySql(String sql, Object[] args, Type[] types);

    SQLQuery createSQLQuery(String sql);

    Query createQuery(String hql);
}
