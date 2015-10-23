package com.github.dolphineor.springboot.model.dao.impl;

import com.github.dolphineor.springboot.model.dao.AbstractRepositoryDB;
import com.github.dolphineor.springboot.model.dao.UserDAO;
import com.github.dolphineor.springboot.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created on 2015-09-12.
 *
 * @author dolphineor
 */
@Repository
public class UserDAOImpl extends AbstractRepositoryDB<UserEntity, String> implements UserDAO {

}
