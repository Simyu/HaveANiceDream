<%@page import="user.dto.MemberDTO"%>
<%@page import="board.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>게시판</title>

<script type="text/javascript">
   	function popup2(){
   		window.open("/HaveANiceDream/blame/report_popup.jsp", "a", "width=700, height=900, left=100, top=50")
   		
   	}
/* 	function boardListPath() {
		location.href = "/HaveANiceDream/board/list.do";
	} */
	function setPath(url,boardNo) {
		if(boardNo!=null){
			location.href = "/HaveANiceDream/board/list.do?url=" + url+"&boardNo="+boardNo;
		}else{
			location.href = "/HaveANiceDream/board/list.do?url=" + url;
		}
	}
	function reBoardPath(url,parentBoardNo) {
		location.href = "/HaveANiceDream/view.html?url=" + url+"&parentBoardNo="+parentBoardNo;

	}
   </script>
</head>

<body>
	<%BoardDTO boardRead = (BoardDTO)request.getAttribute("boardRead"); 
	  MemberDTO user = (MemberDTO) session.getAttribute("user");
	%>
	<div class="col-md-12">
		<h4>
			<i class="fa fa-angle-right"></i>커뮤니티
		</h4>
		<hr>
		<div class="content-panel">
			<div class="col-md-12">
				<h3>
					<i class="fa fa-angle-right"></i>자유게시판
				</h3>
			</div>
			<div class="form-group">
				<div class="col-md-2 border-title">게시글 번호 : <%=boardRead.getBoardNo()%></div>
				<div class="col-md-2 border-title">아이디 : <%=boardRead.getUserId() %></div>
				<div class="col-md-6 border-title">작성일자 : <%=boardRead.getWriteDate() %></div>
				<div class="col-md-2 border-title">조회수 :<%=boardRead.getBoardCount() %></div>
			</div>
			<div class="form-group">
				<h5 class="col-sm-2" style="text-align: center;"><%=boardRead.getBoardType1() %>><%=boardRead.getBoardType2() %></h5>
				<div class="col-sm-8"></div>
				<h5 class="col-sm-2" style="text-align: center;">
					목록 | 댓글(<a>10</a>)
				</h5>
			</div>
			<div class="form-group">
				<h2 class="col-sm-12 border-title-content"><%=boardRead.getBoardTitle() %></h2>
			</div>
			<div class="form-group">
				
				<div class="col-sm-12 border-content-detail"><%=boardRead.getBoardContent()%></div>
				<div> 첨부된 이미지</div>
				<div class="no-mg-no-pd"> <img alt="" src="/HaveANiceDream/uploadresources/board/<%=boardRead.getBoardimageSrc()%>" > </div>
			</div>
			<div class="form-group">
				<div class="col-sm-12 mb">
					<button type="button" class="btn btn-danger pull-right" onclick="popup()">신고하기</button>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-md-12 border-foot mb">
				<%if(boardRead.getUserId().equals(user.getUserId())){%>
				
					<button type="button" class="btn btn-round btn-default mr">삭제</button>
					<button type="button" class="btn btn-round btn-default mr">수정</button>
				<%} %>
					<button type="button" class="btn btn-round btn-default mr" onclick="javascript:reBoardPath('../board/board_write.jsp',<%=boardRead.getBoardNo()%>)">답글</button>
					<button type="button" class="btn btn-round btn-default mr" onclick="javascript:setPath('../board/board_list.jsp')">목록</button>
				</div>
			</div>
			<!-- 답글 폼 스타트!! -->
			<div class="form-group">
				<div class="col-md-12 border-reply-top mb">
					<!-- 답글 최상위 페이지!! -->
					<h4>
						<i class="fa fa-angle-right"></i>댓글달기
					</h4>
					<h5 class="col-sm-2" style="text-align: center;">
						▼ 댓글(<a>10</a>)
					</h5>
					<div class="col-sm-8"></div>
					<h5 class="col-sm-2" style="text-align: center;">
						새로고침(<a>®</a>)
					</h5>
					<div class="col-md-12 border-reply-mid">
						<!-- 답글! -->
						<div class="col-md-10 mb">아이디 : id (작성일자 : 2018-01-05 20:30)</div>
						<div class="col-md-2 mb">
							<button type="button" class="btn btn-danger btn-xs pull-right">신고하기</button>
						</div>
						<div class="col-sm-12 border-content-detail">여기는 내용이 들어갈
							공간입니다. 어떤 내용이 들어가도 줄바꿈이 가능하며 걱정없습니다. 계속해서 쭉쭉쭉 써주세요 그리고 신고기능을 추가할
							겁니다. 어떻게 해야할까요? 내용안에 넣어야 겠지요? 그럼 신고기능 연결을 위해 신고기능을 맡고 있는 우리 진우와 또
							의논을 해봐야 겠네요? 자 어때요 css 및 뷰작업은 이제 껌때가리죠? ㅎㅎㅎㅎㅎ 어떤내용을 넣을지 막막할 때는
							무조건 구글링 & 밤샘 작업을 한다면 문제 없지요 자 그럼 우리 다함께 드림 합시다 드림드림드림 드림
							드림~ㅇㅀㅇㅀㄹㅇㅎ~
							
						</div>
						<button type="button" class="btn btn-round btn-xs btn-default ml">삭제하기</button>
						<button type="button" class="btn btn-round btn-xs btn-default ml">수정하기</button>
					</div>
					<div class="col-md-12 border-reply-mid">
						<div class="col-md-10 mb">아이디 : id (작성일자 : 2018-01-05 20:30)</div>
						<div class="col-md-2 mb">
							<button type="button" class="btn btn-danger btn-xs pull-right">신고하기</button>
						</div>
						<div class="col-sm-12 border-content-detail">여기는 내용이 들어갈
							공간입니다. 어떤 내용이 들어가도 줄바꿈이 가능하며 걱정없습니다. 계속해서 쭉쭉쭉 써주세요 그리고 신고기능을 추가할
							겁니다. 어떻게 해야할까요? 내용안에 넣어야 겠지요? 그럼 신고기능 연결을 위해 우리 신고기능을 맡고 있는 진우와 또
							의논을 해봐야 겠네요? 자 어때요 css 및 뷰작업은 이제 껌때가리죠? ㅎㅎㅎㅎㅎ 어떤내용을 넣을지 막막할 때는
							무조건 구글링 & 밤샘 작업을 한다면 문제 없지요 자 그럼 우리 다함께 드림 합시다 드림드림드림 드림
							드림~ㅇㅀㅇㅀㄹㅇㅎ~</div>
						<button type="button" class="btn btn-round btn-xs btn-default ml">삭제하기</button>
						<button type="button" class="btn btn-round btn-xs btn-default ml">수정하기</button>
					</div>
					<div class="col-md-12 border-reply-back">
						<span class="col-md-2 border-reply-id-font"><i
							class="fa fa-user"></i> <a>드림왕</a> </span> <span class="col-md-9">
							<textarea name="ourtext"
								style="width: 100%; border: 1; overflow: visible; text-overflow: ellipsis;"
								rows=5>텍스트</textarea>
						</span> <span class="col-md-1"> <a
							class="btn btn-default border-reply-btn-size" href="#"><i
								class=" fa fa-edit"></i>등록</a>
						</span>
					</div>
				</div>
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
						<td><span class="badge bg-important"><i
								class="fa fa-bullhorn"></i> 공지사항</span></td>
						<td>a테그를 붙여서 넘겨보장!</td>
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
			<a class="btn btn-default pull-right" href="#"><i
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
