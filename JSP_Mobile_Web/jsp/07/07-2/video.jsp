<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=euc-kr"%>
<html>
<head>
<title>JSP World</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- jQuery/jQuery Mobile ���̺귯�� ��� -->
<%@ include file="jQueryMobile.inc" %>

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
		video.attr('src', "./video/" + videoSrc);
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
	
	    <!-- ��� -->
		<ul data-role="listview" data-inset="true" data-theme="e"> 

    		<!-- ��� ������ 1 -->
			<li>
				<a href="#page2" data-rel="dialog" data-transition="pop">
					<!-- ����: ������̹���, ����, ����, ����ð� -->
					<img src="fountain_night.png" width=100% height=100%>
					<h3>���� �м����� �߰�</h3>
					<p class="description">
						����, ������ ����
						<div style="display: none">fountain_night.mp4</div>
					</p>
					<p class="ui-li-aside"><strong>00:05��</strong></p>
				</a>
			</li>				

    		<!-- ��� ������ 2 -->
			<li>
				<a href="#page2" data-rel="dialog" data-transition="pop">
					<!-- ����: ������̹���, ����, ����, ����ð� -->
					<img src="creek_rock.png" width=100% height=100%>
					<h3>���</h3>
					<p class="description">
						��⵵ ����, �빮��
						<div style="display: none">creek_rock.mp4</div>
					</p>
					<p class="ui-li-aside"><strong>00:03��</strong></p>
				</a>
			</li>				

    		<!-- ��� ������ 3 -->
			<li>
				<a href="#page2" data-rel="dialog" data-transition="pop">
					<!-- ����: ������̹���, ����, ����, ����ð� -->
					<img src="waterfall_street.png" width=100% height=100%>
					<h3>û��õ����</h3>
					<p class="description">
						����, û��õ
						<div style="display: none">waterfall_street.mp4</div>
					</p>
					<p class="ui-li-aside"><strong>00:03��</strong></p>
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