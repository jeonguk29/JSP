<%--
  Created by IntelliJ IDEA.
  User: IN302
  Date: 2022-11-22
  Time: 오후 3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // scriptlet : java 문법, java 기본 객체 + , jsp 기본 객체 사용 가능(reqeust, response, out, session ...)
    // 지금 이렇게 안하고 아래와 같이 사용함
%>
<!-- 전달한 어트리뷰트 있으면 하나씩 가져옴 -->
<c:forEach var="m" items="${list}">
    <h2>email : ${m.email}</h2>
    <h2>name : ${m.name}</h2>

</c:forEach>

</body>
</html>
