<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>과일 상세 정보</title>
<link rel="stylesheet" type="text/css" href="../css/3-5.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
<h2>과일 상세 화면</h2>
<table>
	<tr><td><img alt="" src="../img/${item.pictureUrl }"></td>
		<td align="center">
		<table>
			<tr height="50"><td width="80">상품명</td>
							<td width="160">${item.itemName }</td></tr>
			<tr height="50"><td width="80">가 격</td>
							<td width="160">${item.price }원</td></tr>
			<tr height="50"><td width="80">설 명</td>
							<td width="160">${item.description }</td></tr>
			<tr>
				<td colspan="2" align="center" width="230">
				<form action="../cart/cartAdd.html">
					<input type="hidden" name="itemId" value="${item.itemId }"/>
					<table>
						<tr>
							<td><select name="quantity">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								</select> &nbsp; 개
							</td>
							<td> <input type="submit" value="카트에 담기"></td>
							</tr>
					</table>
				</form>
			</tr>
			<tr><td colspan="2" align="center" width="240">
				<a href="index.html">■ 목록으로 돌아가기</a></td></tr>
		</table>
		</td></tr>
</table>
</div>
</body>
</html>









