
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

	<h3>
		<i class="fa fa-angle-right"></i> 신고 접수내역
	</h3>
	<div class="row mt">

		<div class="col-md-12">
			<div class="content-panel">
				<form class="form-horizontal style-form" method="get">
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">신고자 ID</label>
						<div class="col-sm-8">
							<input type="text" class="form-control">
						</div>
						<div class="col-sm-2">
							<button type="button"
								class="btn btn-round btn-primary form-control">검색</button>
						</div>
					</div>
				</form>
				<table class="table table-striped table-advance table-hover">
					<thead>
						<tr>
							<th>NO</th>
							<th>신고날짜</th>
							<th>신고분류</th>
							<th>신고자ID</th>
							<th>상대방ID</th>
							<th>제목</th>
							<th>처리현황</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>2018-01-21</td>
							<td>사기신고</td>
							<td>Atree</td>
							<td>Britz</td>
							<td><a href="#">이러이러햇습니다</a></td>
							<td>처리완료</td>
						</tr>
						<tr>
							<td>2</td>
							<td>2018-01-21</td>
							<td>허위신고</td>
							<td>Quarterback</td>
							<td>cloud</td>
							<td><a href="#">이러이러햇습니다</a></td>
							<td>처리대기</td>
						</tr>
						<tr>
							<td>3</td>
							<td>2018-01-21</td>
							<td>욕설신고</td>
							<td>bs050204</td>
							<td>marcel</td>
							<td><a href="#">이러이러햇습니다</a></td>
							<td>처리대기</td>
						</tr>
					</tbody>

				</table>
			</div>
			<!-- /content-panel -->
		</div>
		<!-- /col-md-12 -->
	</div>


</body>
</html>
