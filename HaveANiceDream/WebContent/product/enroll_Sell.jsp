<%@page import="java.util.ArrayList"%>
<%@page import="category.*"%>
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
<script type="text/javascript">
     $(document).ready(function(){
    	$("#categoryDetailNameSearch").on("keyup",function(){
    		
    		var name = $(this).val();//.val() 텍스트상자의 값을 읽어올떄 사용하는 메소드
    		//alert(name);
    		$.ajax({
    			url:"/HaveANiceDream//category/readAjax.do",
				type:"get",
				data:{"categoryName":name},
				dataType:"json",
				success:function(data){//jquery로 ajax요청하면 json파싱되어 리턴
					//alert(data.categoryDetailName[0]);//jquery 객체추가
					str= "<option>"+categoryDetailName[0];
					$("#categoryDetailName").append(data.categoryDetailName[0]);
					
					    //for(i=0 ;i<data.length;i++){ 
					    
					    	//data = "<option>"+data[i].categoryDetailName; 
					    /* 	testnode = document.createTextNode(data);
					    	destNode = document.getElementById("categoryDetailName");
					    	destNode.appendChild(testnode); */
							// $("#categoryDetailName").html(data);//id명 data의i번째 이름..
					    //}
					                           
				}
    		})
    		
    		
    	});
    	 
     });
</script>

<title>DASHGUM - Bootstrap Admin Template</title>

<link rel="stylesheet" type="text/css"
	href="/HaveANiceDream/Theme/assets/js/bootstrap-datepicker/css/datepicker.css" />
<link rel="stylesheet" type="text/css"
	href="/HaveANiceDream/Theme/assets/js/bootstrap-daterangepicker/daterangepicker.css" />

</head>

<body>

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
				<form class="form-horizontal style-form" method="post" enctype="multipart/form-data"
					action="/HaveANiceDream/product_enroll.do">
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">카테고리</label>
						<div class="col-sm-10">
							<div class="col-sm-5">

								<input type="text"  id="categoryNo" name="categoryNo"class="form-control" value="1">
								<br /> <select multiple class="form-control"
									name="categoryName" id="categoryName" size="8"
									style="width: 100%">
								  <%
							  ArrayList<CategoryDTO> category_list =(ArrayList<CategoryDTO>) request.getAttribute("category_list");
								   
								 if(category_list.size()!=0){
								  for(int i =0;i<category_list.size();i++){
								 %>
								     <% CategoryDTO dto = category_list.get(i) ;%>
								     
									<option><%=dto.getCategoryName()%>
									<%}} %> 
								</select>
							</div>
							<div class="col-sm-5">

								<input type="text" class="form-control" id="categoryDetailNameSearch" name="categoryDetailNameSearch"
									value="1"> <br /> <select multiple
									class="form-control" name="categoryDetailName"
									id="categoryDetailName" size="8" style="width: 100%">
<!-- 
									<option value="1">유모차
									<option value="2">유아용옷
									<option value="3">장난감
									<option value="4">신발 -->
								</select>
							</div>


						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">판매금액</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="productPrice" name="productPrice"> <span
								class="help-block" " >A block of help text that breaks onto
								a new line and may extend beyond one line.</span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">상품명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="productName" name="productName"> <label>반드시
								실명을 작성해 주시기 바랍니다.</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">거래방식</label>
						<div class="col-sm-10">
								   <input type="radio" name="tradeType" value="trade">직거래
	   							   <input type="radio" name="tradeType" value="delivery_trade">택배거래
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">물품상태</label>
						<div class="col-sm-10">
								   <input type="radio" name="productGrade" value="high">상
	   							   <input type="radio" name="productGrade" value="middle">중
	   							   <input type="radio" name="productGrade" value="low">하
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">물품제목</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="productTitle" name="productTitle"
								value="This is focused...">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">상세설명</label>
						<div class="col-sm-10">
							<textarea rows="10" cols="100%" id="productContent" name="productContent"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">업로드</label>
						<div class="col-sm-10">
							<div >
								<!--  <input class="upload-name" value="파일선택" readonly="readonly"
									style="width: 200px;">  <label for="input_file">파일찾기</label>
								<input type="file" id="input_file"> -->
								<input type="file" name="uploadFile1" /><br/> 
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
								<p class="form-control-static" id="userId" name="userId" >로그인된상태이니까 아이디를 통해 이름을 받아 올
									예정입니다.</p>
							</div>

						</div>



						<div class="col-sm-6">
							<label class="col-sm-2 col-sm-2 control-label">연락처</label>

							<div class="col-sm-4">
								<p class="form-control-static">010-4442-4421</p>
							</div>
						</div>
					</div>



					<div class="form-group" align="center">
						<button type="submit" class="btn btn-round btn-default">등록하기</button>

						<button type="reset" class="btn btn-round btn-default">취소하기</button>
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
