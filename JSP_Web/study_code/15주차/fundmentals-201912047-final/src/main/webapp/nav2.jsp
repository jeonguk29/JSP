<%--
  Created by IntelliJ IDEA.
  User: IN302
  Date: 2022-11-01
  Time: 오후 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- HTML 주석 : Tomcat에서 처리하고, 웹 브라우저에서 처리 안함-->
<%-- JSP 주석 : Tomcat에서 처리를 안함 --%>
<%--Scriptlet : JSP 문서를 구성하는 스크립팅 요소(scriptlet, expression, declaration) 중의 하나
Java 문법을 기준으로, JSP 기본 객체를 사용하여 프로그래밍 할 수 있다.    아래와 같은 코드
--%>
<%
    String[] teams = {"삼성라이온즈", "두산베이스", "기아타이거즈", "SSG랜더스", "키움히어로즈"};

    // java 주석, out - JSP 기본 객체(Internal Object), System.out != out   즉 out은 자바에서 안먹음  out은 웹브라우저에 출력되고 시스템 아웃은 콘솔에 출력 nav2.jsp 접속해봐라



    //for statement
    for(int i = 0; i < teams.length; i++)
        out.println(teams[i] + "<br/>");

    // enhanced loop statement, enhanced for statement : sequential access : 순차접근시 간결
    for(String team : teams)
        out.println(team + "<br/>");
    System.out.println("LG트윈스");


%>

</body>
</html>
