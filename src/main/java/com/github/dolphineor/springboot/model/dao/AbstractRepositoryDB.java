package com.github.dolphineor.springboot.model.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * Created on 2015-10-23.
 *
 * @author dolphineor
 */
@SuppressWarnings("unchecked")
@Component
public abstract class AbstractRepositoryDB<T, ID extends Serializable> implements RepositoryDB<T, ID> {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Collection<T> findAll(int pageNo, int pageSize) {
        return sessionFactory.openSession()
                .createCriteria(clazz())
                .setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    @Override
    public Collection<T> findByParams(Map<String, Object> params, int pageNo, int pageSize) {
        Criteria criteria = sessionFactory.openSession().createCriteria(clazz());
        params.forEach((k, v) -> criteria.add(Restrictions.eq(k, v)));
        criteria.setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize);

        return criteria.list();
    }

    @Override
    public T findOne(ID id) {
        return sessionFactory.openSession().get(clazz(), id);
    }

    @Override
    public void insert(T t) {
        sessionFactory.openSession().persist(t);
    }

    @Override
    public void insert(Collection<T> ts) {
        Session session = sessionFactory.openSession();
        ts.forEach(session::persist);
    }

    @Override
    public void update(T t) {
        sessionFactory.openSession().update(t);
    }

    @Override
    public void delete(ID id) {
        T t = findOne(id);
        if (Objects.nonNull(t))
            sessionFactory.openSession().delete(t);
    }
}
