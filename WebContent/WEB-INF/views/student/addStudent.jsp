<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生</title>
</head>
<body>
	<form action="addStudent" method="post">
		姓名:<input type="text" name="name"><br>
		出生日期:<input type="date" name="birthday"><br>
		班级:<input type="text" name="clazz">
		<input type="submit" value="提交">
	
	</form>
</body>
</html>