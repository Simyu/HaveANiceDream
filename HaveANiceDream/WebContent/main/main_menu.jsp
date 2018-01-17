<%@ page language="java" contentType="text/html; charset=utf-8"
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

<title>DASHGUM - Bootstrap Admin Template</title>

<script type="text/javascript">
	function setPath(url) {

		location.href = "/HaveANiceDream/view.html?url=" + url;
	}
</script>

</head>

<body>


	<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
	<!--sidebar start-->
	<aside>
		<div id="sidebar" class="nav-collapse ">
			<!-- sidebar menu start-->
			<ul class="sidebar-menu" id="nav-accordion">

				<p class="centered">
					<a href="javascript:setPath('../user/user_detail.jsp')"><img
						src="/HaveANiceDream/Theme/assets/img/ui-sam.jpg"
						class="img-circle" width="60"></a>
				</p>
				<h5 class="centered">Marcel Newman</h5>

				<li class="mt"><a class="active" href="index.html"> <i
						class="fa fa-dashboard"></i> <span>Dashboard</span>
				</a></li>

				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-desktop"></i> <span>My page</span>
				</a>
					<ul class="sub">
						<li><a href="#">거래내역 조회</a></li>
						<li><a href="javascript:setPath('../point/point_detail.jsp')">포인트 조회</a></li>
						<li><a href="panels.html">Panels</a></li>
					</ul></li>

				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-cogs"></i> <span>거래</span>
				</a>
					<ul class="sub">
						<li><a href="javascript:setPath('../product/product_view_edit.jsp')">물품등록</a></li>
						<li><a href="gallery.html">Gallery</a></li>
						<li><a href="todo_list.html">Todo List</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-book"></i> <span>Extra Pages</span>
				</a>
					<ul class="sub">
						<li><a href="blank.html">Blank Page</a></li>
						<li><a href="login.html">Login</a></li>
						<li><a href="lock_screen.html">Lock Screen</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-tasks"></i> <span>Forms</span>
				</a>
					<ul class="sub">
						<li><a href="form_component.html">Form Components</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
						class="fa fa-th"></i> <span>신고</span>
				</a>
					<ul class="sub">
						<li><a href="javascript:setPath('../blame/report_boss.jsp')">신고하기</a></li>
						<li><a href="javascript:setPath('../blame/reportview_report.jsp')">신고내역조회</a></li>
					</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
						class=" fa fa-bar-chart-o"></i> <span>관리자</span>
				</a>
					<ul class="sub">
						<li><a href="javascript:setPath('../user/blacklist_page.jsp')">차단유저 조회</a></li>
						<li><a href="javascript:setPath('../blame/reportview_center.jsp')">신고접수내역</a></li>
					</ul></li>

			</ul>
			<!-- sidebar menu end-->
		</div>
	</aside>
	<!--sidebar end-->



</body>
</html>
