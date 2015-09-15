package com.github.dolphineor.spring.model.dao;

import com.github.dolphineor.spring.model.entity.UserEntity;

/**
 * Created on 2015-09-12.
 *
 * @author dolphineor
 */
public interface UserDAO extends RepositoryDB<UserEntity, String> {

    @Override
    default Class<? extends UserEntity> clazz() {
        return UserEntity.class;
    }
}
