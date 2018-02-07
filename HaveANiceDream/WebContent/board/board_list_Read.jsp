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
	function reBoardPath(url,parentBoardNo,state) {
		location.href = "/HaveANiceDream/board/replywrite.do?url=" + url+"&parentBoardNo="+parentBoardNo+"&state="+state;

	}
	function DelPath(url,boardNo){
		location.href = "/HaveANiceDream/board/delete.do?url=" + url+"&boardNo="+boardNo;
	}
   </script>
   <script type="text/javascript">
	$(document).ready(function(){
		boardNo = $("#boardNo1").val();
		replylistdata="";
		replyNode = $("#replyCon");
		alert(replyNode);
		$.ajax({
			url : "/HaveANiceDream/reply/list.do",
			type : "GET",
			data : {
				"boardNo" : boardNo 
			},
			dataType : "json", 
			error:function(request,status,error){
		        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		       },
			success : function(data) {
				
				alert(data.replylist.length);
				
				$("#replylist").text(data.replylist);
				for(i in data.emplist){
					replylistdata = replylistdata+data.replylist[i].id+"<br/>";
				}
				$(replyNode).html(replylistdata);
				/* $("#CategoryName").text(res.CategoryName);
				$("#productImg").attr(
						"src",
						"/HaveANiceDream/upload/"
								+ res.productImg);
				$("#ProductTitle").text(res.ProductTitle);
				$("#ProductPrice").text(res.ProductPrice);
				$("#userZipcode").text(res.userZipcode);
				$("#ProductDate").text(res.ProductDate);
				$("#ProductName").text(res.ProductName);
				$("#ProductNo").text(res.ProductNo);
				$("#TradeType").text(res.TradeType);
				$("#sellUserId").text(res.sellUserId);
				$("#sellUserTel").text(res.sellUserTel);
				$("#sellUserEmail").text(res.sellUserEmail);
				$("#buyUserId").text(res.buyUserId);
				$("#buyUserTel").text(res.buyUserTel);
				$("#buyUserEmail").text(res.buyUserEmail); */
			}
		});
		$("#replyInsert").on("click", rplyInsert);
		$("#replyRe").on("click", replySelect);

	});
	
	function rplyInsert() {
		var content = $("#replyContentwrite").val();
		var boardNo1 = $("#boardNo1").val();
		alert(boardNo1);
		if (content=="") {
			alert("댓글을 입력해주세요");
		}else{
 			alert(content);
			$.ajax({
				url : "/HaveANiceDream/reply/insert.do",
				type : "POST",
				data : {
					"replyContent" : content,
					"boardNo" : boardNo1
				},
				dataType : "text",
				success : function(resp) {
				}
			});	 
		}
		$("#replyContentwrite").val("");
		
		
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
			<div class="form-group mb" style="height: auto;">
				
				<div class="col-sm-12 border-content-detail"><%=boardRead.getBoardContent()%></div>
				<div style="padding-left: 30px;"> 첨부된 이미지</div>
				<div class="no-mg-no-pd" style="padding-left: 30px;"> <img alt="" src="/HaveANiceDream/uploadresources/board/<%=boardRead.getBoardimageSrc()%>" > </div>
				<div style="padding-right: 20px; height: auto; text-align: right;"><button type="button" class="btn btn-danger btn-sm" onclick="popup()">게시글 신고하기</button></div>
			</div>

			
			<div class="form-group">
				<div class="col-md-12 border-foot mb">
				<%if(boardRead.getUserId().equals(user.getUserId())){%>
				
					<button type="button" class="btn btn-round btn-default mr" onclick="javascript:DelPath('../board/board_list.jsp',<%=boardRead.getBoardNo()%>)">삭제</button>
					<button type="button" class="btn btn-round btn-default mr" >수정</button>
				<%} %>
					<button type="button" class="btn btn-round btn-default mr" onclick="javascript:reBoardPath('../board/board_write.jsp',<%=boardRead.getBoardNo()%>,'1','<%=boardRead.getBoardType1()%>')">답글</button>
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
						새로고침<a id="replyRe"><i class="fa fa-history"></i></a>
					</h5>
					<div class="col-xs-12 border-reply-mid">
						<!-- 답글! -->
						<div class="col-xs-10 mb">아이디 : id (작성일자 : 2018-01-05 20:30)</div>
						<div class="col-xs-2 mb">
							<button type="button" class="btn btn-danger btn-xs pull-right">신고하기</button>
						</div>
						<div class="col-xs-12 border-content-detail">여기는 내용이 들어갈
							공간입니다. 어떤 내용이 들어가도 줄바꿈이 가능하며 걱정없습니다. 계속해서 쭉쭉쭉 써주세요 그리고 신고기능을 추가할
							겁니다. 어떻게 해야할까요? 내용안에 넣어야 겠지요? 그럼 신고기능 연결을 위해 신고기능을 맡고 있는 우리 진우와 또
							의논을 해봐야 겠네요? 자 어때요 css 및 뷰작업은 이제 껌때가리죠? ㅎㅎㅎㅎㅎ 어떤내용을 넣을지 막막할 때는
							무조건 구글링 & 밤샘 작업을 한다면 문제 없지요 자 그럼 우리 다함께 드림 합시다 드림드림드림 드림
							드림~ㅇㅀㅇㅀㄹㅇㅎ~
							
						</div>
						<button type="button" class="btn btn-round btn-xs btn-default ml">삭제하기</button>
						<button type="button" class="btn btn-round btn-xs btn-default ml">수정하기</button>
					</div>
					<div class="col-xs-12 border-reply-mid">
						<div class="col-xs-10 mb">아이디 : id (작성일자 : 2018-01-05 20:30)</div>
						<div class="col-xs-2 mb">
							<button type="button" class="btn btn-danger btn-xs pull-right">신고하기</button>
						</div>
						<div class="col-xs-12 border-content-detail" id="replyCon">여기는 내용이 들어갈
							공간입니다. 어떤 내용이 들어가도 줄바꿈이 가능하며 걱정없습니다. 계속해서 쭉쭉쭉 써주세요 그리고 신고기능을 추가할
							겁니다. 어떻게 해야할까요? 내용안에 넣어야 겠지요? 그럼 신고기능 연결을 위해 우리 신고기능을 맡고 있는 진우와 또
							의논을 해봐야 겠네요? 자 어때요 css 및 뷰작업은 이제 껌때가리죠? ㅎㅎㅎㅎㅎ 어떤내용을 넣을지 막막할 때는
							무조건 구글링 & 밤샘 작업을 한다면 문제 없지요 자 그럼 우리 다함께 드림 합시다 드림드림드림 드림
							드림~ㅇㅀㅇㅀㄹㅇㅎ~</div>
						<button type="button" class="btn btn-round btn-xs btn-default ml">삭제하기</button>
						<button type="button" class="btn btn-round btn-xs btn-default ml">수정하기</button>
					</div>
					
					
					<div class="col-xs-12 border-reply-back">
						<span class="col-xs-2 border-reply-id-font"><i
							class="fa fa-user"></i> <a>드림왕</a> </span> <span class="col-md-9">
							<textarea name="replyContent" id="replyContentwrite"
								style="width: 100%; border: 1; overflow: visible; text-overflow: ellipsis;"
								rows=5></textarea>
						</span> <span class="col-xs-1"> <a
							class="btn btn-default border-reply-btn-size" id="replyInsert" ><i
								class=" fa fa-edit"></i>등록</a>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form action="thisform">
		<input type="hidden" name="boardNo1" id="boardNo1" value="<%=boardRead.getBoardNo()%>" >
	</form>
</body>
</html>
