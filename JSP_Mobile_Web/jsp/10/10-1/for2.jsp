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
		<h1>for�ݺ���</h1>
	</header> 

	<!-- 2. ���� -->
	<section> 
	    <br>
		<br>
        <%
		int i=2;
		int k;
		for (int j=1; j<=9; j++) { 
			k = i * j;
		%>	
			<%= i %> X <%= j %> = <%= k %><br>
		<%	
		} 
		%>		
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