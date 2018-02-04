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
</head>

<body>

	<!--이미지 넘어가는 버튼 예시-->
				<div class="container mt mb" style="width: 700px;">
					<div id="myCarousel" class="carousel slide" data-ride="carousel" style="width: 100%">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">

							<div class="item active">
								<img src="/HaveANiceDream/Theme/assets/img/kim/mainview.jpg" alt="Los Angeles" style="width: 100%;">
								<div class="carousel-caption">
									<h3>즐거운 나눔의 실천</h3>
									<p>Have a nice dream</p>
								</div>
							</div>

							<div class="item">
								<img src="/HaveANiceDream/Theme/assets/img/kim/event.jpg" alt="Chicago" style="width: 100%;">
								<div class="carousel-caption">
									<h4 style="color: black;">출석?! 그게뭔데? 이벤트!</h4>
								</div>
							</div>

							<div class="item">
								<img src="/HaveANiceDream/Theme/assets/img/kim/event2.jpg" alt="New York" style="width: 100%;">
								<div class="carousel-caption">
									<h4 style="color: black;">너의 그 즐거운 에너지 까지 나눠버린다!!</h4>

								</div>
							</div>
						</div>

						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel"
							data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>
				<!--이미지 넘어가는 벝 END-->
				
				<!--검색창 만들기  start-->
					<form class="form-horizontal style-form" method="post" enctype="multipart/form-data"
					action="/HaveANiceDream/product_list.do?state=MAIN&paging=1'"><!-- 어떻게해야넘어갈까.. 고민해보자 -->
				<div class="row">
					<div class="col-md-3">
					</div>
					<div class="col-md-6 mt">
						<div id="custom-search-input">
							<div class="input-group col-md-12 centered">
								<input type="text" class="form-control input-lg"  name="title" id="title" placeholder="검색할물건" /> <span class="input-group-btn">
									<button class="btn btn-info btn-lg" type="submit">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</span>
							</div>
						</div>
					</div>
				</div>
				</form>
				<!--검색창 만들기 end-->
				
				<!-- 메인 추천 이미지 생성 부분 -->
          	<h3 class="ml"><i class="fa fa-angle-right"></i> 메인추천</h3>
          	<hr>
				<div class="row mt">
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
						<div class="project-wrapper">
		                    <div class="project">
		                        <div class="photo-wrapper photo-wrapper-background-color ml">
		                            <div class="photo">
		                            	<a class="fancybox" href="/HaveANiceDream/Theme/assets/img/portfolio/port04.jpg"><img class="img-responsive" src="/HaveANiceDream/Theme/assets/img/portfolio/port04.jpg" alt=""></a>
		                            	<div class="col-xs-12 mainview-content-title-font">
		                            	저에게 전혀 필요없는 옷들 드림합니다!
		                            	</div>
		                            	<div class="col-xs-12">
		                            		<label class="label label-warning">강력추천</label>
		                            		<label class="label label-primary">new</label>
		                            	</div>
		                            	<div class="col-xs-12">
		                            	상태 : 굉장히 양호
		                            	</div>
		                            	<div class="col-xs-12 mainview-price">
		                            	 2,000 포인트
		                            	</div>
		                            	<div class="col-xs-12">
		                            	 거래방법 : 직거래
		                            	</div>
		                            	<div class="col-xs-12">
		                            	 등록일자 : 2018.01.18
		                            	</div>
		                            	<div class="col-xs-12">
		                            	아이디 : 드림왕
		                            	</div>
		                            </div>
		                           		
		                            <div class="overlay"></div>
		                        </div>
		                    </div>
		                </div>
					</div><!-- col-lg-4 -->
					
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
						<div class="project-wrapper">
		                    <div class="project">
		                        <div class="photo-wrapper">
		                            <div class="photo">
		                            	<a class="fancybox" href="/HaveANiceDream/Theme/assets/img/portfolio/port05.jpg"><img class="img-responsive" src="/HaveANiceDream/Theme/assets/img/portfolio/port05.jpg" alt=""></a>
		                            </div>
		                            <div class="col-xs-12 mainview-content-title-font">
		                            	쓸모없는 애플 드림합니다!!! 하루사용!!
		                            	</div>
		                            	<div class="col-xs-12">
		                            		<label class="label label-warning">강력추천</label>
		                            		<label class="label label-primary">new</label>
		                            	</div>
		                            	<div class="col-xs-12">
		                            	상태 : 굉장히 양호
		                            	</div>
		                            	<div class="col-xs-12 mainview-price">
		                            	 5,000 포인트
		                            	</div>
		                            	<div class="col-xs-12">
		                            	 거래방법 : 직거래
		                            	</div>
		                            	<div class="col-xs-12">
		                            	 등록일자 : 2018.01.18
		                            	</div>
		                            	<div class="col-xs-12">
		                            	아이디 : 드림왕
		                            	</div>
		                            <div class="overlay"></div>
		                        </div>
		                    </div>
		                </div>
					</div><!-- col-lg-4 -->
					
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
						<div class="project-wrapper">
		                    <div class="project">
		                        <div class="photo-wrapper">
		                            <div class="photo">
		                            	<a class="fancybox" href="/HaveANiceDream/Theme/assets/img/portfolio/port06.jpg"><img class="img-responsive" src="/HaveANiceDream/Theme/assets/img/portfolio/port06.jpg" alt=""></a>
		                            </div>
		                            <div class="col-xs-12 mainview-content-title-font">
		                            	보드 드림할테니, 대신 저랑 데이트하실분!
		                            	</div>
		                            	<div class="col-xs-12">
		                            		<label class="label label-warning">강력추천</label>
		                            		<label class="label label-primary">new</label>
		                            	</div>
		                            	<div class="col-xs-12">
		                            	상태 : 굉장히 양호
		                            	</div>
		                            	<div class="col-xs-12 mainview-price">
		                            	 2,000 포인트
		                            	</div>
		                            	<div class="col-xs-12">
		                            	 거래방법 : 직거래
		                            	</div>
		                            	<div class="col-xs-12">
		                            	 등록일자 : 2018.01.18
		                            	</div>
		                            	<div class="col-xs-12">
		                            	아이디 : 드림왕
		                            	</div>
		                            <div class="overlay"></div>
		                        </div>
		                    </div>
		                </div>
					</div><!-- col-lg-4 -->
				</div><!-- /row -->

				<div class="row mt">
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
						<div class="project-wrapper">
		                    <div class="project">
		                        <div class="photo-wrapper">
		                            <div class="photo">
		                            	<a class="fancybox" href="/HaveANiceDream/Theme/assets/img/portfolio/port01.jpg"><img class="img-responsive" src="/HaveANiceDream/Theme/assets/img/portfolio/port01.jpg" alt=""></a>
		                            </div>
		                            	<div class="col-xs-12 mainview-content-title-font">
		                            	영어책 못 읽어서 드림합니다!
		                            	</div>
		                            	<div class="col-xs-12">
		                            		<label class="label label-warning">강력추천</label>
		                            		<label class="label label-primary">new</label>
		                            	</div>
		                            	<div class="col-xs-12">
		                            	상태 : 굉장히 양호
		                            	</div>
		                            	<div class="col-xs-12 mainview-price">
		                            	 2,500 포인트
		                            	</div>
		                            	<div class="col-xs-12">
		                            	 거래방법 : 직거래
		                            	</div>
		                            	<div class="col-xs-12">
		                            	 등록일자 : 2018.01.18
		                            	</div>
		                            	<div class="col-xs-12">
		                            	아이디 : 드림왕
		                            	</div>
		                            <div class="overlay"></div>
		                        </div>
		                    </div>
		                </div>
					</div><!-- col-lg-4 -->
					
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
						<div class="project-wrapper">
		                    <div class="project">
		                        <div class="photo-wrapper">
		                            <div class="photo">
		                            	<a class="fancybox" href="/HaveANiceDream/Theme/assets/img/portfolio/port02.jpg"><img class="img-responsive" src="/HaveANiceDream/Theme/assets/img/portfolio/port02.jpg" alt=""></a>
		                            </div>
		                            <div class="col-xs-12 mainview-content-title-font">
		                            	옆에 사람이랑 같은 이유로 드림합니다.
		                            	</div>
		                            	<div class="col-xs-12">
		                            		<label class="label label-warning">강력추천</label>
		                            		<label class="label label-primary">new</label>
		                            	</div>
		                            	<div class="col-xs-12">
		                            	상태 : 굉장히 양호
		                            	</div>
		                            	<div class="col-xs-12 mainview-price">
		                            	 2,100 포인트
		                            	</div>
		                            	<div class="col-xs-12">
		                            	 거래방법 : 직거래
		                            	</div>
		                            	<div class="col-xs-12">
		                            	 등록일자 : 2018.01.18
		                            	</div>
		                            	<div class="col-xs-12">
		                            	아이디 : 나눔왕
		                            	</div>
		                            <div class="overlay"></div>
		                        </div>
		                    </div>
		                </div>
					</div><!-- col-lg-4 -->
					
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc mb">
						<div class="project-wrapper">
		                    <div class="project">
		                        <div class="photo-wrapper">
		                            <div class="photo">
		                            	<a class="fancybox" href="/HaveANiceDream/Theme/assets/img/portfolio/port03.jpg"><img class="img-responsive" src="/HaveANiceDream/Theme/assets/img/portfolio/port03.jpg" alt=""></a>
		                            </div>
		                            <div class="col-xs-12 mainview-content-title-font">
		                            	저도 같은이유로 드림해요
		                            	</div>
		                            	<div class="col-xs-12">
		                            		<label class="label label-warning">강력추천</label>
		                            		<label class="label label-primary">new</label>
		                            	</div>
		                            	<div class="col-xs-12">
		                            	상태 : 굉장히 양호
		                            	</div>
		                            	<div class="col-xs-12 mainview-price">
		                            	 3,000 포인트
		                            	</div>
		                            	<div class="col-xs-12">
		                            	 거래방법 : 직거래
		                            	</div>
		                            	<div class="col-xs-12">
		                            	 등록일자 : 2018.01.18
		                            	</div>
		                            	<div class="col-xs-12">
		                            	아이디 : 드림왕
		                            	</div>
		                            <div class="overlay"></div>
		                        </div>
		                    </div>
		                </div>
					</div><!-- col-lg-4 -->
				</div><!-- /row -->
</body>
</html>
