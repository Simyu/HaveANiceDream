<%@page import="product.dao.productDAO"%>
<%@page import="product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">


    <title>trade</title>

    <!-- Bootstrap core CSS -->
    <link href="/HaveANiceDream/Theme/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/HaveANiceDream/Theme/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="/HaveANiceDream/Theme/assets/css/style.css" rel="stylesheet">
    <link href="/HaveANiceDream/Theme/assets/css/style-responsive.css" rel="stylesheet">





    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <link rel="stylesheet"  href="/HaveANiceDream/Theme/assets/css/lightslider.css"/>
    <style>
    	ul{
			list-style: none outside none;
		    padding-left: 0;
            margin: 0;
		}
        .demo .item{
            margin-bottom: 60px;
        }
		.content-slider li{
		    background-color: #ed3020;
		    text-align: center;
		    color: #FFF;
		}
		.content-slider h3 {
		    margin: 0;
		    padding: 70px 0;
		}
		.demo{
			width: 800px;
		}
    </style>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="/HaveANiceDream/Theme/assets/js/lightslider.js"></script> 
    <script>
    	 $(document).ready(function() {
			$("#content-slider").lightSlider({
                loop:true,
                keyPress:true
            });
            $('#image-gallery').lightSlider({
                gallery:true,
                item:1,
                thumbItem:9,
                slideMargin: 0,
                speed:500,
                auto:true,
                loop:true,
                onSliderLoad: function() {
                    $('#image-gallery').removeClass('cS-hidden');
                }  
            });
		});
    </script>
    
    
    
    
  </head>

  <body>
        
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
    				  <%
					    ProductDTO product = (ProductDTO)  request.getAttribute("product");
    				    String file1 =(String) request.getAttribute("file1");
    				    String grade="";
    				    if(product.getProduct_Grade().equals("high")){
    				    	grade="상";
    				    	
    				    }else if(product.getProduct_Grade().equals("middle")){
    				    	grade="중";
    				    	
    				    }else if(product.getProduct_Grade().equals("low")){
    				    	grade="하";
    				    	
    				    }
					%>
		<section id="popup-size" >
				<h3>
					<i class="fa fa-angle-right"></i> 거래하기
				</h3>
				<! -- 3RD ROW OF PANELS -->
				<!-- Product Panel -->
				<div class="row" style="margin-top: 30px;" >
					<div class="col-md-4 col-sm-4 col-xs-4 no-pd plus-padding-left">
						 <div class="self-img-full-cont"> <img  src="/HaveANiceDream/upload/<%=file1%>" width='300' height='300'/> </div> 
							<ul id="image-gallery" class="gallery list-unstyled cS-hidden">  
								
								<li data-thumb="/HaveANiceDream/Theme/assets/img/portfolio/port05.jpg"><img
									class="self-img-full-cont" src="/HaveANiceDream/Theme/assets/img/portfolio/port05.jpg" /></li>
								<li data-thumb="/HaveANiceDream/Theme/assets/img/portfolio/port06.jpg"><img
									class="self-img-full-cont" src="/HaveANiceDream/Theme/assets/img/portfolio/port06.jpg" /></li>
							</ul>
					</div>
					<div class="col-md-8 col-sm-8 col-xs-8 no-pd plus-padding-left">
					
						<div class="product-trade-title-font"><%=product.getProductTitle() %></div>
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font" >아이디</div><div class="col-sm-10 product-trade-content-con-font"><%=product.getUserId() %></div>
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font" >물품이름</div><div class="col-sm-10 product-trade-content-con-font"><%=product.getProductName() %></div>
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font" >필요 드림포인트</div><div class="col-sm-10 product-trade-content-con-font" ><label class="pt-font"><%=product.getProductPrice() %></label>포인트</div>
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font">거래방법</div><div class="col-sm-10 product-trade-content-con-font" ><%=product.getTradeType() %></div>					
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font">지역</div><div class="col-sm-10 product-trade-content-con-font" >서울(차후에 구현예정)</div>
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font">물품상태</div><div class="col-sm-10 product-trade-content-con-font" ><%=grade %></div>
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font">사용기간</div><div class="col-sm-10 product-trade-content-con-font" >5개월(차후에 구현예정))</div>
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font">등록일자</div><div class="col-sm-10 product-trade-content-con-font" ><%=product.getProductDate() %></div>
						<div class="col-md-2 col-sm-2 col-xs-2 next-line-hr">
						
						</div>
					</div>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12 " style="border: 2px solid black;">
					<h5><i class="fa fa-angle-right"></i> 상세내용 </h5>
						<div class="col-md-12 col-sm-12 col-xs-12 product-trade-content-title-font trade-popup-content" >
						<%=product.getProductContent() %>
						</div>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12 trade-popup-btn">
					<button class="btn btn-default btn-lg btn-style-line mr">거래신청</button>
					<button class="btn btn-default btn-lg btn-style-line mr ml">1:1채팅</button>
				</div>
		</section>
		<!-- /MAIN CONTENT -->

		<!--main content end-->
 
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="/HaveANiceDream/Theme/assets/js/bootstrap.min.js"></script>
</body>
</html>