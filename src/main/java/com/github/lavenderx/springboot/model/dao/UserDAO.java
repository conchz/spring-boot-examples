package com.github.lavenderx.springboot.model.dao;

import com.github.lavenderx.springboot.model.entity.UserEntity;

/**
 * Created on 2015-09-12.
 *
 * @author Baymax
 */
public interface UserDAO extends RepositoryDB<UserEntity, String> {

    @Override
    default Class<? extends UserEntity> clazz() {
        return UserEntity.class;
    }
}
