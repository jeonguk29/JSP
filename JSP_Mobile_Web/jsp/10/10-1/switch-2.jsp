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
	<h1>switch��</h1>
</header> 
<!-- 2. ���� -->
<section> 
   ���� ������ ? <br><br>
<%
int month = 1;
String season=null;
switch (month) {
	case 12:
	case 1:
	case 2: season="�ܿ�";
	 	break;		
	case 3:
	case 4:
	case 5: season="��";	
		break;		
	case 6:
	case 7:
	case 8: season="����";
		break;		
	case 9:
	case 10:
	case 11: season="����";
		break;		
	default :
	       season="�����Դϴ�";
	}
%>
<hr color="red">
<p>
���� : <%= season %>
<hr color="red">
</section> 
<!-- 3. Ǫ�� -->
<footer class="footer1">
    <center>
        <%@ include file="../../include/businessInfo.inc" %>
</center>
</footer>
</section> 
</body></html>
