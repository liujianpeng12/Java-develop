<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>修改</h2>
	<s:form action="emp_modify">
		<s:textfield name="id" label="ID" readonly="true"></s:textfield>
		<s:textfield name="name" label="姓名"></s:textfield>
		<s:textfield name="age" label="年龄"></s:textfield>
		<s:textfield name="salary" label="收入"></s:textfield>
		<s:submit value="修改"></s:submit>
	</s:form>
</body>
</html>