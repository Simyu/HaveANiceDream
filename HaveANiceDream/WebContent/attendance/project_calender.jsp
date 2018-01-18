<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta charset='utf-8'>
<meta name="description" content="A method for responsive tables">


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="/HaveANiceDream/Theme/assets/css/monthly.css">


</head>
<body>
	<h3>
		<i class="fa fa-angle-right"></i>출석체크
	</h3>
	<div class="form-panel">
		<div class="row mt">
			<div class="col-lg-12 calender-board">
				<div class="page">
					<div style="width: 100%; max-width: 600px; display: inline-block;">
						<div class="monthly" id="mycalendar"></div>
					</div>

				</div>
				<div class="col-lg-12">
					<br /> <br /> <br /> <br />
					<button class="btn btn-theme02" type="button">출석체크</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="/HaveANiceDream/Theme/assets/js/monthly.js"></script>
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