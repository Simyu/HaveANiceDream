<%@page import="user.dto.MemberDTO"%>
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

</head>

<body>
	<h3>
		<i class="fa fa-angle-right"></i> 내 정보 보기
	</h3>
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">
				<%
					MemberDTO user = (MemberDTO) session.getAttribute("user");
				%>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">아이디</label>
					<div class="col-lg-10">
						<p class="form-control-static"><%=user.getUserId()%></p>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">비밀번호</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" placeholder=""
							value="<%=user.getUserPw()%>">
					</div>
					<div class="col-sm-2">
						<button type="button"
							class="btn btn-round btn-primary form-control">변경하기</button>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">이름</label>
					<div class="col-lg-10">
						<p class="form-control-static"><%=user.getUserName()%></p>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">주소</label>
					<div class="col-lg-10">
						<p class="form-control-static">
							(<%=user.getUserZipcode()%>)
							<%=user.getUserAddr()%> <%=user.getUserAddrDetail() %></p>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">이메일</label>
					<div class="col-lg-10">
						<p class="form-control-static"><%=user.getUserEmail()%></p>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">전화번호</label>
					<div class="col-lg-10">
						<p class="form-control-static"><%=user.getUserTel()%></p>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">포인트</label>
					<div class="col-lg-10">
						<p class="form-control-static"><%=user.getPointTotal()%>점
						</p>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">가입날짜</label>
					<div class="col-lg-10">
						<p class="form-control-static"><%=user.getUserSigdate()%></p>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">최종 방문일</label>
					<div class="col-lg-10">
						<p class="form-control-static"><%=user.getUserLastLoginTime()%></p>
					</div>
				</div>
				<hr>
				<button class="btn btn-theme"
					onclick="location.href='/HaveANiceDream/view.html?url=../user/user_edit_page.jsp'">내
					정보 변경하기</button>
			</div>
		</div>
		<!-- col-lg-12-->
	</div>
	<!-- /row -->

</body>
</html>
