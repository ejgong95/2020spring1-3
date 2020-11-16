<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">게시판 글쓰기</h2>
<form:form modelAttribute="bbs" method="post"
	action="../home/write.html">
제 목 : <form:input path="title" placeholder="반드시 작성해야합니다."/><br/><br/>
<font color="red"><form:errors path="title"/></font><br/>
<form:textarea rows="5" cols="80" path="content"
	placeholder="글 내용을 입력하세요."/><br/>
<font color="red"><form:errors path="content"/></font>
<div align="center">
<input type="submit" value="글 올리기"/>
<input type="reset" value="취 소"/>
</div>
</form:form>
</body>
</html>