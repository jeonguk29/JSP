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
		<h1>���ǹ�/�ݺ���</h1>
	</header> 

	<!-- 2. ���� -->
	<section> 
	    <br>
		<br>
		<%
		String grade = "";
		int score = 75;
		if (score >= 90) 
			grade = "A";
		else if (score >= 80)   	
			grade = "B";
		else if (score >= 70)   	
			grade = "C";
		else 
			grade = "F";
		%>
		<%= grade %>����Դϴ�
		<br>
		<br>
		<br>
	</section> 

	<!-- 3. Ǫ�� -->
	<footer class="footer1">
	    <center>
        <%@ include file="../../include/businessInfo.inc" %>
	    </center>
	</footer>

</section> 

</body>
</html>