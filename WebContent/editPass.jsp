<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script>
	function validate() {
		var pwd = $("#pwd").val();
		var pwd1 = $("#pwd1").val();
		if (pwd1 == pwd) {
			$("#tishi").html("两次密码相同");
			$("#tishi").css("color", "green");
		} else {
			$("#tishi").html("两次密码不相同");
			$("#tishi").css("color", "red");
		}
	}
</script>
<link rel="stylesheet" type="text/css" href="css/login.css">

<title>修改密码</title>
</head>
<body>
	<div class="regist">
		<div class="regist_center">
			<div class="regist_top">
				<div class="left fl">
					<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;会员密码修改
				</div>
				<div class="right fr">
					<a href="index.jsp" target="_black">锋米之家</a>
				</div>
				<div class="clear"></div>
				<div class="xian center"></div>
			</div>
			<div class="center-block" style="margin-top: 80px;">
				<form class="form-horizontal" action="UpdatePasswordServlet"
					method="get">
					<input type="hidden" name="type" value="register">
					<div class="form-group">
						<label class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-8" style="width: 40%">
							<input type="text" id="username" name="username"
								class="form-control col-sm-10" placeholder="Username" />
						</div>
						<div class="col-sm-2">
							<p class="text-danger">
								<span class="help-block " id="usernameMsg"></span>
							</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">请输入新密码</label>
						<div class="col-sm-8" style="width: 40%">
							<input type="password" class="form-control col-sm-10" id="pwd"
								placeholder="New Password"><span id="tishi"></span>
						</div>
						<div class="col-sm-2">
							<p class="text-danger">
								<span id="helpBlock" class="help-block ">请不输入6位以上字符</span>
							</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">请确认新密码</label>
						<div class="col-sm-8" style="width: 40%">
							<input type="password" class="form-control col-sm-10" id="pwd1"
								placeholder="New Password Again" onkeyup="validate()"><span
								id="tishi"></span>
						</div>
						<div class="col-sm-2">
							<p class="text-danger">
								<span id="helpBlock" class="help-block ">两次密码要输入一致哦</span>
							</p>
						</div>
					</div>
					<hr>
					<div class="form-group">
						<div class="col-sm-7 col-sm-push-2">
							<input id="registerBtn" type="submit" value="确认修改"
								class="btn btn-primary  btn-lg" style="width: 200px;" /> &nbsp;
							&nbsp; <input type="reset" value="重置"
								class="btn btn-default  btn-lg" style="width: 200px;" />
						</div>
					</div>
					<div></div>
				</form>

			</div>
		</div>
	</div>

</body>
</html>