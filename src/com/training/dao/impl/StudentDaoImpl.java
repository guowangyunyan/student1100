package com.training.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.training.dao.StudentDao;
import com.training.model.StudentModel;
import com.training.page.Pagination;
import com.training.page.SearchResult;

public class StudentDaoImpl implements StudentDao {
	private SessionFactory sessionFactory;

	// 添加学生信息
	@Override
	public void saveStudent(StudentModel studentModel) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		session.save(studentModel);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 删除学生
	@Override
	public void deleteStudent(StudentModel studentModel) {
		Session session = this.getSessionFactory().getCurrentSession();
		// session.delete(studentModel);
		session.update(studentModel);
	}

	// 修改学生信息
	@Override
	public void updateStudent(StudentModel studentModel) {
		Session session = this.getSessionFactory().getCurrentSession();
		session.update(studentModel);

	}

	// 分页查询学生信息
	@Override
	public SearchResult<StudentModel> queryStudents(Pagination page) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from StudentModel where available=true Order By modifyTime DESC");
		query.setFirstResult(0);
		query.setMaxResults(10);
		List<StudentModel> list = query.list();
		SearchResult<StudentModel> searchResult = new SearchResult<StudentModel>();
		searchResult.setPage(page);
		searchResult.setResult(list);
		return searchResult;
	}

	// 根据id查询学生
	@Override
	public StudentModel queryStudent(Integer id) {
		Session session = this.getSessionFactory().getCurrentSession();
		StudentModel studentModel = session.get(StudentModel.class, id);
		return studentModel;
	}

}
