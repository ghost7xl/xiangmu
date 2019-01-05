<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<div class="container" style="background-color: white;">
		<div class="row" style="margin-left: 40px">
			<h3>
				我的购物车<small>温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</small>
			</h3>
		</div>
		<div class="row" style="margin-top: 40px;">
			<div class="col-md-10 col-md-offset-1">
				<table class="table table-bordered table-striped table-hover">
					<tr>
						<th>序号</th>
						<th>商品名称</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${cList}" var="c">
						<form action="CartNumServlet" method="post">
							<tr>
								<input type="hidden" name="id" value="${c.id}" />
								<th>${c.id}</th>
								<th>${c.name}</th>
								<th>${c.price}</th>
								<th width="100px">
									<div class="input-group">
										<span class="input-group-btn"> <!--数量-1  -->
											<button class="btn btn-default" type="submit" name="action"
												value="-">-</button>
										</span> <input type="text" class="form-control" value="${c.num}"
											readonly="readonly" style="width: 40px"> <span
											class="input-group-btn"> <!-- 数量+1 -->
											<button class="btn btn-default" type="submit" name="action"
												value="+">+</button>
										</span>
									</div>
								</th>
								<th>¥&nbsp;${c.money}</th>
								<th><a
									href="CartServlet?method=del&id=${c.id}&price=${c.price}&"
									class="btn btn-default">删除</a></th>
							</tr>
						</form>
					</c:forEach>
				</table>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="pull-right" style="margin-right: 40px;">
				<form action="SubServlet" method="get">
					<div style="margin-bottom: 20px;">
						商品金额总计：<span id="total" class="text-danger"><b>￥&nbsp;&nbsp;${money}</b></span>
					</div>
					<div>
						<select name="address">
							<c:forEach items="${uaList}" var="ua">
								<option value="${ua.id}">${ua.detail}</option>
							</c:forEach>
						</select> <br /> <br /> <a id="removeAllProduct"
							href="SubServlet?method=cleancart" class="btn btn-default btn-lg">清空购物车</a>
						&nbsp;&nbsp; <input type="submit" value="结算"
							class="btn  btn-danger btn-lg"></input>
					</div>
					<br>
				</form>
			</div>
		</div>
	</div>

</body>
</html>