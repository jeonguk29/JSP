<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=euc-kr"%>
<html>
<head>
<title>JSP World</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../../css/style1.css" />
</head>
<body>

<!-- �������� ���� -->
<%
String ID   = (String)session.getAttribute("ID");
String name = (String)session.getAttribute("name");
%>

<section>

	<!-- 1. ��� -->
	<header class="header1">
		<h1>JSP ���尴ü</h1>
		
		<!-- Ȩ -->
		<a href="index.jsp"><font color="yellow">Home</font></a>
		&nbsp&nbsp  
        
		<%
		// ������ �����Ǿ� ���� ���� ����  
		if (ID == null) {
		%>	
			<a href="sessionStart.jsp"><font color="yellow">Login</font></a>	
		<%
		// ������ �����Ǿ� �ִ� ����
		} else { 
		%>
			<a href="sessionStop.jsp"><font color="yellow"><%= ID %>��, Logout</font></a>	
		<%
		} // if
		%>		
	</header> 

	<!-- 2. ���� -->
	<section> 
	    <br>
		<br>
		<%
		// ������ �����Ǿ� ���� ���� ����  
		if (ID == null) {
		%>	
            Ȩ...
		<%
		// ������ �����Ǿ� �ִ� ����
		} else { 
		%>
            ������ �����Ǿ����ϴ�!
		<%
		} // if
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