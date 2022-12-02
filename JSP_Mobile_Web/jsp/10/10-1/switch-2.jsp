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
	<h1>switch문</h1>
</header> 
<!-- 2. 본문 -->
<section> 
   지금 계절은 ? <br><br>
<%
int month = 1;
String season=null;
switch (month) {
	case 12:
	case 1:
	case 2: season="겨울";
	 	break;		
	case 3:
	case 4:
	case 5: season="봄";	
		break;		
	case 6:
	case 7:
	case 8: season="여름";
		break;		
	case 9:
	case 10:
	case 11: season="가을";
		break;		
	default :
	       season="오류입니다";
	}
%>
<hr color="red">
<p>
계절 : <%= season %>
<hr color="red">
</section> 
<!-- 3. 푸터 -->
<footer class="footer1">
    <center>
        <%@ include file="../../include/businessInfo.inc" %>
</center>
</footer>
</section> 
</body></html>
