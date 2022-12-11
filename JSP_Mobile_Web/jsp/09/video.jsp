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
	    /// page1 ///
	    // Ŭ���� ��ü(this) ���� �� ������Ʈ�� ã��(find), �� �Ӽ�(attr) �Ǵ� ������(text) �ν�
		var videoTitle = $(this).find('h3').text();	
		var videoSrc   = $(this).find('div').text();	
		var videoDesc  = $(this).find('p.description').text();	

		/// page2 ///
		// video ����� ���� ��� 
		$("#p2_title").html(videoTitle);	
		$("#p2_desc").html(videoDesc);
		
		// ���� �ҽ� ����� ���� 	
		var video = $("#p2_video");
		video.attr('src', "../video/" + videoSrc);
		video.get(0).play();
	});
	
	$('#page2').click(function() {
		// ���� ���� ���� ���� ����
		$("#p2_video").get(0).pause();
	});
});
</script>

</head>
<body>

<section data-role="page" id="page1">

	<!-- 1. ��� -->
	<header data-role="header" data-theme="b">
		<!-- ��� Ÿ��Ʋ -->
		<h1>���� ���</h1>
	</header> 

	<!-- 2. ���� -->
	<section data-role="content"> 	
		<%
		// ���� �迭 
		String[] thumnail = {"fountain_night.png", "creek_rock.png", "waterfall_street.png"};
		String[] title = {"���� �м����� �߰�", "���", "û��õ����"};
		String[] description = {"����, ������ ����", "��⵵ ����, �빮��", "����, û��õ"};
		String[] file_name = {"fountain_night.mp4", "creek_rock.mp4", "waterfall_street.mp4"};
		String[] time = {"00:05", "00:03", "00:03"};
		%>
	    <!-- ��� -->
		<ul data-role="listview" data-inset="true" data-theme="e"> 
    		<!-- ��� ������ 1 -->
		<li>
		<a href="#page2" data-rel="dialog" data-transition="pop">
		<!-- ����: ������̹���, ����, ����, ����ð� -->
		<img src="../image/<%= thumnail[0] %>" width=100% height=100%>
		<h3><%= title[0] %></h3>
		<p class="description">
		<%= description[0] %>
		<div style="display: none"><%= file_name[0] %></div>
		</p>
		<p class="ui-li-aside"><strong><%= time[0] %>��</strong></p>
		</a>
		</li>				
    		<!-- ��� ������ 2 -->
			<li>
				<a href="#page2" data-rel="dialog" data-transition="pop">
					<!-- ����: ������̹���, ����, ����, ����ð� -->
					<img src="../image/<%= thumnail[1] %>" width=100% height=100%>
					<h3><%= title[1] %></h3>
					<p class="description">
						<%= description[1] %>
						<div style="display: none"><%= file_name[1] %></div>
					</p>
					<p class="ui-li-aside"><strong><%= time[1] %>��</strong></p>
				</a>
			</li>					
			
    		<!-- ��� ������ 3 -->
			<li>
				<a href="#page2" data-rel="dialog" data-transition="pop">
					<!-- ����: ������̹���, ����, ����, ����ð� -->
					<img src="../image/<%= thumnail[2] %>" width=100% height=100%>
					<h3><%= title[2] %></h3>
					<p class="description">
						<%= description[2] %>
						<div style="display: none"><%= file_name[2] %></div>
					</p>
					<p class="ui-li-aside"><strong><%= time[2] %>��</strong></p>
				</a>
			</li>					
			
		</ul>	

	</section> 

	<!-- 3. Ǫ�� -->
	<footer data-role="footer" data-theme="a" data-position="fixed">
        <%@ include file="../businessInfo.inc" %>
	</footer>

</section>

<section data-role="page" id="page2">

	<!-- 1. ��� -->
	<header data-role="header" data-theme="b">
		<!-- ��� Ÿ��Ʋ -->
		<h1 id="p2_title"></h1>
	</header> 

	<!-- 2. ���� -->
	<section data-role="content"> 

		<video id="p2_video" width="100%" preload="false" controls="controls">
		</video>
		
		<p id="p2_desc"></p> 
		
	</section> 
	
	<!-- 3. Ǫ�� -->
	<footer data-role="footer" data-theme="a" data-position="fixed">
        <%@ include file="../businessInfo.inc" %>
	</footer>

</section> 

</body>
</html>