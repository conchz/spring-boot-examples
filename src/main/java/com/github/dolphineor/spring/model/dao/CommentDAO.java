package com.github.dolphineor.spring.model.dao;

import com.github.dolphineor.spring.model.entity.CommentEntity;

/**
 * Created on 2015-09-15.
 *
 * @author dolphineor
 */
public interface CommentDAO extends RepositoryDB<CommentEntity, String> {

    @Override
    default Class<? extends CommentEntity> clazz() {
        return CommentEntity.class;
    }
}
