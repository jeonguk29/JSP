<!DOCTYPE HTML>
<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "java.util.*"%> 
<html>
<head><title>1부터 5까지의 합</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../../css/style1.css" />
</head>
<body>
<%
    int sum = 0;
    for (int i = 1 ; i <= 5 ; i++) {
        sum = sum + i;
    }
%>
1 부터 5까지의 합은 <%= sum %> 입니다.
</body>
</html> 
