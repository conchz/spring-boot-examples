package com.github.dolphineor.springboot.service.impl;

import com.github.dolphineor.springboot.model.dao.UserDAO;
import com.github.dolphineor.springboot.model.entity.UserEntity;
import com.github.dolphineor.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

/**
 * Created on 2015-09-12.
 *
 * @author dolphineor
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public Collection<UserEntity> findAll(int pageNo, int pageSize) {
        return userDAO.findAll(pageNo, pageSize);
    }

    @Override
    public Collection<UserEntity> findByParams(Map<String, Object> params, int pageNo, int pageSize) {
        return userDAO.findByParams(params, pageNo, pageSize);
    }

    @Override
    public UserEntity findOne(String id) {
        return userDAO.findOne(id);
    }

    @Override
    public void insert(UserEntity userEntity) {
        userDAO.insert(userEntity);
    }

    @Override
    public void insert(Collection<UserEntity> userEntities) {
        userDAO.insert(userEntities);
    }

    @Override
    public void update(UserEntity userEntity) {
        userDAO.update(userEntity);
    }

    @Override
    public void delete(String id) {
        userDAO.delete(id);
    }
}
