<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生信息</title>
</head>
<body>
	<h1>修改学生信息</h1>
	<hr>
	<form action="modifyStudent" method="post">
		<input type="hidden" name="id" value="${studentData.id }" >
		姓名:<input type="text" name="name" value="${studentData.name }" ><br>
		班级:<input type="text" name="clazz" value="${studentData.clazz }" ><br>
		出生日期:<input  name="birthday" value="${studentData.birthday }" ><br>
		<input type="submit" value="修改" >
	</form>
</body>
</html>