package com.github.dolphineor.spring.service;

import com.github.dolphineor.spring.model.entity.CommentEntity;

import java.util.Collection;
import java.util.Map;

/**
 * Created on 2015-09-15.
 *
 * @author dolphineor
 */
public interface CommentService {

    Collection<CommentEntity> findAll();

    Collection<CommentEntity> findByParams(Map<String, Object> params);

    CommentEntity findOne(String id);

    void insert(CommentEntity commentEntity);

    void insert(Collection<CommentEntity> commentEntities);

    void update(CommentEntity commentEntity);

    void delete(String id);
}
