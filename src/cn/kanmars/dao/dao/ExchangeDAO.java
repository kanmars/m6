package cn.kanmars.dao.dao;

import java.util.List;


import org.hibernate.Query;
import org.springframework.stereotype.Component;

import cn.kanmars.dao.base.BaseExchangeDAO;

public class ExchangeDAO extends BaseExchangeDAO implements IExchangeDAO {

	/**
	 * Default constructor.  Can be used in place of getInstance()
	 */
	public ExchangeDAO () {}
	
	public Query getQuery(String hql){
		return this.getSession().createQuery(hql);
	}

}