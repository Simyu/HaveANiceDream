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
<title>Insert title here</title>
</head>
<body>
	<h3>
		<i class="fa fa-angle-right"></i>신고내역
	</h3>
	<%
		
	%>
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">
			<form action="/HaveANiceDream/manager_blame/insert.do" method="get">
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
										<em class="faq-icon">Q</em> <span class="slideBtn"> xp
											승수부스터가 42개 남앗는데 ip부스터로 교환해주세요 </span>
									</p>
									<div class="inner-view">
										
									</div>
								</div>
							</td>
							<td class="linebg">
								<div class="inner-box02">
									2018-01-23 <br /> 00:05
								</div>
							</td>
							<td class="linebg">
								<div class="inner-box02">답변완료</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="inner-box">
									<div class="inner-view">
										<p class="subject">
											<em class="faq-icon type02">A</em><span class="slideBtn">
												xp 승수부스터가 42개 남앗는데 ip부스터로 교환해주세요 </span>
										</p>
										<textarea name="blameContent" id="mailcontent" rows="60"
											cols="60" title="평가글" maxlength="4000" class="insert-text"
											style="height: 120px;" onfocus="onFocusContent()"></textarea>
									</div>
								</div>
								</div>
								</div>
							</td>
							<td class="linebg02">
								<div class="inner-box02">
									2018-01-23 <br /> 00:08
								</div>
							</td>
							<td class="linebg02">
								<div class="inner-box02"></div>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="request-bottom">
						<div class="btnbox tright">
							<span class="btn-border"><input type="Submit" 
								class="orangebtn" value="답변등록" title="답변등록"
								/></span> <span
								class="btn-border type02"><input type="Submit"
								class="bluebtn" value="취소" title="취소"
								 /></span>
						</div>
					</div>
					</form>
			</div>
			
		</div>
	</div>

</body>
</html>