<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=euc-kr"%>
<html>
<head>
<title>JSP World</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- jQuery/jQuery Mobile ���̺귯�� ��� -->
<%@ include file="../jQueryMobile.inc" %>

<script type="text/javascript">
$(function() {
	$('ul li a').click(function() {
	    // Ŭ���� ��ü(this) ���� �� ������Ʈ�� ã��(find), �� �Ӽ�(attr) �Ǵ� ������(text) �ν�
		var videoTitle = $(this).find('div').text();	

		// audio ������Ʈ �ν�(�迭�� ��ȯ) 
		var myAudio = $("#audio");
		// �����(ù ��° �迭���� �ش�) ����   
		myAudio.get(0).pause();
		// ����� �ҽ� ��� ���� 	
		myAudio.attr('src', "../audio/" + videoTitle); 
		// �����(ù ��° �迭���� �ش�) ����
		myAudio.get(0).play();
		
	});
});

</script>

</head>
<body>

<section data-role="page">

	<!-- 1. ��� -->
	<header data-role="header" data-theme="b">
		<!-- ��� Ÿ��Ʋ -->
		<h1>����� ���</h1>
	</header> 

	<!-- 2. ���� -->
	<section data-role="content"> 
	
		<%
		// ����� Ÿ��Ʋ, ����� ����, ��Ƽ��Ʈ, ����ð��� ���� �迭 ����� �� �Ҵ� 
		String[] title     = {"�б���", "�ڳ��� ������", "���䳢"};
		String[] artist    = {"��޸�", "������/������", "���Ϸ�"};
		String[] file_name = {"schoolBell.mp3", "elephant.mp3", "hare.mp3"};
		String[] time      = {"00:19", "00:16", "00:16"};
		%>
	
	    <!-- ��� -->
		<ul data-role="listview" data-inset="true" data-theme="e"> 
	
			<!-- ��� ������ 1 -->
			<li>
				<a href="#">			
					<!-- �����: ����, ��Ƽ��Ʈ, �ҽ�, ����ð� -->
					<h3><%= title[0] %></h3>
					<p>
						<%= artist[0] %><br>
						<div style="display: none"><%= file_name[0] %></div>
					</p>
					<p class="ui-li-aside"><strong><%= time[0] %></strong>��</p>	
                </a>
			</li>				

			<!-- ��� ������ 2 -->
			<li>
				<a href="#">			
					<!-- �����: ����, ��Ƽ��Ʈ, �ҽ�, ����ð� -->
					<h3><%= title[1] %></h3>
					<p>
						<%= artist[1] %><br>
						<div style="display: none"><%= file_name[1] %></div>
					</p>
					<p class="ui-li-aside"><strong><%= time[1] %></strong>��</p>	
                </a>
			</li>				

			<!-- ��� ������ 3 -->
			<li>
				<a href="#">			
					<!-- �����: ����, ��Ƽ��Ʈ, �ҽ�, ����ð� -->
					<h3><%= title[2] %></h3>
					<p>
						<%= artist[2] %><br>
						<div style="display: none"><%= file_name[2] %></div>
					</p>
					<p class="ui-li-aside"><strong><%= time[2] %></strong>��</p>	
                </a>
			</li>				
			
		</ul>		
	
	    <!-- ����� ��� ���� --> 
		<center>
		<audio id="audio" controls></audio>
		</center>
		
	</section> 

	<!-- 3. Ǫ�� -->
	<footer data-role="footer" data-theme="a" data-position="fixed">
        <%@ include file="../businessInfo.inc" %>
	</footer>

</section> 

</body>
</html>