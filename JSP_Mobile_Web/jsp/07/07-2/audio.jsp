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
	    // Ŭ���� ��ü(this) ���� div ������Ʈ�� ������(text) ����
		var videoTitle = $(this).find('div').text();	
		
		// audio ������Ʈ �ν�(�迭�� ��ȯ) 
		var myAudio = $("#audio");
		// �����(ù ��° �ſ����� �ش�) ����   
		myAudio.get(0).pause();
		// ����� �ҽ� ��� ���� 	
		myAudio.attr('src', "./audio/" + videoTitle);
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
	
	    <!-- ��� -->
		<ul data-role="listview" data-inset="true" data-theme="e"> 
	
			<!-- ��� ������ 1 -->
			<li>
				<a href="#">			
					<!-- �����: ����, ��Ƽ��Ʈ, �ҽ�, ����ð� -->
					<h3>�б���</h3>
					<p>
						��޸�<br>
						<div style="display: none">schoolBell.mp3</div>
					</p>
					<p class="ui-li-aside"><strong>00:19</strong>��</p>	
                </a>
			</li>				

			<!-- ��� ������ 2 -->
			<li>
				<a href="#">			
					<!-- �����: ����, ��Ƽ��Ʈ, �ҽ�, ����ð� -->
					<h3>�ڳ��� ������</h3>
					<p>
						������/������<br>
						<div style="display: none">elephant.mp3</div>
					</p>
					<p class="ui-li-aside"><strong>00:16</strong>��</p>	
                </a>
			</li>				

			<!-- ��� ������ 3 -->
			<li>
				<a href="#">			
					<!-- �����: ����, ��Ƽ��Ʈ, �ҽ�, ����ð� -->
					<h3>���䳢</h3>
					<p>
						���Ϸ�<br>
						<div style="display: none">hare.mp3</div>
					</p>
					<p class="ui-li-aside"><strong>00:16</strong>��</p>	
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