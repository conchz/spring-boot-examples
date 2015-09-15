package com.github.dolphineor.spring.model.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * Created on 2015-09-15.
 *
 * @author dolphineor
 */
public interface RepositoryDB<T, ID extends Serializable> {

    Collection<T> findAll();

    Collection<T> findByParams(Map<String, Object> params);

    T findOne(ID id);

    void insert(T t);

    void insert(Collection<T> ts);

    void update(T t);

    void delete(ID id);

    Class<? extends T> clazz();

}
