<!DOCTYPE HTML>
<!-- [1] 지시문(page 디렉티브) --> 
<%@ page contentType="text/html;charset=euc-kr"%>
<!-- [1] 지시문(page 디렉티브): Calendar 클래스가 정의된 패키지 -->
<%@ page import = "java.util.*"%> 
<html>
<head>
<title>세션정보 가져오기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.js">
</script>
<link rel="stylesheet" href="style1.css" />
</head>
<body>
<section data-role="page">
<!-- 1. 헤더 -->
<header  data-role="header" class="header1">
    <center>
	<h1>세션정보 가져오기 </h1>
    </center></header> 
<!-- 2. 본문 -->
<section data-role="content"> 
   <br>
    현재 세션의 아이디 : <%= session.getAttribute("id") %><br>
    현재 세션의 비밀번호 : <%= session.getAttribute("pwd") %><br>
<p align="center">
<a href="session.jsp" data-role="button" data-inline="true" >세션초기화면으로 가기</a>
</p>	
</section> 
<!-- 3. 푸터 -->
<footer data-role="footer" data-theme="a" data-position="fixed">
    <center>
        <!-- [1] 지시문(include 디렉티브) --> 
        <%@ include file="businessInfo.inc" %>
    </center>
</footer>
</section> </body></html>