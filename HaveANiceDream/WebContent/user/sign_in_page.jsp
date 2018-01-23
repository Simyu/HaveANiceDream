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
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" name="userId"
								required="required" onkeyup="idVerify()"> <span
								class="help-block" id="helpId"></span>
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
							<input type="text" class="form-control" name="userZipcode"
								id="userZipcode" readonly="readonly">
						</div>
						<div class="col-sm-2">
							<button type="button"
								class="btn btn-round btn-primary form-control"
								onclick="execDaumPostcode()">우편번호 검색</button>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label"></label>
						<div class="col-sm-5">
							<input type="text" class="form-control" name="userAddr1"
								id="userAddr1" readonly="readonly">
						</div>
						<div class="col-sm-5">
							<input type="text" class="form-control" name="userAddr2"
								id="userAddr2">
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
								<li><a href="javascript:setEmailAddr('@naver.com')">@naver.com</a></li>
								<li><a href="javascript:setEmailAddr('@hanmail.net')">@hanmail.net</a></li>
							</ul>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">휴대전화번호</label>
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
					<button type="submit" class="btn btn-theme">Sign up</button>
					<button type="submit" class="btn btn-theme">이메일 인증하기</button>
					<button type="submit" class="btn btn-theme">휴대전화 인증하기</button>
				</form>
			</div>
		</div>
	</div>

	<!--main content end-->
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript">
		function idVerify() {
			var id = document.getElementById("userId").value;
			var flag = true;
			var helpMsg = "";
			var patten = /^[a-z0-9]*$/;

			if (!patten.test(id)) {
				document.getElementById("helpId").innerHTML = "ID 는 소문자와 숫자만 사용 할 수 있습니다.";
				return false;
			}

			if (id.length < 6) {
				document.getElementById("helpId").innerHTML = "ID 길이가 짧습니다.";
				return false;
			}

			var xhr = new XMLHttpRequest();

			xhr.onreadystatechange = function() {
				if (xhr.status == 200 && xhr.readyState == 4) {
					document.getElementById("helpId").innerHTML = xhr.responseText;
				}
			}

			xhr.open("GET", "/HaveANiceDream/user/idcheck.do?userId=" + id,
					true);
			xhr.send();

		}

		function setEmailAddr(mail) {
			document.getElementById("userEmail2").value = mail;
		}

		//http://postcode.map.daum.net/guide
		function execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var fullAddr = ''; // 최종 주소 변수
							var extraAddr = ''; // 조합형 주소 변수

							// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
							if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
								fullAddr = data.roadAddress;

							} else { // 사용자가 지번 주소를 선택했을 경우(J)
								fullAddr = data.jibunAddress;
							}

							// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
							if (data.userSelectedType === 'R') {
								//법정동명이 있을 경우 추가한다.
								if (data.bname !== '') {
									extraAddr += data.bname;
								}
								// 건물명이 있을 경우 추가한다.
								if (data.buildingName !== '') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
								fullAddr += (extraAddr !== '' ? ' ('
										+ extraAddr + ')' : '');
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('userZipcode').value = data.zonecode; //5자리 새우편번호 사용
							document.getElementById('userAddr1').value = fullAddr;

							// 커서를 상세주소 필드로 이동한다.
							document.getElementById('userAddr2').focus();
						}
					}).open();
		}
	</script>

</body>
</html>
