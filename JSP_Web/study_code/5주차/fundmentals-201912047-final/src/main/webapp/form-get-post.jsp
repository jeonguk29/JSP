<%--
  Created by IntelliJ IDEA.
  User: jeong
  Date: 2022-10-14
  Time: 오후 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>for-get-post</title>
</head>
<body>
Get Method]
<form action="OurServlet" method="get" name="get">
    <label for="get-name">First name:</label>
    <input type="text" id="get-name" name="name" value="egyou"><br>
    <label for="get-phone">Phone:</label>
    <input type="text" id="get-phone" name="phone" value="02-950-7625"><br>
    <input type="submit" value="Get">
</form>

post Method]
<form action="OurServlet" method="post" name="post">
    <label for="post-name">First name:</label>
    <input type="text" id="post-name" name="name" value="wooge"><br>
    <label for="post-phone">Phone:</label>
    <input type="text" id="post-phone" name="phone" value="02-950-7625"><br>
    <input type="submit" value="Post">
</form>

</body>
</html>
