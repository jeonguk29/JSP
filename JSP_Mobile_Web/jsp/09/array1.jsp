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
		<h1>����/������/Ŭ����</h1>
	</header> 

	<!-- 2. ���� -->
	<section> 
	    <br>
		<br>
	    <%
		// (1) ������ �迭(arr) ����
		int[] arr = new int[3];
		// (2) �迭�� �Ҵ� 
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
	    %>
		<!-- (3) �迭�� ��� --> 
		�迭 1��° ��: <%= arr[0] %><br>
		�迭 2��° ��: <%= arr[1] %><br>
		�迭 3��° ��: <%= arr[2] %><br>
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