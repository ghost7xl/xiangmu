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
					<!-- 条件查询 -->
					<div class="row">
						<form id="form" name="form" method="post"
							action="UserManageServlet">
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
								<div class="form-group form-inline">
									<span>用户姓名</span> <input type="text" name="username"
										class="form-control">
								</div>
							</div>
							<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
								<div class="form-group form-inline">
									<span>性别</span> &nbsp;&nbsp;&nbsp;&nbsp; <label
										class="radio-inline"> <input type="radio"
										name="gender" value="男"> 男&nbsp;&nbsp;&nbsp;&nbsp;
									</label> <label class="radio-inline"> <input type="radio"
										name="gender" value="女"> 女
									</label>
								</div>
							</div>
							<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
								<button type="submit" class="btn btn-primary" id="search">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</div>
						</form>
					</div>
					<!-- 列表显示 -->
					<table id="tb_list"
						class="table table-striped table-hover table-bordered">
						<tr class='tr_head'>
							<td>编号</td>
							<td>邮箱</td>
							<td>姓名</td>
							<td>性别</td>
							<td>状态</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${uList}" var="u">
							<form action="UserManageServlet" method="get">
								<tr>
									<td style="width: 50px;"><input style="width: 80px;"
										type="text" name="id" value="${u.id}"></td>
									<td style="width: 50px;"><input style="width: 220px;"
										type="text" name="email" value="${u.email}"></td>
									<td style="width: 50px;"><input style="width: 80px;"
										type="text" name="username" value="${u.username}"></td>
									<td style="width: 50px;"><input style="width: 80px;"
										type="text" name="gender" value="${u.gender}"></td>
									<td style="width: 50px;"><input style="width: 80px;"
										type="text" name="flag" value="${u.flag}"></td>
									<td><input type="hidden" name="method" value="edit" /> <input
										type="submit" class='btn btn-primary btn-xs'></input> <a
										href="UserManageServlet?method=del&id=${u.id}"
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