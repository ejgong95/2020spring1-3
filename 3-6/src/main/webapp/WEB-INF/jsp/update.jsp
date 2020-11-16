<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemEdit.title"></spring:message></title>
</head>
<body>
<form:form modelAttribute="item" action="update.html" method="post"
		enctype="multipart/form-data">
<form:hidden path="itemId"/>
<form:hidden path="pictureUrl"/>
<div align="center" class="body">
<h2><font color="green"><spring:message code="itemEdit.title"/></font></h2>
<table>
	<tr height="40px">
		<td>상품평</td>
		<td><form:input path="itemName" cssClass="itemName" maxlength="20"/></td>
	</tr>
	<tr height="40px">
		<td>상품가격</td>
		<td><form:input path="price" cssClass="price" maxlength="8"/>&nbsp; 원</td>
		<td><font color="red"><form:errors path="price"/></font>
	</tr>
	<tr height="40px">
		<td>파일</td>
		<td><input type="file" name="picture"/></td>
		<td></td>
	</tr>
	<tr height="40px">
		<td>상품설명</td>
		<td><form:textarea path="description" cssClass="description"/></td>
		<td><font color="red"><form:errors path="description"/></font>
	</tr>
	
</table>
<br>
<input type="submit" value="변경">
<input type="reset" value="취소">
<br>
</div>
</form:form>
<a href="index.html">돌아가기</a>
</body>
</html>