<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情页</title>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div style="margin: 0 auto; width: 90%;">
		<ol class="breadcrumb">
			<li><a href="#">锋米之家</a></li>
			<li><a href="#">${goods.typename}</a></li>
			<li class="active"><a href="">${goods.typename}</a></li>
		</ol>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-md-6">
				<a href="#" class="thumbnail"> <img src="${goods.picture}"
					width="560" height="560" alt="" />
				</a>
			</div>
			<div class="col-xs-6 col-md-6">
				<div class="panel panel-default" style="height: 560px">
					<div class="panel-heading">商品详情</div>
					<div class="panel-body">
						<h3>
							产品名称:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${goods.goodsname}</h3>
						<div style="margin-left: 10px;">

							<p>
								市场价格:&nbsp;&nbsp;&nbsp;<span class="text-danger"
									style="font-size: 15px;">${goods.goodsprice}</span>&nbsp;&nbsp;<span
									class="glyphicon glyphicon-yen"></span>
							</p>
							<p>上市时间:&nbsp;&nbsp;&nbsp;${goods.goodspubdate}</p>
							<p>
								热销指数:&nbsp;&nbsp;&nbsp;
								<c:forEach begin="1" end="${goods.goodsstar}">
									<img src="image/star_red.gif" alt="star" />
								</c:forEach>
							</p>
							<p>详细介绍:</p>
							<p>
								&nbsp;&nbsp;<small>${goods.goodsintro}<small>
							</p>
							<a
								href="CartServlet?gid=${goods.goodsid }&money=${goods.goodsprice}"
								class="btn btn-warning">加入购物车&nbsp;&nbsp;&nbsp;<span
								class="glyphicon glyphicon-shopping-cart"></span></a>&nbsp;&nbsp;&nbsp;
							<a href="" class="btn btn-warning">直接购买&nbsp;&nbsp;&nbsp;<span
								class="glyphicon glyphicon-shopping-cart"></span></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>