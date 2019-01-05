<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单详情页</title>
<link href="http://localhost:8080/Shopping/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="http://localhost:8080/Shopping/js/jquery.min.js"></script>
</head>
<div class="panel panel-default" style="margin: 0 auto; width: 95%;">
	<div class="panel-heading">
		<h3 class="panel-title">
			<span class="glyphicon glyphicon-equalizer"></span>&nbsp;&nbsp;订单详情
		</h3>
	</div>
	<div class="panel-body">
		<table cellpadding="0" cellspacing="0" align="center" width="100%"
			class="table table-striped table-bordered table-hover">

			<tr>
				<td>订单编号:</td>
				<td>${userOrderPojo.oid}</td>
				<td>订单时间:</td>
				<td>${userOrderPojo.createtime}</td>
			</tr>
			<tr>
				<td>收件人:</td>
				<td>${userOrderPojo.addressname }</td>
				<td>联系电话:</td>
				<td>${userOrderPojo.tel }</td>
			</tr>
			<tr>
				<td>送货地址:</td>
				<td>${userOrderPojo.address }</td>
				<td>总价:</td>
				<td>${userOrderPojo.allprice}</td>
			</tr>
			<tr>
				<td align="center">商品列表:</td>
				<td colspan="3">
					<table align="center" cellpadding="0" cellspacing="0" width="100%"
						class="table table-striped table-bordered table-hover">
						<tr align="center" class="info">
							<th>序号</th>
							<th>商品封面</th>
							<th>商品名称</th>
							<th>商品评分</th>
							<th>商品日期</th>
							<th>商品单价</th>
							<th>购买数量</th>
							<th>小计</th>
						</tr>
						<c:forEach items="${userOrderPojo.godvList}" var="g" varStatus="i">
							<tr align="center">
								<th>${g.id}</th>
								<th><img src="${g.picture}" width="50px" height="50px"></th>
								<th>${g.name}</th>
								<th>${g.star}</th>
								<th>${g.pubdate}</th>
								<th>${g.money}</th>
								<th>${g.num}</th>
								<th>${g.allmoney}</th>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>