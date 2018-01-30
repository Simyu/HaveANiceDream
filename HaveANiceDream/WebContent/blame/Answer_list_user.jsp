<%@page import="manager_blame.dto.Manager_BlameDTO"%>
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
<script src="/HaveANiceDream/Theme/assets/js/jquery.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		url : "/HaveANiceDreame/manager_blame/select.do",
		type : "GET",
		data : {
			"blameNo" : opener.document.formlist.list.value
		},
		dataType : "json",
		success : function(res) {
			$("#title").text(res.blameTitle);
			$("#content").text(res.blameContent);
			$("#date").text(res.blameDate);
			$("#answertitle").text(res.answerTitle);
			$("#answercontent").text(res.answerContent);
			$("#answerdate").text(res.answerDate);
		}
	});

});

</script>
</head>
<body>
	<h3>
		<i class="fa fa-angle-right"></i>신고내역
	</h3>

	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">
				<form>
				
					<table class="request-view" cellspacing="0" cellpadding="0"
						summary="표" border="1">
						<colgroup>
							<col style="" />
							<col style="width: 103px;" />
							<col style="width: 95px;" />
						</colgroup>
						<thead>
							<tr>
								<th class="first" scope="col">제목</th>
								<th scope="col">문의일시</th>
								<th scope="col">답변여부</th>
							</tr>
						</thead>
						<tbody>
							<tr class="bg-type">
								<td>
									<div class="inner-box">
										<p class="subject">
											<em class="faq-icon">제목: </em> <span class="slideBtn" id="title">
											</span>
										</p>
										<div class="inner-view" id="content">내용: </div>
									</div>
								</td>
								<td class="linebg">
									<div class="inner-box02" id="date"></div>
								</td>
								<td class="linebg">
									<div class="inner-box02" id="answer">답변완료</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="inner-box">
										
											<p class="subject">
												<em class="faq-icon type02">제목: </em><span class="input-box" id="answertitle"></span>
											</p>
											<div class="inner-view" id="answercontent">내용: </div>
										
									</div>
								</td>
								<td class="linebg02">
									<div class="inner-box02" name="answerdate" id="answerdate"></div>
								</td>
								<td class="linebg02">
									<div class="inner-box02" id="answer_user"></div>
								</td>
							</tr>
						</tbody>
					</table>
					
				</form>
			</div>

		</div>
	</div>

</body>
</html>