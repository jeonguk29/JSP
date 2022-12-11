<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=euc-kr"%>
<html>
<head>
<title>JSP World</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ include file="./include/jQueryMobile.inc" %>

<script type="text/javascript">
// 웹문서 로딩이 완료된 후에 실행할 함수 정의 
$(function() {
    // HTML DOM Tree 구조에 따라 <ul>, <li>, <a> 엘리먼트가 클릭되면 실행될 함수 정의
	$('ul li a').click(function() {
	    ///// page1 /////
	    // 클릭된 개체(this) 내의 각 엘리먼트를 찾아(find), 그 속성(attr) 또는 데이터(text) 인식
		var imageSrc   = $(this).find('img').attr('src');
		var imageTitle = $(this).find('h3').text();	
		var imageDesc  = $(this).find('p').text();

		///// page2 /////
		// id를 이용한 개체 인식 및 값 할당
		// 이미지 소스 변경
	
		$("#p2_image").attr('src', imageSrc);	
		// 개체에 HTML 문자로 쓰기
		$("#p2_title").html(imageTitle);	
		$("#p2_desc").html(imageDesc);	
		
	});
});

$(function() {
	$('ol li a').click(function() {
	    /// page1 ///
	    // 클릭된 개체(this) 내의 각 엘리먼트를 찾아(find), 그 속성(attr) 또는 데이터(text) 인식
		var videoTitle = $(this).find('h3').text();	
		var videoSrc   = $(this).find('div').text();	
		var videoDesc  = $(this).find('p.description').text();	

		/// page2 ///
		// video 제목과 설명 출력 
		$("#p2_title").html(videoTitle);	
		$("#p2_desc").html(videoDesc);
		
		// 비디오 소스 변경과 실행 	
		var video = $("#p2_video");
		video.attr('src', "./video/" + videoSrc);
		video.get(0).play();
	});
	
	$('#page2').click(function() {
		// 기존 실행 중인 비디오 중지
		$("#p2_video").get(0).pause();
	});
});

</script>

</head>
<body>

<!-- 첫 번째 페이지: 시작 -->
<section data-role="page" id="page1">

	<!-- 1. 헤더 -->
