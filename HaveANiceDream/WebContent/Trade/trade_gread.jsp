<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>���ϱ�!</title>

<!-- Bootstrap core CSS -->
<link href="/HaveANiceDream/Theme/assets/css/bootstrap.css" rel="stylesheet">

<link href="/HaveANiceDream/Theme/assets/css/style.css" rel="stylesheet">

<script src="/HaveANiceDream/Theme/assets/js/jquery.js"></script>
<script src="/HaveANiceDream/Theme/assets/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    //���� ���ó�� ���۽�ų üũ�ڽ� �׷� ������
    $('input[type="checkbox"][name="group"]').click(function(){
        //Ŭ�� �̺�Ʈ �߻��� ��Ұ� üũ ������ ���
        if ($(this).prop('checked')) {
            //üũ�ڽ� �׷��� ��� ��ü�� üũ ������ Ŭ���� ��� üũ ��������
            $('input[type="checkbox"][name="group"]').prop('checked', false);
            $(this).prop('checked', true);
        }
    });
});
</script>

</head>

<body>
	<%String productNo = request.getParameter("productNo"); 
		String tradeNo = request.getParameter("tradeNo");
		String state = request.getParameter("state");//'1'= ������ -----> �Ǹ�����,  '2'= �Ǹ��� -----> ��������

	%>

		<div class="col-md-1 col-sm-1 col-xs-1"></div>
		<div class="col-md-10 col-sm-10 col-xs-10">
			<%if(state.equals("1")){ %>
			<div class="col-md-12 col-sm-12 col-xs-12" style="color: black; padding-top: 25px;"><h3>���ϱ�(�Ǹ���)</h3></div>
			<%}else{%>
			<div class="col-md-12 col-sm-12 col-xs-12" style="color: black; padding-top: 25px;"><h3>���ϱ�(������)</h3></div>
			<%} %>
			<form class="form-horizontal style-form" enctype="multipart/form-data" 
				action="/HaveANiceDream/grade/insert.do?productNo=<%=productNo %>&tradeNo=<%=tradeNo%>&state=<%=state%>" method="post">
				<div class="col-md-12 col-sm-12 col-xs-12 steps pn no-mg-no-pd" style="background-color: #d5e1ed; height: auto;">
					<div class="ccol-md-3 col-sm-3 col-xs-3 no-mg-no-pd" >
					<input id='op1' name="group" type='checkbox' onclick="oneCheckbox(this) checked " /> <label for='op1'>�ſ츸��</label> 
					</div>
					<div class="col-md-2 col-sm-2 col-xs-2 no-mg-no-pd" >
					<input id='op2'name="group" type='checkbox' onclick="oneCheckbox(this)" /> <label for='op2'>����</label> 
					</div>
					<div class="col-md-2 col-sm-2 col-xs-2 no-mg-no-pd" >
					<input id='op3' name="group" type='checkbox' onclick="oneCheckbox(this)" /> <label for='op3'>����</label>
					</div>
					<div class="col-md-2 col-sm-2 col-xs-2 no-mg-no-pd" >
					<input id='op4'name="group" type='checkbox' onclick="oneCheckbox(this)" /> <label for='op4'>�Ҹ���</label>
					</div>
					<div class="col-md-3 col-sm-3 col-xs-3 no-mg-no-pd" >
					<input id='op5'name="group" type='checkbox' onclick="oneCheckbox(this)" /> <label for='op5'>�ſ�Ҹ���</label>
					</div>
					<div class="col-md-1 col-sm-1 col-xs-1 no-mg-no-pd"></div>
					<div class="col-md-11 col-sm-11 col-xs-11 no-mg-no-pd" style="height: 20px; margin-top: 10px; margin-bottom:10px; color: #2f78bd;">
					�����ۼ�
					</div>
					
					<div class="col-md-1 col-sm-1 col-xs-1 no-mg-no-pd" style="height: 120px; "></div>
					<div class="col-md-10 col-sm-10 col-xs-10 no-mg-no-pd" style="height: 120px; "> 
					<textarea style="width:100%;border:1;overflow:visible;text-overflow:ellipsis; border: #8b929e" rows=6></textarea>
					</div>
					<div class="col-md-1 col-sm-1 col-xs-1 no-mg-no-pd" style="height: 120px; "></div>
					<div class="col-md-6 col-sm-6 col-xs-6 no-mg-no-pd">
					<input type='submit' value='���' id='submit' onclick="window.close()"/>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-6 no-mg-no-pd">
					<input type='submit' value='���ϱ�' id='submit' onclick="window.close()"/>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-1 col-sm-1 col-xs-1"></div>
</body>
</html>
