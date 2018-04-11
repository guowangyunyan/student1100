package com.training.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.training.convert.StudentDataConvert;
import com.training.convert.StudentModelConvert;
import com.training.dao.StudentDao;
import com.training.data.StudentData;
import com.training.form.StudentForm;
import com.training.model.StudentModel;
import com.training.page.Pagination;
import com.training.page.SearchResult;
import com.training.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentModelConvert studentModelConvert;
	private StudentDataConvert studentDataConvert;
	private StudentDao studentDao;

	// 添加学生
	@Override
	public void addStudent(StudentForm studentForm) {
		StudentModel studentModel = studentModelConvert.convert(studentForm);
		studentDao.saveStudent(studentModel);
	}

	// 查询学生信息
	@Override
	public SearchResult<StudentData> loadStudents(Pagination page) {
		SearchResult<StudentModel> searchResults = studentDao.queryStudents(page);
		SearchResult<StudentData> results = new SearchResult<StudentData>();
		List<StudentData> datas = new ArrayList<>();
		for (StudentModel model : searchResults.getResult()) {
			datas.add(studentDataConvert.convert(model));
		}
		results.setPage(searchResults.getPage());
		results.setResult(datas);
		return results;

	}

	// 删除学生信息
	@Override
	public void deleteStudent(StudentForm studentForm) {
		StudentModel studentModel = studentDao.queryStudent(studentForm.getId());
		studentModel.setAvailable(false);
		studentDao.updateStudent(studentModel);

	}

	// 修改学生信息
	@Override
	public void updateStudent(StudentForm studentForm) {
		StudentModel studentModel = studentDao.queryStudent(studentForm.getId());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");

		studentModel.setName(studentForm.getName());
		try {
			studentModel.setBirthday(formatter.parse(studentForm.getBirthday()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		studentModel.setClazz(studentForm.getClazz());
		studentModel.setModifyTime(new Date());
		studentDao.updateStudent(studentModel);

	}

	public StudentModelConvert getstudentModelConvert() {
		return studentModelConvert;
	}

	public void setstudentModelConvert(StudentModelConvert studentModelConvert) {
		this.studentModelConvert = studentModelConvert;
	}

	public StudentDataConvert getStudentDataConvert() {
		return studentDataConvert;
	}

	public void setStudentDataConvert(StudentDataConvert studentDataConvert) {
		this.studentDataConvert = studentDataConvert;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	// 根据id查询学生信息
	@Override
	public StudentData queryStudent(StudentForm studentForm) {
		StudentModel studentModel = studentDao.queryStudent(studentForm.getId());
		StudentData studentData = studentDataConvert.convert(studentModel);
		return studentData;
	}

}
