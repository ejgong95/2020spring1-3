<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.loginUser != null }">
		<h3 align="center">�α��� �Ǿ����ϴ�.</h3>
		<h2 align="center">ȯ���մϴ�~ ${sessionScope.loginUser } ��~ :p</h2>
	</c:when>
	<c:otherwise>
		<h3 align="center">�α��� ���� �ʾҽ��ϴ�.</h3>
		<h2 align="center">��ȣ�� Ȯ���ϼ���.</h2>
		<c:if test="${cartLogin == 'fail' }">
			<a href="../cart/login.html">�ôٽ� �α����ϱ�</a>
		</c:if>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${cartLogin == 'success' }">
		<script type="text/javascript">
		self.close();openr.window.location.reload();
		</script>
	</c:when>
</c:choose>
</body>
</html>









