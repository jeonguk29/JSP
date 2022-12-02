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
	<h1>while문</h1>
	</header> 

	<!-- 2. 본문 -->
	<section> 
	    <br>	<br>
<%
    String str = "A";
    int i = 1;
    while (i < 10){
        out.print(i + ". " + str + "<br>");
        str = str + "A";
        i = i + 1;
    }
%>
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