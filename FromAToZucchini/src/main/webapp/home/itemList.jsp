<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>상품 목록</h2>
<table class="item_main" border="1">
	<tr><td width="20">상품 번호</td><td width="100">상품 이름</td>
		<td width="50">상품 가격</td><td width="100">원산지</td>
		<td width="100">&nbsp;</td></tr>
	<c:forEach var="item" items="${ITEM_LIST }">
	<tr><td>${item.code }</td><td>${item.name }</td>
		<td><fmt:formatNumber groupingUsed="true">${item.price }
			</fmt:formatNumber></td><td>${item.origin }</td>
		<td><a href="#" 
onClick="window.open('../cart/addCart.html?CODE=${item.code }','cart','width=400,height=350').focus()">장바구니 담기</a></td></tr>
	</c:forEach>
</table>
<c:forEach begin="1" end="${COUNT }" var="page">
	<a href="../read/product.html?pageNo=${page }">${page }</a>
</c:forEach>
</div>
</body>
</html>











