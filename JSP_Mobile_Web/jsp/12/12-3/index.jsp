<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=euc-kr"%>
<html>
<head>
<title>JSP World</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../../include/jQueryMobile.inc" %>
</head>
<body>
<!-- �������� ���� -->
<%
String ID   = (String)session.getAttribute("ID");
String name = (String)session.getAttribute("name");
%>
<section data-role="page">
<!-- 1. ��� -->
<header data-role="header" data-theme="b">
<!-- ��� Ÿ��Ʋ -->
<h1>Ȩ</h1>
<!-- Ȩ -->
<a href="index.jsp" data-icon="home" data-iconpos="notext" rel="external">Home</a>
<%
// �α׾ƿ� �����̸� 
	if (ID == null) {
%>	
<a href="sessionStart.jsp" data-role="button" data-theme="d" data-icon="arrow-r" data-inline="true" data-ajax="false" class="ui-btn-right">Login</a>	
<%
// �α��� �����̸�
		} else { 
%>
<a href="sessionStop.jsp" data-role="button" data-theme="d" data-icon="arrow-r" data-inline="true" data-ajax="false" class="ui-btn-right"><%= ID %>��, Logout</a>	
<%
		} 
%>		
</header> 
<!-- 2. ���� -->
<section data-role="content"> 
	    <br>	<br>
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
	<br><br><br>
</section> 
<!-- 3. Ǫ�� -->
<footer data-role="footer" data-theme="a" data-position="fixed">
        <%@ include file="../../include/businessInfo.inc" %>
</footer>
</section> </body></html>