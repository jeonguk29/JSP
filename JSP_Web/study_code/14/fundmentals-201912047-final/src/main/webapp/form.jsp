<%--
  Created by IntelliJ IDEA.
  User: IN302
  Date: 2022-10-25
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>요청의 시작점 : view </title>
</head>
<body>
<form action="controllers" method="post"> <!-- 안쓰면 겟방식임 -->
    이름 : <input type="text" name="pname" value="기본값"/>
    이메일 : <input type="text" name="pemail" value="@induk.ac.kr"/>
    <input type="submit" value="작업"/>
</form>
<a href="members/members-create-form.jsp">contact 폼으로</a> <!-- 여기서 / 는 안됨 -->
<a href="api/induk.jsp">contact 폼으로</a> <!-- 여기서 / 는 안됨 -->


</body>
</html>
