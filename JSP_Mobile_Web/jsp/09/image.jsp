<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=euc-kr"%>
<html><head>
<title>JSP World</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- jQuery/jQuery Mobile ���̺귯�� ��� -->
<%@ include file="../jQueryMobile.inc" %>
<script type="text/javascript">
// ������ �ε��� �Ϸ�� �Ŀ� ������ �Լ� ���� 
$(function() {
    // HTML DOM Tree ������ ���� <ul>, <li>, <a> ������Ʈ�� Ŭ���Ǹ� ����� �Լ� ����
	$('ul li a').click(function() {
	    ///// page1 /////
	    // Ŭ���� ��ü(this) ���� �� ������Ʈ�� ã��(find), �� �Ӽ�(attr) �Ǵ� ������(text) �ν�
		var imageSrc   = $(this).find('img').attr('src');
		var imageTitle = $(this).find('h3').text();	
		var imageDesc  = $(this).find('p').text();

		///// page2 /////
		// id�� �̿��� ��ü �ν� �� �� �Ҵ�
		// �̹��� �ҽ� ����
		$("#p2_image").attr('src', imageSrc);	
		// ��ü�� HTML ���ڷ� ����
		$("#p2_title").html(imageTitle);	
		$("#p2_desc").html(imageDesc);	
	});
});
</script>
</head>
<body>
<!-- ù ��° ������: ���� -->
<section data-role="page" id="page1">
	<!-- 1. ��� -->
	<header data-role="header" data-theme="b">
		<!-- ��� Ÿ��Ʋ -->
		<h1>���� ���</h1>
	</header> 
	<!-- 2. ���� -->
	<section data-role="content"> 
		<%
		// �̹��� �迭
		String[] title       = {"�ݷμ���", "����ž", "��ʽ���"};
		String[] image_name  = {"coloseum.jpg", "eiffel_tower.jpg", "venus.jpg"};
		String[] description = {"��Ż���� �θ�", "������ �ĸ�", "������ ��긣�̼���"};
		%>
	    <!-- ��� -->
		<ul data-role="listview" data-inset="true" data-theme="e"> 
			<!-- ��� ������ 1 -->
			<li>
			<a href="#page2" data-rel="dialog" data-transition="pop">
			<!-- �̹���: �ҽ�, ����, ���� -->
			<img src="../image/<%= image_name[0] %>" width=100% height=100%>
			<h3><%= title[0] %></h3>
			<p><%= description[0] %></p>
		</a>
	</li>				
			
			<!-- ��� ������ 2 -->
			<li>
			<a href="#page2" data-rel="dialog" data-transition="pop">
			<!-- �̹���: �ҽ�, ����, ���� -->
			<img src="../image/<%= image_name[1] %>" width=100% height=100%>
			<h3><%= title[1] %></h3>
			<p><%= description[1] %></p>
		</a>
	</li>				

			<!-- ��� ������ 3 -->
			<li>
			<a href="#page2" data-rel="dialog" data-transition="pop">
			<!-- �̹���: �ҽ�, ����, ���� -->
			<img src="../image/<%= image_name[2] %>" width=100% height=100%>
			<h3><%= title[2] %></h3>
			<p><%= description[2] %></p>
		</a>
	</li>				
	</ul>
	</section> 
	<!-- 3. Ǫ�� -->
	<footer data-role="footer" data-theme="a" data-position="fixed">
        <%@ include file="../businessInfo.inc" %>
	</footer>

</section>
<!-- ù ��° ������: ���� -->

<!-- �� ���� ������: ���� -->
<section data-role="page" id="page2">
	<!-- 1. ��� -->
	<header data-role="header" data-theme="b">
		<!-- �̹��� ���� -->
		<h1 id="p2_title"></h1>
	</header> 
	<!-- 2. ���� -->
	<section data-role="content"> 
        <!-- �̹��� �ҽ� --> 
		<img id="p2_image" width="100%">
		
		<!-- �̹��� ���� -->
		<p id="p2_desc"></p> 
	</section> 
</section> 
<!-- �� ��° ������: �� -->
</body>
</html>