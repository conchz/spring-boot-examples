package com.github.lavenderx.springboot.model.dao.impl;

import com.github.lavenderx.springboot.model.dao.AbstractRepositoryDB;
import com.github.lavenderx.springboot.model.dao.UserDAO;
import com.github.lavenderx.springboot.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created on 2015-09-12.
 *
 * @author Baymax
 */
@Repository
public class UserDAOImpl extends AbstractRepositoryDB<UserEntity, String> implements UserDAO {

}
