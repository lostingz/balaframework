/**
 * lostingz
 * Created on 2016年7月8日
 */
package com.bala.core.dao;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 * @param <T>
 */
public interface IBaseHibernateDao<T> {
    public void save(T t);

    public void update(T t);

    public void saveOrUpdate(T t);

    public void delete(int id);

    public T getObjectById(int id);
}
