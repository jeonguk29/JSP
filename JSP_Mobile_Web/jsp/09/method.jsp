<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=euc-kr"%>
<html>
<head>
<title>JSP World</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../../css/style1.css" />

<%!
// ������ �μ��� ���� �޼ҵ�
public int add(int a, int b) { 
    int c;
	c = a + b;
    return(c); 
}

// �Ǽ��� �μ��� ���� �޼ҵ� 
public double add(double a, double b) { 
    double c;
	c = a + b;
    return(c); 
}
%>

</head>
<body>

<section>

	<!-- 1. ��� -->
	<header class="header1">
		<h1>����/������/Ŭ����</h1>
	</header> 

	<!-- 2. ���� -->
	<section> 
	    <br>
		<br>
		
		<!-- (1) sum �޼ҵ带 ȣ��� ��� ���� -->
		<%
		int res = add(10, 20);
		%>
		10�� 20�� ��: <%= res %><br>
		
		<!-- (2) sum �޼ҵ带 ȣ��� ��� ��� -->
		<%
		double d1, d2;
        d1 = 12.7;
        d2 = 23.5;
		%>
		<%= d1 %>�� <%= d2 %>�� ��: <%= add(d1, d2) %><br>
		
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