<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>序号</th>
				<th>姓名</th>
				<th>班级</th>
				<th>出生日期</th>
				<th>新建时间</th>
				<th>修改时间</th>
				<th colspan="2">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="results" value="${studentDatas.result }"></c:set>
			<c:set var="pagination" value="${studentDatas.page }"></c:set>
			<c:forEach items="${results }" var="stu" varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>${stu.name }</td>
					<td>${stu.clazz }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${stu.birthday }" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${stu.createTime }" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${stu.modifyTime }" /></td>
					<td><a href="modifyStudent?id=${stu.id }">修改学生信息</a></td>
					<td><a href="deleteStudent?id=${stu.id }">删除学生信息</a></td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>