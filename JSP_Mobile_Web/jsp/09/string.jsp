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
		// (1) String ��ü s ����
		String s;
		// (2) ��ü�� �� �Ҵ�
		s = "ȫ�浿";
		%>
		<!-- (3) s ��ü �� ���	-->
		������ '<%= s %>'�Դϴ�.<br>
		<!-- (4) s ��ü ���� ���ڿ� ���� ��� -->
		������ ���̴� �� <%= s.length() %> ���Դϴ�.<br>
		<!-- (5) '��' ���� ���ڿ� ��ġ ��� -->
		'��'�� <%= s.indexOf("��") %>�� ° ��ġ�� �ֽ��ϴ�.<br>
		<!-- (6) �̸� ��� -->
		�̸��� '<%= s.substring(1, 3) %>'�Դϴ�.<br>
		<br>
		<br>
	</section> 

	<!-- 3. Ǫ�� -->
	<footer class="footer1" data-position="fixed">
	    <center>
        <%@ include file="../../include/businessInfo.inc" %>
	    </center>
	</footer>

</section> 

</body>
</html>