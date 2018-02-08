<%@page import="user.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="stylesheet"
	href="/HaveANiceDream/Theme/assets/css/chatbox.css">

<title>DASHGUM - Bootstrap Admin Template</title>

</head>

<body>
	<%	MemberDTO user = (MemberDTO) session.getAttribute("user"); %>

	<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
	<!--header start-->
	<header class="header black-bg" style="background-color: white; height: 80px; padding-top: 10px; border-bottom: solid 2px #e8e8e8; padding-top: 10px; border-top: solid 1px #e8e8e8;">
		<div class="sidebar-toggle-box">
			<div class="fa fa-bars tooltips" data-placement="right"
				data-original-title="Toggle Navigation"></div>
		</div>
		<!--logo start-->
		<a href="/HaveANiceDream/index.html" class="logo" ><b style="color: black; padding-left: 20px">HAVE A
				NICE DREAM</b></a>
		<!--logo end-->
		<div class="nav notify-row" id="top_menu">
			<!--  notification start -->
			<ul class="nav top-menu">
				<!-- inbox dropdown start-->
				<li id="header_inbox_bar" class="dropdown"><a
					data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
						<i class="fa fa-envelope-o"></i> <span class="badge bg-theme"
						id="notenum">0</span>
				</a>
					<ul class="dropdown-menu extended inbox" id="talklist">
						<div class="notify-arrow notify-arrow-green"></div>

					</ul></li>
				<!-- inbox dropdown end -->
			</ul>
			<!--  notification end -->
		</div>
		<div class="top-menu">
			<ul class="nav pull-right top-menu">
				<%
				
					if (user == null) {
				%>
				<li><a class="logout" href="/HaveANiceDream/user/login.html" style="background-color: #d12438; border: none;">Login</a></li>
				<li><a class="logout"
					href="javascript:setPath('../user/sign_in_page.jsp')" style="background-color: #d12438; border: none;">Signup</a></li>
				<%
					} else {
				%>
				<li><a class="logout" href="javascript:logout()" style="background-color: #d12438; border: none;">Logout</a></li>
				<%
					}
				%>
			</ul>
		</div>
	</header>
	<% if(user !=null){%>
	<div id="chatarea"></div>
	<%} %>
	<!--header end-->
	<!-- 카카오 SDK -->
	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script type="text/javascript">
		var wSocket = new WebSocket("ws://localhost:8088/HaveANiceDream/user/chat");
		
		function setPath(url) {
			location.href = "/HaveANiceDream/view.html?url=" + url;
		}

		function logout() {
	<%if (user != null) {
				String type = user.getUserLogType();
				if (type.equals("Kakao")) {%>
		Kakao.init('78cecbcfa10a98bcb341599df55a3441');

			Kakao.Auth.logout(function() {
				setTimeout(function() {
					location.href = "/HaveANiceDream/user/logout.do";

				}, 1000);

			});
	<%} else {%>
		location.href = "/HaveANiceDream/user/logout.do";
	<%}
			}%>
		}

		
	<%if (user != null) {%>
	you = "";
	youimg = "";
		$(document).ready(function() {
			
			
			$.ajax({
				url : "/HaveANiceDream/note/getnewnotenum.do",
				type : "GET",
				data : {
					"userId" : "<%=user.getUserId()%>"
				},
				dataType : "text",
				success : function(resp) {
					$("#notenum").text(resp);

				}
			});

			
			$.ajax({
				url : "/HaveANiceDream/note/getyoulist.do",
				type : "GET",
				data : {
					"userId" : "<%=user.getUserId()%>"
				},
				dataType : "json",
				success : function(resp) {
					//alert(resp.list[0].name);
					var size = resp.list.length;
					for(var i=0;i<size;i++){
						var talkunit = "<li><a id='lst"+i+"'> <span class='photo'>"
						+"<img alt='avatar' src='/HaveANiceDream/uploadresources/user/"+resp.list[i].img+"'/></span> "
						+"<span class='subject'> <span class='from'>"+resp.list[i].name+"</span></span></a></li>";
						
						$("#talklist").append(talkunit);
						var temp = "#lst"+i;
						$(temp).on("click", {id : resp.list[i].id,name : resp.list[i].name}, function(e) {
							showTalkList(e.data.id, e.data.name);
						});
					}

				}
			});
			
			chatSet();

		});
		
		function chatSet() {
			var $chatbox = $('.chatbox'),
			$chatboxTitle = $('.chatbox__title'),
			$chatboxTitleClose = $('.chatbox__title__close');
			
			$chatboxTitle.on('click', function() {
        		$chatbox.toggleClass('chatbox--tray');
      		});
			
	        $chatboxTitleClose.on('click', function(e) {
	            e.stopPropagation();
	            $chatbox.addClass('chatbox--closed');
	        });
        
        $chatbox.on('transitionend', function() {
            if ($chatbox.hasClass('chatbox--closed')) $chatbox.remove();
        });      
        
        $('.chatbox__message').keypress(function (e) {
            if (e.which == 13){
            	var str = $(this).val();
            	var msg = '<div class="chatbox__body__message chatbox__body__message--right">'
            	+'<img src="'+'/HaveANiceDream/uploadresources/user/<%=user.getUserImage()%>'+'" alt="Picture">'
            	+'<p>'+str+'</p></div>';
            	$(".chatbox__body").append(msg);
            	var data = {
            			"type" : "text",
            			"from" : '<%=user.getUserId()%>',
            			"to" : you+"",
            			"text" : str
            	}
        		wSocket.send(JSON.stringify(data));
            	$(this).val("");
        		$('.chatbox__body').scrollTop($('.chatbox__body').prop('scrollHeight'));
            }
        });
		}
		
		wSocket.onopen = function(e) {
        	var data = {
        			"type" : "info",
        			"id" : '<%=user.getUserId()%>'
        	}
    		wSocket.send(JSON.stringify(data));
		}

		wSocket.onmessage = function(e) {
			//alert(e.data);
			var data = JSON.parse(e.data);
			if(data.from == you && data.to=='<%=user.getUserId()%>'){
        	var msg = '<div class="chatbox__body__message chatbox__body__message--left">'
            	+'<img src="/HaveANiceDream/uploadresources/user/'+youimg+'" alt="Picture">'
            	+'<p>'+data.text+'</p></div>';
		
        $(".chatbox__body").append(msg);
        $('.chatbox__body').scrollTop($('.chatbox__body').prop('scrollHeight'));
			}
			//document.getElementById("ta").value += (e.data+"\n");
		}
		
		function showTalkList(selyou,name) {
			you = selyou;
			//alert('test');
			
        	$("#chatarea").empty();
        	
        	var chatarea = "<div class='chatbox chatbox--tray'><div class='chatbox__title'><h5><a href=#'>"
        	+name+"</a></h5><button class='chatbox__title__tray'><span></span></button>"
        	+"<button class='chatbox__title__close'><span>"
        	+"<svg viewBox='0 0 12 12' width='12px' height='12px'>"
        	+"<line stroke='#FFFFFF' x1='11.75' y1='0.25' x2='0.25' y2='11.75'></line>"
        	+"<line stroke='#FFFFFF' x1='11.75' y1='11.75' x2='0.25' y2='0.25'></line>"
        	+"</svg></span></button></div><div class='chatbox__body'></div>"
        	+"<input type='text' class='chatbox__message' placeholder='Write something interesting'/></div>";

        	$("#chatarea").append(chatarea);
        	
        	chatSet();
        	
			$.ajax({
				url : "/HaveANiceDream/note/talklist.do",
				type : "GET",
				data : {
					"me" : '<%=user.getUserId()%>',
					"you" : you+""
				},
				dataType : "json",
				success : function(resp) {
					var size = resp.list.length;
					youimg = resp.yourimg;
					for(var i=0;i<size;i++){
						var msg = "";
						if (resp.list[i].from == '<%=user.getUserId()%>'){
			            	msg = '<div class="chatbox__body__message chatbox__body__message--right">'
			                	+'<img src="/HaveANiceDream/uploadresources/user/'+'<%=user.getUserImage()%>'+'" alt="Picture">'
			                	+'<p>'+resp.list[i].content+'</p></div>';
						} else if(resp.list[i].from == you){
			            	msg = '<div class="chatbox__body__message chatbox__body__message--left">'
			                	+'<img src="/HaveANiceDream/uploadresources/user/'+youimg+'" alt="Picture">'
			                	+'<p>'+resp.list[i].content+'</p></div>';
						}
			            $(".chatbox__body").append(msg);
			            $('.chatbox__body').scrollTop($('.chatbox__body').prop('scrollHeight'));
					}

				}
			});
		}
	<%}%>
		
	</script>

</body>
</html>
