package com.github.dolphineor.spring.model.dao;

import com.github.dolphineor.spring.main.ApplicationBoot;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * Created on 2015-09-15.
 *
 * @author dolphineor
 */
@SuppressWarnings("unchecked")
public interface RepositoryDB<T, ID extends Serializable> {

    SessionFactory sessionFactory = ApplicationBoot.getApplicationContext().getBean(SessionFactory.class);


    Class<? extends T> clazz();

    default Collection<T> findAll(int pageNo, int pageSize) {
        return sessionFactory.openSession()
                .createCriteria(clazz())
                .setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    default Collection<T> findByParams(Map<String, Object> params, int pageNo, int pageSize) {
        Criteria criteria = sessionFactory.openSession().createCriteria(clazz());
        params.forEach((k, v) -> criteria.add(Restrictions.eq(k, v)));
        criteria.setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize);

        return criteria.list();
    }

    default T findOne(ID id) {
        return sessionFactory.openSession().get(clazz(), id);
    }

    default void insert(T t) {
        sessionFactory.openSession().persist(t);
    }

    default void insert(Collection<T> ts) {
        Session session = sessionFactory.openSession();
        ts.forEach(session::persist);
    }

    default void update(T t) {
        sessionFactory.openSession().update(t);
    }

    default void delete(ID id) {
        T t = findOne(id);
        if (Objects.nonNull(t))
            sessionFactory.openSession().delete(t);
    }

}
