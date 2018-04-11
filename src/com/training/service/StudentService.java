package com.training.service;

import com.training.data.StudentData;
import com.training.form.StudentForm;
import com.training.page.Pagination;
import com.training.page.SearchResult;

public interface StudentService {
	// 添加学生
	void addStudent(StudentForm studentForm);

	// 查看学生信息
	SearchResult<StudentData> loadStudents(Pagination page);

	// 删除学生信息
	void deleteStudent(StudentForm studentForm);

	// 修改学生信息
	void updateStudent(StudentForm studnetForm);

	// 查询学生信息根据id
	StudentData queryStudent(StudentForm studentForm);

}
