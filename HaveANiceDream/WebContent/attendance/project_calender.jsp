<%@page import="user.dto.MemberDTO"%>
<%@page import="attendance.dto.AttendanceDTO"%>
<%@page import="java.sql.Date"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	
<%MemberDTO dto = (MemberDTO) session.getAttribute("user");
			//System.out.println(dto);%>
	$(document).ready(
			function() {
				$("#click").on(
						"click",
						function() {
							location.href = "/HaveANiceDream/attendance/insert.do";
							
							/* arr = [ "5", "4" ];
							for (i = 0; i < arr.length; i++) {
								$("a[data-number='" + arr[i] + "']").css(
										"background-color", "blue");

							} */
						});

			});
</script>
</head>
<body>
	<%
		ArrayList<Date> date = (ArrayList) request.getAttribute("attDate");
		//System.out.println(date);
	%>
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
					<%
						if (!(boolean) session.getAttribute("attFlag")) {
					%>
					<button class="btn btn-theme02" type="button" name="check"
						id="click">출석체크</button>

					<%
						}
					%>
				</div>

			</div>
		</div>
	</div>



</body>
</html>