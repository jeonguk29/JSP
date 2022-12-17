
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="iducs201912047.javaweb.fundmentals.model.MemberDTO" %>
<html>
<head>
    <title>요청 처리 결과 view </title>
</head>
<body>
<h1>요청 처리 결과<br/>
    <%-- 속성의 값이 MemberDTO 형의 객체 --%>
    <%
        MemberDTO m = (MemberDTO) request.getAttribute("member");
     %>
<%= m.getName()%>님 <%= m.getWork()%> 등록에 성공했습니다.   <!-- 요놈은 가져온 m을 이용하는 것임 -->

    <!-- pageScope, requestScope, sessionScope, applicationScope -->
    이메일은(EL사용 - attribute를 잘 다룬다) : ${member.email}  <%-- requestScope.member.email 생략가능 --%>


    <!-- 이렇게도 사용 가능 그냥 필드 값을 바로 가져오는 것임 .getAttribute("member") 요놈
    컨트롤러에서   request.setAttribute("member", mRef); 로  정의 한 놈을 가져오는 것임

      request.setAttribute("ref", mRef); 로 성정 한다면
         MemberDTO m = (MemberDTO) request.getAttribute("ref");

             이메일은(EL사용 - attribute를 잘 다룬다) : ref.email 로 수정 해줘야함

             +
          <%--   ${} 이렇게 쓰는걸 El 이라고함   --%>
 <%--
JSP 구성 요소
지시자(directive)  : <%@ page contentType="text/html;charset=UTF-8" language="java" %>
스크립팅 요소
    스크립틀릿(scriptlet) :   <%            %>
    표현식(expression)  :  <%= m.getWork()%> %>
    선언문(declaration)   :  <%!       %>

    -->

</body>
</html>
