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
	<h1>witch-1 ��</h1>
</header> 
<!-- 2. ���� -->
<section> 
    <br><br>
<%
int score = 85;
char grade;

switch( score / 10 ){
	case 10:	grade = 'A';break;
	case 9:    	grade = 'A';break;
	case 8:	grade = 'B';break;
	case 7:    	grade = 'C';break;
	case 6:    	grade = 'D';break;
	default :   grade = 'F';
	}
%>
<hr>
<p>
���� : <%= score %>
���� : <%= grade %><p>
<hr>
</section> 
<!-- 3. Ǫ�� -->
<footer class="footer1">
    <center>
        <%@ include file="../../include/businessInfo.inc" %>
</center>
</footer>
</section> 
</body></html>
