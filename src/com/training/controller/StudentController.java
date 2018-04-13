package com.training.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.data.StudentData;
import com.training.form.StudentForm;
import com.training.page.Pagination;
import com.training.page.SearchResult;
import com.training.service.StudentService;

@Controller
public class StudentController {
	@Resource
	private StudentService studentService;

	// 添加学生

	@RequestMapping("/addStudent")
	public String addStudent() {
		return "student/addStudent";
	}

	// 添加学生
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(StudentForm studentForm) {
		studentService.addStudent(studentForm);
		return "redirect:/loadStudents";
	}

	// 查看学生信息
	@RequestMapping("/loadStudents")
	public String loadStudens(Model model, @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		Pagination page = new Pagination();
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		SearchResult<StudentData> studentDatas = studentService.loadStudents(page);
		model.addAttribute("studentDatas", studentDatas);
		return "student/students";
	}

	// 删除学生信息
	@RequestMapping("/deleteStudent")
	public String deleteStudent(StudentForm studentForm) {
		studentService.deleteStudent(studentForm);
		return "redirect:/loadStudents";
	}

	// 修改学生信息
	@RequestMapping(value = "/modifyStudent", method = RequestMethod.POST)
	public String modifyStudent(StudentForm studentForm) {
		studentService.updateStudent(studentForm);
		return "redirect:/loadStudents";
	}

	// 修改学生信息
	@RequestMapping("/modifyStudent")
	public String modifyStudent(Model model, StudentForm studentForm) {
		StudentData studentData = studentService.queryStudent(studentForm);
		model.addAttribute("studentData", studentData);
		return "student/modifyStudent";
	}
}
