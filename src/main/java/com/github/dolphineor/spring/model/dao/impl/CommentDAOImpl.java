package com.github.dolphineor.spring.model.dao.impl;

import com.github.dolphineor.spring.model.dao.CommentDAO;
import com.github.dolphineor.spring.model.entity.CommentEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;

/**
 * Created on 2015-09-15.
 *
 * @author dolphineor
 */
@Repository
public class CommentDAOImpl implements CommentDAO {

    @Resource
    private SessionFactory sessionFactory;


    @Override
    public Collection<CommentEntity> findAll() {
        return null;
    }

    @Override
    public Collection<CommentEntity> findByParams(Map<String, Object> params) {
        return null;
    }

    @Override
    public CommentEntity findOne(String s) {
        return null;
    }

    @Override
    public void insert(CommentEntity commentEntity) {

    }

    @Override
    public void insert(Collection<CommentEntity> commentEntities) {

    }

    @Override
    public void update(CommentEntity commentEntity) {

    }

    @Override
    public void delete(String s) {

    }
}
