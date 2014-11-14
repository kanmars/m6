package cn.kanmars.dao.dao;

import org.springframework.stereotype.Component;

import cn.kanmars.dao.base.BaseUserDAO;

@Component("userDAO")
public class UserDAO extends BaseUserDAO implements IUserDAO {

	/**
	 * Default constructor.  Can be used in place of getInstance()
	 */
	public UserDAO () {}


}