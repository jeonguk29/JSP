<%@ page contentType = "text/html; charset=euc-kr" %>
<html>
<head>
  <title>HTML 문서의 제목</title>
</head>
<body>
<%
    String subTitle = "JSP 웹프로그래밍";
    String author = ＂홍길동";
%>
<b><%= subTitle %></b>(<%= author %>)입니다.
</body>
</html>

