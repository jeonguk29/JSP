<!DOCTYPE HTML>
<!-- [1] ���ù�(page ��Ƽ��) --> 
<%@ page contentType="text/html;charset=euc-kr"%>
<!-- [1] ���ù�(page ��Ƽ��): Calendar Ŭ������ ���ǵ� ��Ű�� -->
<%@ page import = "java.util.*"%> 
<html>
<head>
<title>JSP World</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./07-2/style1.css" />
</head>
<body>

<section>

	<!-- 1. ��� -->
	<header  class="header1">
	    <center>
		<h1>�� ȭ�鱸�� ����</h1>
		</center>
	</header> 

	<!-- 2. ���� -->
	<section> 
	    <br>
		<br>		
		<!-- [3] ��ũ��Ʈ��: ���� --> 
		<%
		    // [2] �ּ���: ��¥ ���� today ��ü ����
			Date today = new Date();
		%>
		<!-- [3] ��ũ��Ʈ��: �� --> 
		
		<!-- [4] ǥ������ �̿��� ��� -->
		���� ��¥�� <%= today %>�Դϴ�.
		<br>
		<br>
		<br>
	</section> 

	<!-- 3. Ǫ�� -->
	<footer class="footer1">
	    <center>
        <!-- [1] ���ù�(include ��Ƽ��) --> 
        <%@ include file="businessInfo.inc" %>
	    </center>
	</footer>

</section> 

</body>
</html>