<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function setPath(){
		alert("출석체크완료");
		location.href="/HaveANiceDream/attendance/insert.do";
	}
	
</script>
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
					<button class="btn btn-theme02" type="button" onclick="setPath()"id="check">출석체크</button>
				</div>
			</div>
		</div>
	</div>



</body>
</html>