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
<h1>dowhile��</h1>
</header> 
<!-- 2. ���� -->
<section> 
    <br><br>
<%
int sum = 0;
int i = 1;
do {
	sum = sum + i;
	i = i + 1;
} while (i <= 100);
%>
"1+2+3+....... +99+100" = <%= sum %>
<p><hr color="green">
1���� 100������ ���� <%= sum %>�Դϴ�.
<br><br><br>
</section> 
<!-- 3. Ǫ�� -->
<footer class="footer1">
   <center>
       <%@ include file="../../include/businessInfo.inc" %>
 </center>
</footer></section></body></html>
