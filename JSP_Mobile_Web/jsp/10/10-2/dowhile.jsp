<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=euc-kr"%>
<html>
<head>
<title>JSP World</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../../css/style1.css" />
</head>
<body>
<section>
<!-- 1. ��� -->
<header class="header1">
	<h1>do while�ݺ���</h1>
</header> 
<!-- 2. ���� -->
<section> 
    <br>	<br>
<%
int i, sum = 0;
i = 1;
do {
	sum += i;
	i++; 
} while (i<=10); 
%>
1���� 10������ ���� <%= sum %>�Դϴ�.
	<br><br><br>
</section> 
<!-- 3. Ǫ�� -->
<footer class="footer1">
 <center>
       <%@ include file="../../include/businessInfo.inc" %>
 </center>
</footer></section> </body></html>