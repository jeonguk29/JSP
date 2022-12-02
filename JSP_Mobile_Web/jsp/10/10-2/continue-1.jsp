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

	<!-- 1. 헤더 -->
	<header class="header1">
		<h1>continue문</h1>
	</header> 

	<!-- 2. 본문 -->
	<section> 
	    <br>
		<br>
	<%
	int sum = 0;
	int i;
	for (i = 1; i <= 100; i++)
	{
		if (i % 2 == 1) continue;
			sum = sum + i;
	}
	%>
<p><font size=5 color="blue"> 1부터 100사이 짝수의 합은 : </font>
<%=   sum %>
<hr color="yellow">	
	</section> 

	<!-- 3. 푸터 -->
	<footer class="footer1">
	    <center>
        <%@ include file="../../include/businessInfo.inc" %>
	    </center>
	</footer>

</section> 

</body>
</html>