<%@page import="user.dto.MemberDTO"%>
<%@page import="category.CategoryDTO"%>
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
$(document).ready(function(){
	$("#categoryName").on("click",function(){
		var name = $(this).val();//.val() 텍스트상자의 값을 읽어올떄 사용하는 메소드

		$.ajax({
			url:"/HaveANiceDream/category/readAjax.do?state=SEARCH",
			type:"get",
			data:{"categoryNo":name},
			dataType:"json",
			success:function(data){//jquery로 ajax요청하면 json파싱되어 리턴
				$("#categoryDetailName").empty();
				for(i=0 ;i<data.category_detail.length;i++){ 
					var str="<option>"+data.category_detail[i].categoryDetailName+"</option>";
					 categorydetailname=$(str);
					 categorydetailname.attr("value",data.category_detail[i].categoryDetailNo);
					 categorydetailname.attr("name",data.category_detail[i].categoryDetailName);
 
					$("#categoryDetailName").append(categorydetailname);
				}                           
			}
		})
		
		
	});
	 
});

	/* 	function setPath(url) {

	 location.href = "/HaveANiceDream/view.html?url=" + url;
	 } */
	function popup() {
		window.open("/HaveANiceDream/Trade/trade_popup.jsp", "a", "width=1400, height=800, left=100, top=50")

	}
</script>
</head>

<body>
<%
		MemberDTO user = (MemberDTO) session.getAttribute("user");
	//System.out.println(user);
	%>
	<h3>
		<i class="fa fa-angle-right"></i> 나눔공간
	</h3>
	<div class="row mt">
		<div class="col-lg-12">



			<div class="content-panel">
				<h4>
					<i class="fa fa-angle-right"></i>물품리스트
				</h4>
				<form  class="form-horizontal style-form" method="post" 
					action="/HaveANiceDream/product_list.do?state=SEARCH">
				<div class="col-lg-12">

					<div class="col-lg-4">
						<select  class="form-control"
									name="categoryName" id=categoryName  
									style="width: 100%">
						<option >선택해주세요
						 <%
							  ArrayList<CategoryDTO> category_list =(ArrayList<CategoryDTO>) request.getAttribute("category_list");
								   
								 if(category_list!=null){
								  for(int i =0;i<category_list.size();i++){
								%>
								     <% CategoryDTO dto = category_list.get(i) ;%>
								     
									<option value="<%=dto.getCategoryNo()%>"><%=dto.getCategoryName()%>
									<%}} %> 
						</select>
					</div>

					<div class="col-lg-3"> <select 
									class="form-control" name="categoryDetailName"
									id="categoryDetailName"  style="width: 100%" >
							<option >선택해주세요

						</select>
					</div>
					<div class="col-lg-3">
						<ul>


							<li><input type="text" class="form-control" name="title" id="title"
								value=""  
								style="width: 100%"/></li>
						</ul>
					</div>
					<div class="col-lg-2">
						<ul>
							<!-- <li><input type="image" name="btnSearch" value="검색"
								src="/HaveANiceDream/product_list.do?state=SEARCH"
								class="g_image" style="width: auto;" /></li> -->
								<li><button type="submit" class="btn btn-default">검색</button></li>
						</ul>
					</div>
				</div>
				</form>
				<div class="col-lg-10">
				</div>
				<div class="col-lg-2">
					<select id="goods_list" name="goods_list"
						 class=" form-control pull-right mb">
						<option value="10">10개</option>
						<option value="15">15개</option>
						<option value="20">20개</option>
					</select>
				</div>
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
								<td class="numeric">
								<a	href="/HaveANiceDream/product_search.do?productNo=<%=dto.getProductNo()%>" >
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
