<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=euc-kr"%>
<html>
<head>
<title>JSP World</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../../include/jQueryMobile.inc" %>

<script type="text/javascript">
$(function() {
	$('ul li a').click(function() {
	    // Ŭ���� ��ü(this) ���� �� ������Ʈ�� ã��(find), �� �Ӽ�(attr) �Ǵ� ������(text) �ν�
		var videoTitle = $(this).find('div').text();	

		// audio ������Ʈ �ν�(�迭�� ��ȯ) 
		var myAudio = $("#audio");
		// �����(ù ��° �ſ����� �ش�) ����   
		myAudio.get(0).pause();
		// ����� �ҽ� ��� ����	
		myAudio.attr('src', "../../contents/audio/" + videoTitle);
		// �����(ù ��° �ſ����� �ش�) ����
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
	
		    <%
			for (int i=0; i<title.length; i++) { 
			%>
				<!-- ��� ������ -->
				<li>
					<a href="#">			
						<!-- �����: ����, ��Ƽ��Ʈ, �ҽ�, ����ð� -->
						<h3><%= title[i] %></h3>
						<p>
							<%= artist[i] %><br>
							<div style="display: none"><%= file_name[i] %></div>
						</p>
						<p class="ui-li-aside"><strong><%= time[i] %></strong>��</p>	
					</a>
				</li>				
		    <%
			}  
			%>

		</ul>		
	
	    <!-- ����� ��� ���� --> 
		<center>
		<audio id="audio" controls></audio>
		</center>
		
	</section> 

	<!-- 3. Ǫ�� -->
	<footer data-role="footer" data-theme="a" data-position="fixed">
        <%@ include file="../../include/businessInfo.inc" %>
	</footer>

</section> 

</body>
</html>