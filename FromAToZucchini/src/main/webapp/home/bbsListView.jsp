<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table.bbs_main{border:1px solid blue; width:90%; border-collapse:collapse;}
th{border:1px solid blue;}
td{border:1px solid red;}
</style>
</head>
<body>
<div align="center">
<h2>게시글 목록</h2>
<c:if test="${BBS_LIST == null }">
	<h3>등록된 게시글이 존재하지 않습니다.</h3>
</c:if>
<c:if test="${BBS_LIST != null }">
<table class="bbs_main">
	<tr><th width="10%">글번호</th><th width="20%">작성자</th>
		<th width="50%">글제목</th><th width="20%">작성일</th></tr>
	<c:forEach var="bbs" items="${BBS_LIST }">
	<tr><td>${bbs.seqno }</td><td>${bbs.id }</td>
		<td><a href="../read/readDetail.html?SEQNO=${bbs.seqno }">${bbs.title }</a></td>
		<td>${bbs.bbs_date }</td></tr>
	</c:forEach>
</table>
<c:forEach begin="1" end="${pageCount }" var="page">
	<a href="bbsList.do?PAGENO=${page }">${page }</a>
</c:forEach>
</c:if>
</div>
</body>
</html>






