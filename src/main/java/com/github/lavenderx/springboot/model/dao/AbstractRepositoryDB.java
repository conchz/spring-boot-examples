package com.github.lavenderx.springboot.model.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
 * @author Baymax
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
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(t);
            session.flush();
            tx.commit();
        } catch (final Exception ignored) {

        }
    }

    @Override
    public void insert(Collection<T> ts) {
        ts.forEach(this::insert);
    }

    @Override
    public void update(T t) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.update(t);
            session.flush();
            tx.commit();
        } catch (final Exception e) {
            e.printStackTrace();
            if (Objects.nonNull(tx)) {
                tx.rollback();
            }
        }
    }

    @Override
    public void delete(ID id) {
        T t = findOne(id);
        if (Objects.nonNull(t)) {
            Transaction tx = null;
            try (Session session = sessionFactory.openSession()) {
                tx = session.beginTransaction();
                session.delete(t);
                session.flush();
                tx.commit();
            } catch (final Exception e) {
                e.printStackTrace();
                if (Objects.nonNull(tx)) {
                    tx.rollback();
                }
            }
        }
    }
}
