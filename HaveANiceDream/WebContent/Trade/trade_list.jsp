<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<script>
	$.datepicker.setDefaults({
		dateFormat : 'yy-mm-dd',
		prevText : '이전 달',
		nextText : '다음 달',
		monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월',
				'10월', '11월', '12월' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
				'9월', '10월', '11월', '12월' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		showMonthAfterYear : true,
		yearSuffix : '년'
	});

	$(function() {
		$("#datepicker1, #datepicker2").datepicker();
	});
</script>

<!-- 추가한 부분 입니다                                                             -->

<script type="text/javascript">
	function setPath(url) {

		location.href = "/HaveANiceDream/view.html?url=" + url;
	}
	function popup(){
   		window.open("/HaveANiceDream/Trade/trade_ing-detail.jsp", "button", "width=1200, height=800, left=100, top=50")
   		
   	}
</script>
</head>

<body>
	<div class="col-md-12" style="background-color: #ffffff">
		<h4>
			<i class="fa fa-angle-right"></i> 거래 | <span
				style="color: black; font-weight: 900; font-size: 16pt;">드림
				내역 확인</span>
		</h4>
		<hr>
		<div class="col-lg-1 trade-lookup-con"
			style="border-right: none; text-align: right;">기간별조회</div>
		<div class="col-lg-2 trade-lookup-con no-mg-no-pd"
			style="border-left: none; border-right: none;">
			<div class="btn-group">
				<button type="button"
					class="btn btn-default btn-sm btn-pointer-height">1개월</button>
				<button type="button"
					class="btn btn-default btn-sm btn-pointer-height">2개월</button>
				<button type="button"
					class="btn btn-default btn-sm btn-pointer-height">6개월</button>
			</div>
		</div>
		<div class="col-lg-6 no-mg-no-pd" style="text-align: left;">
			<div class="col-lg-3 trade-lookup-con2">
				<form class="demo-3">
					<input type="text" id="datepicker1"
						class="form-control text-height-con"> <i
						class="fa fa-calendar"></i>
				</form>
			</div>
			<div class="col-lg-1 trade-lookup-con2 centered">~</div>
			<div class="col-lg-3 trade-lookup-con2">
				<form class="demo-3">
					<input type="text" id="datepicker2"
						class="form-control text-height-con"> <i
						class="fa fa-calendar"></i>
				</form>
			</div>
			<div class="col-lg-2 trade-lookup-con2">
				<button class="btn btn-default btn-sm" style="padding-top: 0">조회하기
					▶</button>
			</div>
			<div class="col-lg-3 trade-lookup-con2"></div>
		</div>
		<div class="col-lg-3 trade-lookup-con no-mg-no-pd"
			style="border-left: none;"></div>
		<div class="content-panel">
			<div class="col-lg-12 trade-ing-line pd-con">
				<div class="col-lg-1">거래 날짜</div>
				<div class="col-lg-7">드림 정보</div>
				<div class="col-lg-2">상태</div>
				<div class="col-lg-2">취소 및 신고</div>
			</div>
			<div class="col-lg-12 pd-con" style="border-bottom: 1px solid black;">
				<div class="col-lg-1 trade-ing-date height-sort">
					<p>2018-01-21</p>
					<div class="col-lg-12">
						<button class="label label-default trade-btn-height" onclick="popup()">거래상세보기</button>
					</div>
				</div>
				<div class="col-lg-7">
					<div class="col-lg-2">
						<img class="self-img-full-cont2"
							src="/HaveANiceDream/Theme/assets/img/portfolio/port05.jpg">
					</div>
					<div class="col-lg-10">
						<div class="col-lg-12">
							<ul class="no-mg-no-pd">
								<li id="header_inbox_bar" class="dropdown"><i
									class="fa fa-user mr" style="color: #1f85e2"></i><a
									data-toggle="dropdown" href="index.html#">드림왕</a>
								<button class="label label-default trade-btn-height2">문의하기</button>
									<ul class="dropdown-menu dropdown-kk inbox">
										<li><a href="index.html#">프로필 보기</a></li>
										<li><a href="index.html#">쪽지</a></li>
										<li><a href="index.html#">1:1채팅</a></li>
										<li><a href="index.html#">평가보기</a></li>
									</ul></li>
							</ul>
						</div>
						<div class="col-lg-12">
							글제목 : <a>내가 쓰다만 여러가지 각종 잡템을 드림해요!</a>
						</div>
						<div class="col-lg-12">거래번호: 20212154</div>
						<div class="col-lg-12">
							거래 포인트 : <label class="text-price-point-state">3000</label> 포인트
						</div>
					</div>
				</div>
				<div class="col-lg-2 centered height-sort">
					<div class="col-lg-12">
						<label class="text-price-point-state" style="margin-bottom: 10px;">거래
							진행 중 </label>
					</div>
					<div class="col-lg-12">
						<button type="button" class="btn btn-success btn-sm">인수확인</button>
					</div>
				</div>
				<div class="col-lg-2 centered height-sort">
					<div class="col-lg-12">
						<button type="button" class="btn btn-warning btn-sm"
							style="margin-bottom: 10px;">취소</button>
					</div>
					<div class="col-lg-12">
						<button type="button" class="btn btn-danger btn-sm">신고</button>
					</div>
				</div>
			</div>
			<div class="col-lg-12 pd-con" style="border-bottom: 1px solid black;">
				<div class="col-lg-1 trade-ing-date height-sort">
					<p>2018-01-21</p>
					<div class="col-lg-12">
						<button class="label label-default trade-btn-height" onclick="popup()">거래상세보기</button>
					</div>
				</div>
				<div class="col-lg-7">
					<div class="col-lg-2">
						<img class="self-img-full-cont2"
							src="/HaveANiceDream/Theme/assets/img/portfolio/port06.jpg">
					</div>
					<div class="col-lg-10">
						<div class="col-lg-12">
							<i class="fa fa-user mr" style="color: #1f85e2"></i><a>드림왕</a>
							<button class="label label-default trade-btn-height2">문의하기</button>
						</div>
						<div class="col-lg-12">
							글제목 : <a>내가 쓰다만 여러가지 각종 잡템을 드림해요!</a>
						</div>
						<div class="col-lg-12">거래번호: 20212154</div>
						<div class="col-lg-12">
							거래 포인트 : <label class="text-price-point-state">3000</label> 포인트
						</div>
					</div>
				</div>
				<div class="col-lg-2 centered height-sort">
					<div class="col-lg-12">
						<label class="text-price-point-state" style="margin-bottom: 10px;">거래
							완료</label>
					</div>
				</div>
				<div class="col-lg-2 centered height-sort"></div>
			</div>
			<div class="col-lg-12 pd-con" style="border-bottom: 1px solid black;">
				<div class="col-lg-1 trade-ing-date height-sort">
					<p>2018-01-21</p>
					<div class="col-lg-12">
						<button class="label label-default trade-btn-height">거래상세보기</button>
					</div>
				</div>
				<div class="col-lg-7">
					<div class="col-lg-2">
						<img class="self-img-full-cont2"
							src="/HaveANiceDream/Theme/assets/img/portfolio/port04.jpg">
					</div>
					<div class="col-lg-10">
						<div class="col-lg-12">
							<i class="fa fa-user mr" style="color: #1f85e2"></i><a>드림왕</a>
							<button class="label label-default trade-btn-height2">문의하기</button>
						</div>
						<div class="col-lg-12">
							글제목 : <a>내가 쓰다만 여러가지 각종 잡템을 드림해요!</a>
						</div>
						<div class="col-lg-12">거래번호: 20212154</div>
						<div class="col-lg-12">
							거래 포인트 : <label class="text-price-point-state">3000</label> 포인트
						</div>
					</div>
				</div>
				<div class="col-lg-2 centered height-sort">
					<div class="col-lg-12">
						<label class="text-price-point-state" style="margin-bottom: 10px;">거래
							진행 중 </label>
					</div>
					<div class="col-lg-12">
						<button type="button" class="btn btn-primary btn-sm">인계확인</button>
					</div>
				</div>
				<div class="col-lg-2 centered height-sort">
					<div class="col-lg-12">
						<button type="button" class="btn btn-warning btn-sm"
							style="margin-bottom: 10px;">취소</button>
					</div>
					<div class="col-lg-12">
						<button type="button" class="btn btn-danger btn-sm">신고</button>
					</div>
				</div>
			</div>
			<div class="text-center">
				<ul class="pagination">
					<li class="previous"><a href="#">이전</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li class="next"><a href="#">다음</a></li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>
