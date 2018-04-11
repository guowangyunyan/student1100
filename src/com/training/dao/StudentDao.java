package com.training.dao;

import com.training.model.StudentModel;
import com.training.page.Pagination;
import com.training.page.SearchResult;

public interface StudentDao {

	void saveStudent(StudentModel studentModel);

	void deleteStudent(StudentModel studentModel);

	void updateStudent(StudentModel studentModel);

	SearchResult<StudentModel> queryStudents(Pagination page);

	StudentModel queryStudent(Integer id);

}
