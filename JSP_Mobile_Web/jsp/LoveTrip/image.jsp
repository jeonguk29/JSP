<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=euc-kr"%>
<html>
<head>
<title>JSP World</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ include file="./include/jQueryMobile.inc" %>

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

$(function() {
	$('ol li a').click(function() {
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

<!-- ù ��° ������: ���� -->
<section data-role="page" id="page1">

	<!-- 1. ��� -->
<header data-role="header" data-theme="a">
		<!-- ��� Ÿ��Ʋ -->
		<h1>date list</h1>
	</header> 


	<!-- 2. ���� -->
	<section data-role="content"> 
	
		<%
		// �̹��� �迭
		String[] index       = {"2", "3", "4"};
		String[] title       = {"ũ�������� ����Ʈ ���", "�ν�Ÿ ���� ī�� 10��", "��ʽ���"};
		String[] image_name  = {"a1.jpg", "b1.jpg", "a3.jpg"};
		String[] description = {"ũ���������� ���� ���� ����ǳ ���� ���� 8��", "���� ������ ������ �� �ִ� �׶� ī�� 10��", "������ ��긣�̼���"};
		%>
	
	    <!-- ��� -->
		<ul data-role="listview" data-inset="true" data-theme="c"> 

		    <%
			for (int i=0; i<title.length; i++) { 
			%>
				<!-- ��� ������ -->
				<li>
					<a href="#page<%= index[i] %>" data-rel="dialog" data-transition="pop">
						<!-- �̹���: �ҽ�, ����, ���� -->
						<img src="./image/<%= image_name[i] %>" width=100% height=100%>
						<h3><%= title[i] %></h3>
						<p><%= description[i] %></p>
					</a>
				</li>				
		    <%
			}  
			%>
			
		</ul>	


		<%
		// ���� �迭 
		String[] thumnail = {"1.jpg", "2.jpg", "waterfall_street.png"};
		String[] titlev = {"���� �м����� �߰�", "���", "û��õ����"};
		String[] descriptionv = {"����, ������ ����", "��⵵ ����, �빮��", "����, û��õ"};
		String[] file_namev = {"1.MP4", "2.MP4", "creek_rock.mp4"};
		String[] timev = {"00:05", "00:03", "00:03"};
		%>
		
		<ol data-role="listview" data-inset="true" data-theme="e"> 

		    <%
			for (int i=0; i<title.length; i++) { 
			%>
				<!-- ��� ������ -->
				<li>
					<a href="#page4" data-rel="dialog" data-transition="pop">
						<!-- ����: ������̹���, ����, ����, ����ð� -->
						<img src="./video/image/<%= thumnail[i] %>" width=100% height=100%>
						<h3><%= titlev[i] %></h3>
						<p class="description">
							<%= descriptionv[i] %>
							<div style="display: none"><%= file_namev[i] %></div>
						</p>
						<p class="ui-li-aside"><strong><%= timev[i] %>��</strong></p>
					</a>
				</li>				
		    <%
			}  
			%>
			
		</ol>	

	</section> 

	<!-- 3. Ǫ�� -->
	<footer data-role="footer" data-theme="a" data-position="fixed">
        <%@ include file="./include/businessInfo.inc" %>
	</footer>

</section>
<!-- ù ��° ������: ���� -->



<!-- �� ���� ������: ���� -->
<section data-role="page" id="page2">

	<!-- 1. ��� -->
	<header data-role="header" data-theme="a">
		<!-- �̹��� ���� -->
		<h1 id="p2_title"></h1>
	</header> 

	<!-- 2. ���� -->
	<section data-role="content"> 
		<%
		// �̹��� �迭
		String[] title2       = {"ũ�������� ����Ʈ ���", "����ž", "��ʽ���"};
		String[] image_name2  = {"a2.jpg", "a3.jpg", "a4.jpg", "a5.jpg", "a6.jpg","a7.jpg"};
		String[] description2 = {"ũ���������� ���� ���� ����ǳ ���� ���� 8��", "������ �ĸ�", "������ ��긣�̼���"};
		%>
        <!-- �̹��� �ҽ� --> 
		<img id="p2_image" width="100%">
		
		<!-- �̹��� ���� -->
		<ul data-role="listview" data-inset="true" data-theme="a"> 

		    <%
			for (int i=0; i<image_name2.length; i++) { 
			%>
				<!-- ��� ������ -->
				
						<img src="./image/<%= image_name2[i] %>" width=100% height=100%>			
		    <%
			}  
			%>
			
		</ul>	

	</section> 

</section> 
<!-- �� ��° ������: �� -->



<!-- 3 ���� ������: ���� -->
<section data-role="page" id="page3">

	<!-- 1. ��� -->
	<header data-role="header" data-theme="a">
		<!-- �̹��� ���� -->
		<h1 id="p2_title"></h1>
	</header> 

	<!-- 2. ���� -->
	<section data-role="content"> 
		<%
		// �̹��� �迭
		String[] title3       = {"ũ�������� ����Ʈ ���", "����ž", "��ʽ���"};
		String[] image_name3  = {"b1.jpg","b2.jpg", "b3.jpg", "b4.jpg", "b5.jpg", "b6.jpg","b7.jpg"};
		String[] description3 = {"ũ���������� ���� ���� ����ǳ ���� ���� 8��", "������ �ĸ�", "������ ��긣�̼���"};
		%>
        <!-- �̹��� �ҽ� --> 
		<img id="p2_image" width="100%">
		
		<!-- �̹��� ���� -->
		<ul data-role="listview" data-inset="true" data-theme="a"> 

		    <%
			for (int i=0; i<image_name3.length; i++) { 
			%>
				<!-- ��� ������ -->
				
						<img src="./image/<%= image_name3[i] %>" width=100% height=100%>			
		    <%
			}  
			%>
			
		</ul>	

	</section> 

</section> 
<!-- 3 ��° ������: �� -->


</section>

<section data-role="page" id="page4">

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
        <%@ include file="./include/businessInfo.inc" %>
	</footer>

</section> 

</body>
</html>