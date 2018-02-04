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
	<header class="header black-bg">
		<div class="sidebar-toggle-box">
			<div class="fa fa-bars tooltips" data-placement="right"
				data-original-title="Toggle Navigation"></div>
		</div>
		<!--logo start-->
		<a href="/HaveANiceDream/index.html" class="logo"><b>HAVE A
				NICE DREAM</b></a>
		<!--logo end-->
		<div class="nav notify-row" id="top_menu">
			<!--  notification start -->
			<ul class="nav top-menu">
				<!-- settings start -->
				<li class="dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" href="index.html#"> <i
						class="fa fa-tasks"></i> <span class="badge bg-theme">4</span>
				</a>
					<ul class="dropdown-menu extended tasks-bar">
						<div class="notify-arrow notify-arrow-green"></div>
						<li>
							<p class="green">You have 4 pending tasks</p>
						</li>
						<li><a href="index.html#">
								<div class="task-info">
									<div class="desc">DashGum Admin Panel</div>
									<div class="percent">40%</div>
								</div>
								<div class="progress progress-striped">
									<div class="progress-bar progress-bar-success"
										role="progressbar" aria-valuenow="40" aria-valuemin="0"
										aria-valuemax="100" style="width: 40%">
										<span class="sr-only">40% Complete (success)</span>
									</div>
								</div>
						</a></li>
						<li><a href="index.html#">
								<div class="task-info">
									<div class="desc">Database Update</div>
									<div class="percent">60%</div>
								</div>
								<div class="progress progress-striped">
									<div class="progress-bar progress-bar-warning"
										role="progressbar" aria-valuenow="60" aria-valuemin="0"
										aria-valuemax="100" style="width: 60%">
										<span class="sr-only">60% Complete (warning)</span>
									</div>
								</div>
						</a></li>
						<li><a href="index.html#">
								<div class="task-info">
									<div class="desc">Product Development</div>
									<div class="percent">80%</div>
								</div>
								<div class="progress progress-striped">
									<div class="progress-bar progress-bar-info" role="progressbar"
										aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
										style="width: 80%">
										<span class="sr-only">80% Complete</span>
									</div>
								</div>
						</a></li>
						<li><a href="index.html#">
								<div class="task-info">
									<div class="desc">Payments Sent</div>
									<div class="percent">70%</div>
								</div>
								<div class="progress progress-striped">
									<div class="progress-bar progress-bar-danger"
										role="progressbar" aria-valuenow="70" aria-valuemin="0"
										aria-valuemax="100" style="width: 70%">
										<span class="sr-only">70% Complete (Important)</span>
									</div>
								</div>
						</a></li>
						<li class="external"><a href="#">See All Tasks</a></li>
					</ul></li>
				<!-- settings end -->
				<!-- inbox dropdown start-->
				<li id="header_inbox_bar" class="dropdown"><a
					data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
						<i class="fa fa-envelope-o"></i> <span class="badge bg-theme" id="notenum">0</span>
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
				<li><a class="logout" href="/HaveANiceDream/user/login.html">Login</a></li>
				<li><a class="logout"
					href="javascript:setPath('../user/sign_in_page.jsp')">Signup</a></li>
				<%
					} else {
				%>
				<li><a class="logout" href="javascript:logout()">Logout</a></li>
				<%
					}
				%>
			</ul>
		</div>
	</header>
<% if(user !=null){%>
<div id="chatarea">	

</div>
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
					//alert(resp);
					var size = resp.list.length;
					for(var i=0;i<size;i++){
						var talkunit = "<li><a href='javascript:showTalkList('"+resp.list[i].id+"')'> <span class='photo'>"
						+"<img alt='avatar' src='/HaveANiceDream/uploadresources/user/"+resp.list[i].img+"''></span> "
						+"<span class='subject'> <span class='from'>"+resp.list[i].name+"</span> </span></a></li>";
						$("#talklist").append(talkunit);
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
            			"from" : '<%=user.getUserImage()%>',
            			"to" : you,
            			"text" : str
            	}
        		wSocket.send(JSON.stringify(data));
            	$(this).val("");
        		$('.chatbox__body').scrollTop($('.chatbox__body').prop('scrollHeight'));
            }
        });
		}


		wSocket.onmessage = function(e) {
			//alert(e.data);
			var data = JSON.parse(e.data);
			if(data.from == you){
        	var msg = '<div class="chatbox__body__message chatbox__body__message--left">'
            	+'<img src="/HaveANiceDream/uploadresources/user/'+youimg+'" alt="Picture">'
            	+'<p>'+data.text+'</p></div>';
		
        $(".chatbox__body").append(msg);
        $('.chatbox__body').scrollTop($('.chatbox__body').prop('scrollHeight'));
			}
			//document.getElementById("ta").value += (e.data+"\n");
		}
		
		function showTalkList(selyou) {
			you = selyou;
        	$("#chatarea").empty();
        	var chatarea = "<div class='chatbox chatbox--tray'><div class='chatbox__title'><h5><a href=#'>"
        	+you+"</a></h5><button class='chatbox__title__tray'><span></span></button>"
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
					"me" : '<%=user.getUserImage()%>',
					"you" : you
				},
				dataType : "json",
				success : function(resp) {
					var size = resp.list.length;
					youimg = resp.yourimg;
					for(var i=0;i<size;i++){
						var msg = "";
						if (resp.list[i].from == 'a'){
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
