package com.github.dolphineor.springboot.model.dao;

import com.github.dolphineor.springboot.model.entity.UserEntity;

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
