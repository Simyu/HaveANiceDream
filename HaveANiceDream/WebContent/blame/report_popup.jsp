<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">



<link href="/HaveANiceDream/Theme/assets/css/bootstrap.css"
	rel="stylesheet">

<link
	href="/HaveANiceDream/Theme/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet" />

<link href="/HaveANiceDream/Theme/assets/css/style.css" rel="stylesheet">
<link href="/HaveANiceDream/Theme/assets/css/style-responsive.css"
	rel="stylesheet">
</head>
<body>
	<h3>
		<i class="fa fa-angle-right"></i>신고하기
	</h3>
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">
				<a href="../view/report.html"></a>
				<form>
					<table summary="신고정보" height="600" border="1">
						<colgroup>
							<col style="width: 14%;">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th>신고</th>
								<td>신고분류 <select>
										<option selected="selected" value="NONE">선택해주세요</option>
										<option value="M01">사기글신고</option>
										<option value="M02">허위신고</option>
										<option value="M03">지나친폭언신고</option>
										<option value="M04">광고성글신고</option>
								</select>
								</td>
							</tr>

							<tr>
								<th>상세정보</th>
								<td>
									<dl>
										<dt>
											<label>신고자ID</label> <span class="input-box"><input
												name="userIdBlamere" type="text" id="auctionno2" class="txt"
												maxlength="15" style="width: 133px;" /></span> <label>상대방ID</label>
											<span class="input-box"><input name="userIdBlamee"
												type="text" id="auctionno2" class="txt" maxlength="15"
												style="width: 133px;" /></span> <label>물건번호</label> <span
												class="input-box"><input name="productNo" type="text"
												id="orderno1" class="txt" maxlength="15"
												style="width: 133px;" /></span> <input type="button"
												value="물건번호조회" onclick="popup()">
										</dt>
									</dl>

								</td>
							</tr>
							<tr>
								<th>첨부파일</th>
								<td class="tleft">
									<ul class="inputfile">
										<li>
											<div class="fileinput">
												<div class="btnbox">
													<input type="file" class="f-map" title="파일첨부"
														style="width: 400px;" name="attachedFile" />
												</div>

											</div>
										</li>
									</ul>
								</td>
							</tr>
							<tr>
								<th><label for="inquirySubject">제목</label></th>
								<td><span class="input-box"><input name="blameTitle"
										type="text" id="mailtitle" class="txt" title="제목"
										style="width: 440px;" /> <input name="Mcategorybox"
										type="text" value="M0401" id="Mcategorybox"
										style="border-style: None; width: 0px; DISPLAY: none" /> <input
										name="CCodeBox" type="text" id="CCodeBox"
										style="border-style: None; width: 0px; DISPLAY: none" /> </span></td>
							</tr>
							<tr>
								<th>내용</th>
								<td>
									<div>
										<div>
											<textarea name="blameContent" id="mailcontent" rows="100"
												cols="100" title="평가글" maxlength="4000" class="insert-text"
												style="height: 102px;" onfocus="onFocusContent()"></textarea>
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="request-bottom">
						<div class="btnbox tright">
							<span class="btn-border"><input type="button"
								class="orangebtn" value="신고하기" title="신고하기"
								onclick="javascript:nReg(); void(0);" /></span> <span
								class="btn-border type02"><input type="button"
								class="bluebtn" value="취소" title="취소"
								onclick="javascript:document.location.reload(); void(0);" /></span>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>