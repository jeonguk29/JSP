<!DOCTYPE HTML>
<!-- [1] 지시문(page 디렉티브) --> 
<%@ page contentType="text/html;charset=euc-kr"%>
<!-- [1] 지시문(page 디렉티브): Calendar 클래스가 정의된 패키지 -->
<%@ page import = "java.util.*"%> 
<html>
<head>
<title>JSP World</title>
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
	<h1>세션 초기 화면 </h1>
    </center>
</header> 
<!-- 2. 본문 -->
<section data-role="content"> 
<form action="session-set.jsp" method="post">
  아이디 : <input type="text" name="id" size=“30">
  비밀번호 : <input type="password" name="pw" size="30">
        <input type="submit" value="로그인">
        <input type="reset" value="초기화">
</form>
<br>
</section> 
<!-- 3. 푸터 -->
<footer data-role="footer" data-theme="a" data-position="fixed">
    <center>
        <!-- [1] 지시문(include 디렉티브) --> 
        <%@ include file="businessInfo.inc" %>
    </center>
</footer>
</section> 
</body>
</html>