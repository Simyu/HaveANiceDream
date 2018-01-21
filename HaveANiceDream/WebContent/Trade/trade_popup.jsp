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
		<section id="popup-size" >
				<h3>
					<i class="fa fa-angle-right"></i> 거래하기
				</h3>
				<! -- 3RD ROW OF PANELS -->
				<!-- Product Panel -->
				<div class="row" style="margin-top: 30px;" >
					<div class="col-lg-4 no-pd plus-padding-left">
							<ul id="image-gallery" class="gallery list-unstyled cS-hidden">
								<li data-thumb="/HaveANiceDream/Theme/assets/img/portfolio/port04.jpg"><img
									class="self-img-full-cont" src="/HaveANiceDream/Theme/assets/img/portfolio/port04.jpg" /></li>
								<li data-thumb="/HaveANiceDream/Theme/assets/img/portfolio/port05.jpg"><img
									class="self-img-full-cont" src="/HaveANiceDream/Theme/assets/img/portfolio/port05.jpg" /></li>
								<li data-thumb="/HaveANiceDream/Theme/assets/img/portfolio/port06.jpg"><img
									class="self-img-full-cont" src="/HaveANiceDream/Theme/assets/img/portfolio/port06.jpg" /></li>
							</ul>
					</div>
					<div class="col-sm-8 no-pd plus-padding-left">
						<div class="product-trade-title-font">내가 쓰다만 여러가지 각종 잡템을 드림해요!</div>
						<div class="col-sm-2 product-trade-content-title-font" >아이디</div><div class="col-sm-10 product-trade-content-con-font">드림왕</div>
						<div class="col-sm-2 product-trade-content-title-font" >물품이름</div><div class="col-sm-10 product-trade-content-con-font">구찌가방</div>
						<div class="col-sm-2 product-trade-content-title-font" >필요 드림포인트</div><div class="col-sm-10 product-trade-content-con-font" ><label class="pt-font">3,000</label>포인트</div>
						<div class="col-sm-2 product-trade-content-title-font">거래방법</div><div class="col-sm-10 product-trade-content-con-font" >직거래</div>					
						<div class="col-sm-2 product-trade-content-title-font">지역</div><div class="col-sm-10 product-trade-content-con-font" >서울</div>
						<div class="col-sm-2 product-trade-content-title-font">물품상태</div><div class="col-sm-10 product-trade-content-con-font" >양호</div>
						<div class="col-sm-2 product-trade-content-title-font">사용기간</div><div class="col-sm-10 product-trade-content-con-font" >5개월</div>
						<div class="col-sm-2 product-trade-content-title-font">등록일자</div><div class="col-sm-10 product-trade-content-con-font" >2018-01-02</div>
						<div class="col-sm-12 next-line-hr">
						
						</div>
					</div>
				</div>
				<div class="col-lg-12 " style="border: 2px solid black;">
					<h5><i class="fa fa-angle-right"></i> 상세내용 </h5>
						<div class="col-sm-12 product-trade-content-title-font trade-popup-content" >
							여기는 내용이 들어갈 공간입니다. 어떤 내용이 들어가도 줄바꿈이 가능하며 걱정없습니다. 
							계속해서 쭉쭉쭉 써주세요 그리고 신고기능을 추가할 겁니다. 어떻게 해야할까요? 내용안에 넣어야 겠지요? 
							그럼 신고기능 연결을 위해 우리 진우와 또 의논을 해봐야 겠네요? 자 어때요 css 및 뷰작업은 이제 껌때가리죠? 
							ㅎㅎㅎㅎㅎ 어떤내용을 넣을지 막막할 때는 무조건 구글링 & 밤샘 작업을 한다면 문제 없지요 자 그럼 우리 다함께 드림 하시다 드림드림드림 드림 드림~~
							
						</div>
				</div>
				<div class="col-lg-12 trade-popup-btn">
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