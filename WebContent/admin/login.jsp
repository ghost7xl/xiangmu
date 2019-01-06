<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<!-- Bootstrap -->
<link href="http://localhost:8080/Shopping/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://localhost:8080/Shopping/js/jquery.min.js"></script>
<script src="http://localhost:8080/Shopping/js/bootstrap.min.js"></script>
<title>登录</title>

<style type="text/css">
#main {
	position: absolute;
	width: 400px;
	height: 300px;
	left: 50%;
	top: 40%;
	margin-left: -200px;
	margin-top: -100px;
}
</style>
</head>
<body>
	<div id="main" class="panel panel-primary">
		<div class="panel-heading">
			<div class="panel-title">锋米之家-后台登录</div>
		</div>
		<div class="panel-body">
			<form action="../AdminLoginServlet" method="post">
				<div class="form-group">
					<label>用户名:</label> <input type="text" name="username" id=""
						class="form-control" placeholder="请输入用户名" />
				</div>
				<div class="form-group">
					<label>密&nbsp;&nbsp;&nbsp;码:</label>
					<div class="input-group">
						<input type="password" name="password" id="password"
							class="form-control" placeholder="请输入密码" /> <span
							class="input-group-addon"> <span
							class="glyphicon glyphicon-eye-open" id="eye"></span>
						</span>
					</div>
				</div>
				<div class="form-group" style="text-align: center;">
					<input type="submit" value="登录" class="btn btn-primary"> <input
						type="reset" value="重置" class="btn btn-default">
				</div>
			</form>
		</div>
	</div>
</body>
</html>