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

<!-- Bootstrap core CSS -->
<link href='https://fonts.googleapis.com/css?family=Yanone+Kaffeesatz'	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="/HaveANiceDream/Theme/assets/css/monthly.css">
<link href="/HaveANiceDream/Theme/assets/css/bootstrap.css"
	rel="stylesheet">
<!--external css-->
<link
	href="/HaveANiceDream/Theme/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link href="/HaveANiceDream/Theme/assets/js/fancybox/jquery.fancybox.css" rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="/HaveANiceDream/Theme/assets/css/style.css" rel="stylesheet">
<link href="/HaveANiceDream/Theme/assets/css/style-responsive.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<section id="container">
		<jsp:include page="top.jsp"></jsp:include>

		<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->

		<jsp:include page="main_menu.jsp"></jsp:include>

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<jsp:include page="${viewpath}"></jsp:include>
			</section>
			<!--/wrapper -->
		</section>
		<!-- /MAIN CONTENT -->

		<!--main content end-->

		<jsp:include page="footer.jsp"></jsp:include>
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/HaveANiceDream/Theme/assets/js/fancybox/jquery.fancybox.js"></script>   
	<script src="/HaveANiceDream/Theme/assets/js/jquery.js"></script>
	<script src="/HaveANiceDream/Theme/assets/js/bootstrap.min.js"></script>
	<script
		src="/HaveANiceDream/Theme/assets/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script
		src="/HaveANiceDream/Theme/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script class="include" type="text/javascript"
		src="/HaveANiceDream/Theme/assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/HaveANiceDream/Theme/assets/js/jquery.scrollTo.min.js"></script>
	<script src="/HaveANiceDream/Theme/assets/js/jquery.nicescroll.js"type="text/javascript"></script>
	<script type="text/javascript" src="/HaveANiceDream/Theme/assets/js/monthly.js"></script>
	<!--common script for all pages-->
	<script src="/HaveANiceDream/Theme/assets/js/common-scripts.js"></script>

	<!--script for this page-->

	<script>
		//custom select box

		$(function() {
			$('select.styled').customSelect();
		});
	</script>
	  <script type="text/javascript">
      $(function() {
        //    fancybox
          jQuery(".fancybox").fancybox();
      });

  </script>
  <script type="text/javascript">
						$(window).load(function() {

							$('#mycalendar').monthly({
								mode : 'event',
								xmlUrl : 'events.xml'
							});

							$('#mycalendar2').monthly({
								mode : 'picker',
								target : '#mytarget',
								maxWidth : '250px',
								startHidden : true,
								showTrigger : '#mytarget',
								stylePast : true,
								disablePast : true
							});
						});
	</script>
	
</body>
</html>
