package com.github.lavenderx.springboot.service;

import java.util.Collection;
import java.util.Map;

/**
 * Created on 2015-09-20.
 *
 * @author dolphineor
 */
public interface BaseService<T> {

    Collection<T> findAll(int pageNo, int pageSize);

    Collection<T> findByParams(Map<String, Object> params, int pageNo, int pageSize);

    T findOne(String id);

    void insert(T t);

    void insert(Collection<T> ts);

    void update(T t);

    void delete(String id);
}
