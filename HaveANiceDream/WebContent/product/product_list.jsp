<%@page import="java.util.ArrayList"%>
<%@page import="product.ProductDTO"%>
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
	/* 	function setPath(url) {

	 location.href = "/HaveANiceDream/view.html?url=" + url;
	 } */
	function popup() {
		window.open("/HaveANiceDream/Trade/trade_popup.jsp", "a",
				"width=1400, height=800, left=100, top=50")

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


							<li><input type="text" class="form-control" name="word"
								value="물품제목" onclick="this.value='';" maxlength="5"
								style="width: 100%" ;  /></li>
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


				<select id="goods_list" name="goods_list"
					 class="col-lg-2 form-control pull-right mb">
					<option value="25">25개</option>
					<option value="50">50개</option>
					<option value="100">100개</option>
				</select>
				<section id="unseen">
					<table class="table table-bordered table-striped table-condensed">
						<thead>
							<tr class="trade-ing-line pd-con">
								<th>종류</th>
								<th>등급</th>
								<th class="numeric">물품제목</th>
								<th class="numeric">거래금액</th>
								<th class="numeric">등록시간</th>
							</tr>
						</thead>
						<tbody>
							<%
								ArrayList<ProductDTO> productlist = (ArrayList<ProductDTO>) request.getAttribute("productlist");
								int size = productlist.size();

								for (int i = 0; i < size; i++) {
									ProductDTO dto = productlist.get(i);
									//검색간...   해당물품 검색 DB접근해서 서블릿요청
									//이미지 실버 물품이미지넣을거고... 거레상태는 표시할예정
							%>
							<tr>
								<td>아이템</td>
								<td><img
									src="/HaveANiceDream/Theme/assets/img/portfolio/port05.jpg"
									width='100' height='100' alt='실버' /></td>
								<td class="numeric"><a
									href="/HaveANiceDream/product_search.do?productNo=<%=dto.getProductNo()%>">
									 <%=dto.getProductState()%><%=dto.getProductTitle()%></a></td>

								<td class="numeric"><%=dto.getProductPrice()%></td>
								<td class="numeric"><%=dto.getProductDate()%></td>
							</tr>
							<%
								}
							%>

						</tbody>
					</table>
				</section>
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
			<!-- /content-panel -->
		</div>
		<!-- /col-lg-4 -->
	</div>
	<!-- /row -->


</body>
</html>
