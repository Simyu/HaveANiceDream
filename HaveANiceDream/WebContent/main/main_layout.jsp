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
	<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

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
<link rel="stylesheet" type="text/css" href="/HaveANiceDream/Theme/assets/js/gritter/css/jquery.gritter.css" />

<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
-->

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
	<script type="text/javascript" src="/HaveANiceDream/Theme/assets/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="/HaveANiceDream/Theme/assets/js/gritter-conf.js"></script>
	<!--script for this page-->

	<!-- <script>
		//custom select box

		$(function() {
			$('select.styled').customSelect();
		});
	</script> -->
	 <!--  <script type="text/javascript">
      $(function() {
        //    fancybox
          jQuery(".fancybox").fancybox();
      });

  </script> -->
  <script type="text/javascript">
$(window).load(function() {

		$('#mycalendar').monthly({
			
			
		});

	
	});
	</script>
 
	
</body>
</html>
