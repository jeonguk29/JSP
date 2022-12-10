<%--
  Created by IntelliJ IDEA.
  User: IN302
  Date: 2022-11-01
  Time: 오후 4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> // jstl 빌드 그레이들에 적용 한거 가져오기
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- url에 /controllers 컨트롤러에서 설정한 경로 이름 넣어주면 확인 가능 -->
<%= "뷰 페이지"%>
<br/>
<%
    String[] baseball = (String[]) request.getAttribute("baseball"); // 컨트롤러에서 set 어트리 뷰트 했으면 여기서 get 어트리뷰트 해줘야함
    for(String b : baseball)
        out.println(b + "<br/>");
%>

// 달라 베이스볼이 EL임 좀더 쉽게 사용 가능한
<c:forEach items="${baseball}" var="ball">
    ${ball} <br/>
</c:forEach>

</body>
</html>
