<%
// �Է����� �ѱ� ó��
request.setCharacterEncoding("euc-kr");
// �Է�����(ID, ��й�ȣ) ����
String ID   = request.getParameter("ID");
String pswd = request.getParameter("pswd");
%>

<%
// ���� ����
session.setAttribute("ID",   ID);
session.setAttribute("name", "ȫ�浿");

// Ȩ�������� �̵�
response.sendRedirect("index.jsp");
%>