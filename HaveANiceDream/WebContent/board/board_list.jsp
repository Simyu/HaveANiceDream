<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
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

</body>
</html>
