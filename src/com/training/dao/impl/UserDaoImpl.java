package com.training.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.training.dao.UserDao;
import com.training.model.UserModel;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	// 注册用户
	@Override
	public void saveUser(UserModel userModel) {
		Session session = this.getSessionFactory().getCurrentSession();
		session.save(userModel);

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 用户登录
	@Override
	public List<UserModel> queryUser(UserModel userModel) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from UserModel where userName=? and  password=?";
		Query query = session.createQuery(hql).setParameter(0, userModel.getUserName()).setParameter(1,
				userModel.getPassword());
		return query.list();
	}

	// 验证用户名唯一
	@Override
	public List<UserModel> queryUserByUserName(String userName) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from UserModel where userName=?";
		Query query = session.createQuery(hql).setParameter(0, userName);
		return query.list();

	}

}
