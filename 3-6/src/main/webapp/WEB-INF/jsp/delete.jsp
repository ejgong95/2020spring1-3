<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemDelete.title" /></title>
</head>
<body>
   <script type="text/javascript">
      function deleteConfirm() {
         var v = confirm("정말로 삭제하시겠습니까?")
      };
      if (v == true)
         return true;
      return false;
   </script>
   <form:form modelAttribute="item" action="delete.html"
      onSubmit="return deleteConfirm()">
      <form:hidden path="itemId" />
      <div align="center" class="body">
         <h2>
            <font color="green"><spring:message code="itemDelete.title" /></font>
         </h2>
         <table>
            <tr height="40px">
               <td>상품명</td>
               <td><form:input path="itemName" cssClass="itemName"
                     disabled="true" /></td>
            </tr>
            <tr height="40px">
               <td>상품가격</td>
               <td><form:input path="price" cssClass="price" disabled="true" />&nbsp;원</td>
            </tr>
            <tr height="40px">
               <td>파일</td>
               <td><img alt=""
                  src="${pageContext.request.contextPath }/upload/${imageName}"
                  width="210" height="240"></td>
            </tr>
            <tr height="40px">
               <td>상품설명</td>
               <td><form:textarea path="description" cssClass="description"
                     disabled="true" /></td>
            </tr>

         </table>
         <br /> <input type="submit" value="삭 제" /><br />

      </div>
   </form:form>
   <a href="index.html">돌아가기</a>
</body>
</html>