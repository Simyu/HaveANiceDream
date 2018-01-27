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

<link href="/HaveANiceDream/Theme/assets/js/fancybox/jquery.fancybox.css" rel="stylesheet" />
<!-- Custom styles for this template -->

<script src="/HaveANiceDream/Theme/assets/js/jquery.js"></script>


<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script type="text/javascript">
	function setPath(url) {

		location.href = "/HaveANiceDream/view.html?url=" + url;
	}
</script>
</head>

<body>


	<div class="col-md-12">
		<h4>
			<i class="fa fa-angle-right"></i> 게시판 목록
		</h4>
		<hr>
		<div class="content-panel">
			<div class="form-group">
				<form name="form1" method="post" action="${path}/board/list.do">
					<div class="col-sm-2">
						<select class="form-control">
							<option value="all">제목+작성자</option>
							<option value="writer">작성자</option>
							<option value="title">제목</option>
						</select>
					</div>
					<div class="col-sm-3">
						<input type="text" class="form-control">
					</div>
					<div class="col-sm-6">
						<button type="submit" class="btn btn-default">조회</button>
					</div>
				</form>
			</div>
			<div class="form-group">
				<h5 class="col-sm-12">0개의 게시물이 있습니다.</h5>
			</div>

			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td><a href="javascript:setPath('../board/board_list_Read.jsp')">a테그를 붙여서 넘겨보장!</a></td>
						<td>김동혁</td>
						<td>2018.01.14</td>
						<td>50</td>
					</tr>
					<tr>
						<td>2</td>
						<td>해보자</td>
						<td>관리자</td>
						<td>2018.01.14</td>
						<td>20</td>
					</tr>
					<tr>
						<td>4</td>
						<td>해보자</td>
						<td>관리자</td>
						<td>2018.01.14</td>
						<td>20</td>
					</tr>
					<tr>
						<td>5</td>
						<td>해보자</td>
						<td>관리자</td>
						<td>2018.01.14</td>
						<td>20</td>
					</tr>
				</tbody>
			</table>
			<hr />
			<a class="btn btn-default pull-right" href="javascript:setPath('../board/board_write.jsp')"><i
				class=" fa fa-edit"></i>글쓰기</a>
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


	<script type="text/javascript">
		//custom select box

		$(function() {
			$("select.styled").customSelect();
		});
	</script>

</body>
</html>
