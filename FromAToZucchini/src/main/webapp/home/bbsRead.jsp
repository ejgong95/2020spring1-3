<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>게시글 읽기</h2>
<table width="80%">
	<tr><td>[글번호] : ${BBS.seqno }</td></tr>
	<tr><td>[글제목] : ${BBS.title }</td></tr>
	<tr><td>[작성자] : ${BBS.id }, [작성일] : ${BBS.bbs_date }</td></tr>
	<tr><td>${BBS.content }</td></tr>
</table>
</div>
</body>
</html>











