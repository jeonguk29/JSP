<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: jeong
  Date: 2022-10-25
  Time: 오전 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%
// 과거 서블릿3 보면 출력 하기위해 출력 도구 직접 만들었음 우리는 할필요 없음 out 이라는 내장 객체 있기 때문임

    //res.setCharacterEncoding("UTF-8");  이것도 지시자 통해서 했기 때문에 필요 없음
    //res.setContentType("text/html; charset=UTF-8");

    // PrintWriter out = res.getWriter();

    String cnt_ =  request.getParameter("cnt"); // 임시 저장소 저장

    int cnt = 100;// 기본값 지정
    if(cnt_ != null && !cnt_.equals(""))// 빈문자열이라 널 값아닐때
        cnt = Integer.parseInt(cnt_); // 오는 문자열을 정수로 변환


    // 이렇게 했을때 장점은 우리가 직접 서블릿 만들때 보다 편함 코드블럭만 우리가 신경쓰면 jsp가 다 만들어서 서블릿 만들고 보여주는거 까지 해줌
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- nana 서블릿을 jsp로 만들어보자 -->

<% for(int i=0; i < cnt; i++) { %>
   안녕  Servlet!! <br>
<% } %>


</body>
</html>
