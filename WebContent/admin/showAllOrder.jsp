<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台 订单列表</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://localhost:8080/Shopping/css/bootstrap.css"
	rel="stylesheet" />
<script src="http://localhost:8080/Shopping/js/jquery-1.9.1.js"></script>
<script src="http://localhost:8080/Shopping/js/bootstrap.js"></script>
</head>
<body>
	<div class="row" style="width: 98%; margin-left: 1%; margin-top: 5px;">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">订单列表</div>
				<div class="panel-body">
					<div class="row">
						<form id="form" name="form" method="post" action="OrderServlet">
							<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
								<div class="form-group form-inline">
									<span>用户姓名</span> <input type="text" name="username"
										class="form-control">
								</div>
							</div>
							<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
								<div class="form-group form-inline">
									<span>订单状态</span> <select name="flag" class="form-control">
										<option value=" ">----------</option>
										<option value="1">未支付</option>
										<option value="2">已支付,待发货</option>
										<option value="3">已发货,待收货</option>
										<option value="4">已收货,未评价</option>
										<option value="5">完成订单</option>
									</select>
								</div>
							</div>
							<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
								<button type="submit" class="btn btn-primary" id="search">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</div>
						</form>
					</div>
					<table id="tb_list"
						class="table table-striped table-hover table-bordered table-condensed">
						<tr>
							<td>序号</td>
							<td>订单编号</td>
							<td>总金额</td>
							<td>订单状态</td>
							<td>订单时间</td>
							<td>用户姓名</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${oList}" var="o" varStatus="i">
							<tr>
								<td>${i.index+1}</td>
								<td>${o.id}</td>
								<td>${o.money}</td>
								<c:if test="${o.flag==1 }">
									<td>未支付</td>
								</c:if>
								<c:if test="${o.flag==2 }">
									<td>已支付,待发货</td>
								</c:if>
								<c:if test="${o.flag==3 }">
									<td>已发货,待收货</td>
								</c:if>
								<c:if test="${o.flag==4 }">
									<td>已收货,未评价</td>
								</c:if>
								<c:if test="${o.flag==5 }">
									<td>订单完成</td>
								</c:if>
								<td>${o.createTime}</td>
								<td>${o.username}</td>
								<td><a href="OrderServlet?method=edit&id=${o.id}&flag=3"
									class="btn btn-primary btn-xs">发货</a> <a
									href="OrderDetailServlet?id=${o.id}"
									class="btn btn-primary btn-xs">查看详情</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>