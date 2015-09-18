package com.github.dolphineor.spring.service.impl;

import com.github.dolphineor.spring.model.dao.CommentDAO;
import com.github.dolphineor.spring.model.entity.CommentEntity;
import com.github.dolphineor.spring.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;

/**
 * Created on 2015-09-15.
 *
 * @author dolphineor
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDAO commentDAO;


    @Override
    public Collection<CommentEntity> findAll(int pageNo, int pageSize) {
        return commentDAO.findAll(pageNo, pageSize);
    }

    @Override
    public Collection<CommentEntity> findByParams(Map<String, Object> params, int pageNo, int pageSize) {
        return commentDAO.findByParams(params, pageNo, pageSize);
    }

    @Override
    public CommentEntity findOne(String id) {
        return commentDAO.findOne(id);
    }

    @Override
    public void insert(CommentEntity commentEntity) {
        commentDAO.insert(commentEntity);
    }

    @Override
    public void insert(Collection<CommentEntity> commentEntities) {
        commentDAO.insert(commentEntities);
    }

    @Override
    public void update(CommentEntity commentEntity) {
        commentDAO.update(commentEntity);
    }

    @Override
    public void delete(String id) {
        commentDAO.delete(id);
    }
}
