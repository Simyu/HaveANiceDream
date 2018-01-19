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

<script type="text/javascript">
	function setPath(url) {

		location.href = "/HaveANiceDream/view.html?url=" + url;
	}
</script>
</head>

<body>

	<h3>
		<i class="fa fa-angle-right"></i> 나눔공간
	</h3>
	<div class="row mt">
		<div class="col-lg-12">



			<div class="content-panel">
				<h4>
					<i class="fa fa-angle-right"></i>물품리스트
				</h4>
				<div class="col-lg-12">

					<div class="col-lg-4">
						<select class="form-control" name="search_game_text"
							id="search_game_text" style="width: 100%;">
							<option value="java">유아용품
							<option value="하둡">핸드폰
							<option value="스프링">기타
							<option value="mean">MEAN
							<option value="spark">SPARK
						</select>
					</div>

					<div class="col-lg-3">
						<select class="form-control" name="search_server_text"
							id="search_server_text" style="width: 100%;" length="10">
							<option value="java">유모차
							<option value="하둡">유아용옷
							<option value="스프링">장난감
							<option value="mean">신발
						</select>
					</div>
					<div class="col-lg-3">
						<ul>


							<li><input type="text" class="form-control"  name="word"
								value="물품제목" onclick="this.value='';" maxlength="5"
								style="width:100%";  /></li>
						</ul>
					</div>
					<div class="col-lg-2">
						<ul>
							<li><input type="image" name="btnSearch"
								src="http://img2.itemmania.com/images/btn/btn_blue_search.gif"
								class="g_image" style="width: auto;" /></li>
						</ul>
					</div>
				</div>


				<select id="goods_list" name="goods_list"   class="form-control pull-right mb">
					<option value="25">25개</option>
					<option value="50">50개</option>
					<option value="100">100개</option>
				</select>
				<section id="unseen">
					<table class="table table-bordered table-striped table-condensed">
						<thead>
							<tr>
								<th>종류</th>
								<th>등급</th>
								<th class="numeric">물품제목</th>
								<th class="numeric">거래금액</th>
								<th class="numeric">등록시간</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>아이템</td>
								<td><img
									src='http://img1.itemmania.com/images/icon/icon_silver_s.gif'
									width='21' height='19' alt='실버' /></td>
								<td class="numeric"><a
									href="javascript:setPath('../product/product_view_edit.jsp')"
									onclick="$.fnViewId('2018011403747952')" class="">유모차 나눔합니다</a></td>
								<td class="numeric">24,000원</td>
								<td class="numeric">11:08</td>
							</tr>
							<tr>
								<td>거래종료</td>
								<td><img
									src='http://img1.itemmania.com/images/icon/icon_silver_s.gif'
									width='21' height='19' alt='실버' /></td>
								<td class="numeric"><a
									href="javascript:setPath('../product/product_view_buy.jsp')"
									onclick="$.fnViewId('2018011403747952')" class="">유모차
										나눔합니다.</a>
								<td class="numeric">11,000원</td>
								<td class="numeric">10:56</td>
							</tr>
						</tbody>
					</table>
				</section>


			</div>
			<!-- /content-panel -->
		</div>
		<!-- /col-lg-4 -->
	</div>
	<!-- /row -->


</body>
</html>
