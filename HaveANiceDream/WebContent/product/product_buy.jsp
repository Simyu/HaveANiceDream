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

<link rel="stylesheet" type="text/css"
	href="/HaveANiceDream/Theme/assets/js/bootstrap-datepicker/css/datepicker.css" />
<link rel="stylesheet" type="text/css"
	href="/HaveANiceDream/Theme/assets/js/bootstrap-daterangepicker/daterangepicker.css" />

</head>

<body>
     <%
     ProductDTO product = (ProductDTO)request.getAttribute("product");
     String file1 =(String) request.getAttribute("file1");
     
     
     %>
	<h3>
		<i class="fa fa-angle-right"></i> 물품등록
	</h3>

	<!-- BASIC FORM ELELEMNTS -->
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">
				<h4 class="mb">
					<i class="fa fa-angle-right"></i> 판매 등록
				</h4>
				<form class="form-horizontal style-form" method="post"
					action="/HaveANiceDream/product_enroll.do">
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">카테고리</label>
						<div class="col-sm-10">
							<div class="col-sm-5">

								<input type="text" class="form-control" value="글씨를쓰면 DB검색을 통해 " name="categoryName" id="categoryName" readonly="readonly">
								<br /> 
							</div>
							<div class="col-sm-5">

								<input type="text" class="form-control"
									value="  list를 받아 올예정입니다" readonly="readonly" name="categoryDetailName" id="categoryDetailName"> <br />
							</div>


						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">판매금액</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="productPrice" name="productPrice"   readonly="readonly"
							
							value="<%=product.getProductPrice()%>" > 
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">상품명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="productName" name="productName"   readonly="readonly" 
							value="<%=product.getProductName()%>" > 
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">거래방식</label>
						<div class="col-sm-10" > <!--  if로 처리... -->
								   <input type="radio" name="tradeType" value="trade"   readonly="readonly" <%if(product.getTradeType().equals("trade")){%>checked="checked" <%} %> >직거래
	   							   <input type="radio" name="tradeType" value="delivery_trade" <%if(product.getTradeType().equals("delivery_trade")){%>checked="checked" <%} %> readonly="readonly"
	   							    >택배거래
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">물품상태</label>
						<div class="col-sm-10" >
								   <input type="radio" name="productGrade" value="high" readonly="readonly" <%if(product.product_Grade().equals("high")){%>checked="checked" <%} %>>상
	   							   <input type="radio" name="productGrade" value="middle" readonly="readonly"  <%if(product.product_Grade().equals("middle")){%>checked="checked" <%} %>>중
	   							   <input type="radio" name="productGrade" value="low" readonly="readonly"  <%if(product.product_Grade().equals("low")){%>checked="checked" <%} %>>하
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">물품제목</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="productTitle" name="productTitle" readonly="readonly"
								value= <%=product.getProductTitle()%> maxlength="50">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">상세설명</label>
						<div class="col-sm-10">
						<img src="/HaveANiceDream/upload/<%=file1%>"/> 
							<textarea rows="10" cols="100%" id="productContent" name="productContent" readonly="readonly">
						 
						 <%=product.getProductContent() %>
							</textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">업로드</label>
						<div class="col-sm-10">
							<div class="filebox bs3-primary preview-image">
								<input class="upload-name" value="파일선택" disabled="disabled"
									style="width: 200px;"> <label for="input_file">파일찾기</label>
								<input type="file" id="input_file" class="upload-hidden">
								<textarea rows="3" cols="100%"></textarea>
								<button type="button" class="btn btn-default">+추가</button>
								<button type="button" class="btn btn-default">-삭제</button>
							</div>
						</div>
					</div>
					<!-- <div class="form-group">
								
									 <label class="col-sm-2 col-sm-2 control-label">스크린샷</label>
									<div class="col-sm-5">
										<input class="upload-name" value="파일선택" disabled="disabled"
											style="width: 200px;"> <label for="input_file">파일찾기</label>
										<input type="file" id="input_file" class="upload-hidden">
										<textarea rows="10" cols="100%"></textarea>
									</div>
									<div class="col-sm-5">
										<button type="button" class="btn btn-default mb">추가</button>
										<button type="button" class="btn btn-default mb">삭제</button>
										<label class="mb">용량 500KB이하 jpg, gif만 가능(최대 5개)</label>

									</div> 
								</div> -->

					<div class="form-group">
						<div class="col-sm-6">
							<label class="col-sm-2 col-sm-2 control-label">이름</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="userId" name="userId"   readonly="readonly" >
								
							</div>

						</div>



						<div class="col-sm-6">
							<label class="col-sm-2 col-sm-2 control-label">연락처</label>

							<div class="col-sm-4">
							<input type="text" class="form-control" id="userId" name="userId"   readonly="readonly">
							</div>
						</div>
					</div>



					<div class="form-group" align="center">
						<button type="submit" class="btn btn-round btn-default">수정하기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- col-lg-12-->



	<!--script for this page-->
	<script
		src="/HaveANiceDream/Theme/assets/js/jquery-ui-1.9.2.custom.min.js"></script>

	<!--custom switch-->
	<script src="/HaveANiceDream/Theme/assets/js/bootstrap-switch.js"></script>

	<!--custom tagsinput-->
	<script src="/HaveANiceDream/Theme/assets/js/jquery.tagsinput.js"></script>

	<!--custom checkbox & radio-->

	<script type="text/javascript"
		src="/HaveANiceDream/Theme/assets/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript"
		src="/HaveANiceDream/Theme/assets/js/bootstrap-daterangepicker/date.js"></script>
	<script type="text/javascript"
		src="/HaveANiceDream/Theme/assets/js/bootstrap-daterangepicker/daterangepicker.js"></script>

	<script type="text/javascript"
		src="/HaveANiceDream/Theme/assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>


	<script src="/HaveANiceDream/Theme/assets/js/form-component.js"></script>


</body>
</html>
