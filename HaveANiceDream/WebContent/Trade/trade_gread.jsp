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
	function oneCheckbox(a) {

		var obj = document.getElementsByName("checkbox1");

		for (var i = 0; i < obj.length; i++) {

			if (obj[i] != a) {

				obj[i].checked = false;

			}

		}

	}
</script>

</head>

<body>
	<div class="col-sm-5">
		<div class="col-sm-12" style="color: black; padding-top: 35px;">
			<h3>���ϱ�</h3>
		</div>
		<div class="steps pn no-mg-no-pd"
			style="margin-top: 100px; background-color: #393d40; height: auto;">
			<div class="col-sm-3 no-mg-no-pd">
				<input id='op1' name="checkbox1" type='checkbox'
					onclick="oneCheckbox(this) checked " /> <label for='op1'>�ſ츸��</label>
			</div>
			<div class="col-sm-2 no-mg-no-pd">
				<input id='op2' name="checkbox1" type='checkbox'
					onclick="oneCheckbox(this)" /> <label for='op2'>����</label>
			</div>
			<div class="col-sm-2 no-mg-no-pd">
				<input id='op3' name="checkbox1" type='checkbox'
					onclick="oneCheckbox(this)" /> <label for='op3'>����</label>
			</div>
			<div class="col-sm-2 no-mg-no-pd">
				<input id='op4' name="checkbox1" type='checkbox'
					onclick="oneCheckbox(this)" /> <label for='op4'>�Ҹ���</label>
			</div>
			<div class="col-sm-3 no-mg-no-pd">
				<input id='op5' name="checkbox1" type='checkbox'
					onclick="oneCheckbox(this)" /> <label for='op5'>�ſ�Ҹ���</label>
			</div>

			<div class="col-sm-1 no-mg-no-pd"
				style="height: 50px; margin-top: 30px;"></div>
			<div class="col-sm-10 no-mg-no-pd"
				style="height: 50px; margin-top: 30px;">
				<input type="text" class="form-control">
			</div>
			<div class="col-sm-1 no-mg-no-pd"
				style="height: 50px; margin-top: 30px;"></div>

			<div class="col-sm-1 no-mg-no-pd" style="height: 120px;"></div>
			<div class="col-sm-10 no-mg-no-pd" style="height: 120px;">
				<textarea
					style="width: 100%; border: 1; overflow: visible; text-overflow: ellipsis;"
					rows=6>���ۼ�</textarea>
			</div>
			<div class="col-sm-1 no-mg-no-pd" style="height: 120px;"></div>
			<div class="col-sm-6 no-mg-no-pd">
				<input type='submit' value='���' id='submit' />
			</div>
			<div class="col-sm-6 no-mg-no-pd">
				<input type='submit' value='���ϱ�' id='submit' />
			</div>
		</div>
	</div>
	<div class="col-sm-7"></div>
</body>
</html>
