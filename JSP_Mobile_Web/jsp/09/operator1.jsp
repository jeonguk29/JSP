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
		<%  // ��ũ��Ʋ�� ���⼭ ���� �ڹ� �ڵ带 ����ϰڴ�.
		// (1) ������ ����(sum) ����
		int sum;
		// (2) ������ �� �Ҵ�
		sum = 120;
		// (3) ���������ڿ� ���� ������ 1 ����
		sum++;
		%>
		<!-- (4) ������ ��� --> 
		��°��� <%= sum %>�Դϴ�.
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