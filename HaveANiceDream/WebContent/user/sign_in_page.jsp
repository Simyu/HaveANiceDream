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

<title>DASHGUM - Bootstrap Admin Template</title>

</head>

<body>

	<h3>
		<i class="fa fa-angle-right"></i> 회원가입
	</h3>
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">
				<form class="form-horizontal style-form" 
				action="/HaveANiceDream/user/insert.do" method="post">
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">아이디</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="userId">
						</div>
						<div class="col-sm-2">
							<button type="button"
								class="btn btn-round btn-primary form-control">중복체크</button>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">비밀번호</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" placeholder=""
								name="userPw">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">비밀번호 확인</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" placeholder="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="userName">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">주소</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="userZipcode">
						</div>
						<div class="col-sm-2">
							<button type="button"
								class="btn btn-round btn-primary form-control">우편번호 검색</button>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label"></label>
						<div class="col-sm-5">
							<input type="text" class="form-control" name="userAddr1">
						</div>
						<div class="col-sm-5">
							<input type="text" class="form-control" name="userAddr2">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">이메일</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="userEmail1"
								id="userEmail1">
						</div>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="userEmail2"
								id="userEmail2">
						</div>
						<div class="btn-group col-sm-4">
							<button type="button" class="btn dropdown-toggle"
								data-toggle="dropdown">
								이메일 선택 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="javascript:setEmailAddr('@google.com')">@google.com</a></li>
								<li><a href="javascript:setEmailAddr('@naver.com)">@naver.com</a></li>
								<li><a href="javascript:setEmailAddr('@hanmail.net')">@hanmail.net</a></li>
							</ul>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">전화번호</label> 
						<div class="col-sm-3">
							<select class="form-control" name="userTel1">
								<option>전화번호 선택</option>
								<option>010</option>
								<option>011</option>
							</select>
						</div>
						<div class="col-sm-2">
							<input type="text" class="form-control" name="userTel2">
						</div>
						<div class="col-sm-2">
							<input type="text" class="form-control" name="userTel3">
						</div>
					</div>
					<button type="submit" class="btn btn-theme">Sign in</button>
				</form>
			</div>
		</div>
	</div>

	<!--main content end-->
	<script type="text/javascript">
		function setEmailAddr(mail) {
			document.getElementById("userEmail2").value = mail;
		}
	</script>


</body>
</html>
