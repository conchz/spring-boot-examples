package com.github.dolphineor.springboot.model.dao.impl;

import com.github.dolphineor.springboot.model.dao.AbstractRepositoryDB;
import com.github.dolphineor.springboot.model.dao.CommentDAO;
import com.github.dolphineor.springboot.model.entity.CommentEntity;
import org.springframework.stereotype.Repository;

/**
 * Created on 2015-09-15.
 *
 * @author dolphineor
 */
@Repository
public class CommentDAOImpl extends AbstractRepositoryDB<CommentEntity, String> implements CommentDAO {

}
