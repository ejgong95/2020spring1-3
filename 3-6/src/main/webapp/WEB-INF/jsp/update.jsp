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
		<td>��ǰ��</td>
		<td><form:input path="itemName" cssClass="itemName" maxlength="20"/></td>
	</tr>
	<tr height="40px">
		<td>��ǰ����</td>
		<td><form:input path="price" cssClass="price" maxlength="8"/>&nbsp; ��</td>
		<td><font color="red"><form:errors path="price"/></font>
	</tr>
	<tr height="40px">
		<td>����</td>
		<td><input type="file" name="picture"/></td>
		<td></td>
	</tr>
	<tr height="40px">
		<td>��ǰ����</td>
		<td><form:textarea path="description" cssClass="description"/></td>
		<td><font color="red"><form:errors path="description"/></font>
	</tr>
	
</table>
<br>
<input type="submit" value="����">
<input type="reset" value="���">
<br>
</div>
</form:form>
<a href="index.html">���ư���</a>
</body>
</html>