<header data-role="header" data-theme="a">
		<!-- 헤더 타이틀 -->
		<h1>date list</h1>
	</header> 


	<!-- 2. 본문 -->
	<section data-role="content"> 
	
		<%
		// 이미지 배열
		String[] index       = {"2", "3", "4"};
		String[] title       = {"크리스마스 데이트 장소", "인스타 감성 카페 10곳", "비너스상"};
		String[] image_name  = {"a1.jpg", "b1.jpg", "a3.jpg"};
		String[] description = {"크리스마스를 즐기기 좋은 유럽풍 서울 스팟 8곳", "가을 감성을 충전할 수 있는 테라스 카페 10곳", "프랑스 루브르미술관"};
		%>
	
	    <!-- 목록 -->
		<ul data-role="listview" data-inset="true" data-theme="c"> 

		    <%
			for (int i=0; i<title.length; i++) { 
			%>
				<!-- 목록 아이템 -->
				<li>
					<a href="#page<%= index[i] %>" data-rel="dialog" data-transition="pop">
						<!-- 이미지: 소스, 제목, 설명 -->
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
		// 비디오 배열 
		String[] thumnail = {"1.jpg", "2.jpg", "waterfall_street.png"};
		String[] titlev = {"음악 분수대의 야경", "계곡", "청계천폭포"};
		String[] descriptionv = {"서울, 예술의 전당", "경기도 양평, 용문산", "서울, 청계천"};
		String[] file_namev = {"1.MP4", "2.MP4", "creek_rock.mp4"};
		String[] timev = {"00:05", "00:03", "00:03"};
		%>
		
		<ol data-role="listview" data-inset="true" data-theme="e"> 

		    <%
			for (int i=0; i<title.length; i++) { 
			%>
				<!-- 목록 아이템 -->
				<li>
					<a href="#page4" data-rel="dialog" data-transition="pop">
						<!-- 비디오: 썸네일이미지, 제목, 설명, 재생시간 -->
						<img src="./video/image/<%= thumnail[i] %>" width=100% height=100%>
						<h3><%= titlev[i] %></h3>
						<p class="description">
							<%= descriptionv[i] %>
							<div style="display: none"><%= file_namev[i] %></div>
						</p>
						<p class="ui-li-aside"><strong><%= timev[i] %>분</strong></p>
					</a>
				</li>				
		    <%
			}  
			%>
			
		</ol>	

	</section> 

	<!-- 3. 푸터 -->
	<footer data-role="footer" data-theme="a" data-position="fixed">
        <%@ include file="./include/businessInfo.inc" %>
	</footer>

</section>
<!-- 첫 번째 페이지: 시작 -->



<!-- 두 번쩨 페이지: 시작 -->
<section data-role="page" id="page2">

	<!-- 1. 헤더 -->
	<header data-role="header" data-theme="a">
		<!-- 이미지 제목 -->
		<h1 id="p2_title"></h1>
	</header> 

	<!-- 2. 본문 -->
	<section data-role="content"> 
		<%
		// 이미지 배열
		String[] title2       = {"크리스마스 데이트 장소", "에펠탑", "비너스상"};
		String[] image_name2  = {"a2.jpg", "a3.jpg", "a4.jpg", "a5.jpg", "a6.jpg","a7.jpg"};
		String[] description2 = {"크리스마스를 즐기기 좋은 유럽풍 서울 스팟 8곳", "프랑스 파리", "프랑스 루브르미술관"};
		%>
        <!-- 이미지 소스 --> 
		<img id="p2_image" width="100%">
		
		<!-- 이미지 설명 -->
		<ul data-role="listview" data-inset="true" data-theme="a"> 

		    <%
			for (int i=0; i<image_name2.length; i++) { 
			%>
				<!-- 목록 아이템 -->
				
						<img src="./image/<%= image_name2[i] %>" width=100% height=100%>			
		    <%
			}  
			%>
			
		</ul>	

	</section> 

</section> 
<!-- 두 번째 페이지: 끝 -->



<!-- 3 번쩨 페이지: 시작 -->
<section data-role="page" id="page3">

	<!-- 1. 헤더 -->
	<header data-role="header" data-theme="a">
		<!-- 이미지 제목 -->
		<h1 id="p2_title"></h1>
	</header> 

	<!-- 2. 본문 -->
	<section data-role="content"> 
		<%
		// 이미지 배열
		String[] title3       = {"크리스마스 데이트 장소", "에펠탑", "비너스상"};
		String[] image_name3  = {"b1.jpg","b2.jpg", "b3.jpg", "b4.jpg", "b5.jpg", "b6.jpg","b7.jpg"};
		String[] description3 = {"크리스마스를 즐기기 좋은 유럽풍 서울 스팟 8곳", "프랑스 파리", "프랑스 루브르미술관"};
		%>
        <!-- 이미지 소스 --> 
		<img id="p2_image" width="100%">
		
		<!-- 이미지 설명 -->
		<ul data-role="listview" data-inset="true" data-theme="a"> 

		    <%
			for (int i=0; i<image_name3.length; i++) { 
			%>
				<!-- 목록 아이템 -->
				
						<img src="./image/<%= image_name3[i] %>" width=100% height=100%>			
		    <%
			}  
			%>
			
		</ul>	

	</section> 

</section> 
<!-- 3 번째 페이지: 끝 -->


</section>

<section data-role="page" id="page4">

	<!-- 1. 헤더 -->
	<header data-role="header" data-theme="b">
		<!-- 헤더 타이틀 -->
		<h1 id="p2_title"></h1>
	</header> 

	<!-- 2. 본문 -->
	<section data-role="content"> 

		<video id="p2_video" width="100%" preload="false" controls="controls">
		</video>
		
		<p id="p2_desc"></p> 
		
	</section> 
	
	<!-- 3. 푸터 -->
	<footer data-role="footer" data-theme="a" data-position="fixed">
        <%@ include file="./include/businessInfo.inc" %>
	</footer>

</section> 

</body>
</html>