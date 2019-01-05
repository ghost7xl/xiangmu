<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>小米网后台主页-管理员页面</title>
<link href="http://localhost:8080/Shopping/css/bootstrap.css"
	rel="stylesheet" />
<script src="http://localhost:8080/Shopping/js/jquery-1.9.1.js"></script>
<script src="http://localhost:8080/Shopping/js/bootstrap.js"></script>
</head>
<body>
	<div class="row" style="width: 800px;">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">管理员管理</div>
				<div class="panel-body">
					<table id="tb_list"
						class="table table-striped table-hover table-bordered">
						<tr class='tr_head'>
							<td>管理员id</td>
							<td>管理员名</td>
							<td>管理员密码</td>
							<td>管理员权限</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${suList}" var="a">
							<form action="AdminLoginServlet" method="get">
								<tr>
									<td style="width: 50px;"><input style="width: 80px;"
										type="text" name="id" disabled="disabled" value="${a.id}"></td>
									<td style="width: 50px;"><input style="width: 220px;"
										type="text" name="username" value="${a.username}"></td>
									<td style="width: 50px;"><input style="width: 80px;"
										type="text" name="password" value="${a.password}"></td>
									<td style="width: 50px;"><input style="width: 80px;"
										type="text" name="flag" value="${a.flag}"></td>
									<td><input type="hidden" name="method" value="edit" /> <input
										type="submit" class='btn btn-primary btn-xs'></input> <a
										href="UserManageServlet?method=del&id=${a.id}"
										class='btn btn-primary btn-xs'>删除</a></td>
								</tr>
							</form>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>