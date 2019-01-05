<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>小米网后台主页-会员信息页面</title>
<link href="http://localhost:8080/Shopping/css/bootstrap.css"
	rel="stylesheet" />
<script src="http://localhost:8080/Shopping/js/jquery-1.9.1.js"></script>
<script src="http://localhost:8080/Shopping/js/bootstrap.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="row" style="width: 800px;">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">会员列表</div>
				<div class="panel-body">
					<!-- 列表显示 -->
					<table id="tb_list"
						class="table table-striped table-hover table-bordered">
						<tr class='tr_head'>
							<td>编号</td>
							<td>邮箱</td>
							<td>姓名</td>
							<td>性别</td>
							<td>密码</td>
							<td>操作</td>
						</tr>
						<form action="UserManageServlet" method="get">
							<tr>
								<td style="width: 50px;"><input style="width: 50px;"
									type="text" name="id" value="${user.id}"></td>
								<td style="width: 50px;"><input style="width: 180px;"
									type="text" name="email" value="${user.email}"></td>
								<td style="width: 50px;"><input style="width: 80px;"
									type="text" name="username" value="${user.username}"></td>
								<td style="width: 50px;"><input style="width: 80px;"
									type="text" name="gender" value="${user.gender}"></td>
								<td style="width: 50px;"><input style="width: 80px;"
									type="text" name="password" value="${user.password}"></td>
								<td><input type="hidden" name="method" value="editone" />
									<input type="submit" class='btn btn-primary btn-xs' value="修改" /></td>
							</tr>
						</form>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>