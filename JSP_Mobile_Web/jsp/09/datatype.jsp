<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=euc-kr"%>
<html>
<head>
<title>JSP World</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../style1.css" />
</head>
<body>
<section>
	<!-- 1. ��� ���� -->
	<header class="header1">
		<h1>����/������/Ŭ����</h1>
	</header> 

	<!-- 2. ���� -->
	<section> 
	    <br>
		<br>
		<%
		// (1) ������ ����(price) ���� 
		int price;
		// (2) ������ �� �Ҵ�
		price = 12000;
		%>
		<!-- (3) ������ ��� --> 
		������ <%= price %>���Դϴ�.
		<br>
		<br>
		<br>
	</section> 

	<!-- 3. Ǫ�� -->
	<footer class="footer1">
	    <center>
        <%@ include file="../businessInfo.inc" %>
	    </center>
	</footer>

</section> 

</body>
</html>