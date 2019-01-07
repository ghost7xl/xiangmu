<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://localhost:8080/Shopping/css/bootstrap.min.css" />
<script type="text/javascript"
	href="http://localhost:8080/Shopping/js/jquery-1.9.1.js"></script>
<script src="http://localhost:8080/Shopping/js/jquery.min.js"></script>
<script src="http://localhost:8080/Shopping/js/bootstrap.min.js"></script>
<script src="http://localhost:8080/Shopping/js/DatePicker.js"></script>
<title>商品列表</title>

</head>
<body>
	<div class="row" style="width: 98%; margin-left: 1%;">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">会员列表</div>
				<div class="panel-body">
					<div class="row">
						<form action="GoodsServlet" method="get">
							<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
								<div class="form-group form-inline">
									<span>商品名称</span> <input type="text" name="searchname"
										class="form-control"> <input type="hidden" name="word"
										value="f">
								</div>
							</div>
							<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
								<button type="button" onclick="form.submit()"
									class="btn btn-primary" id="search">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</div>
						</form>
					</div>
					<div style="height: 400px; overflow: scroll;">
						<table id="tb_list"
							class="table table-striped table-hover table-bordered">
							<tr>
								<td>序号</td>
								<td>商品名称</td>
								<td>价格</td>
								<td>图片</td>
								<td>上架时间</td>
								<td>类型</td>
								<td>操作</td>
							</tr>
							<c:if test="${goodsList != null }">
								<c:forEach items="${goodsList }" var="goods">
									<tr>
										<td>${goods.goodsid }</td>
										<td>${goods.goodsname }</td>
										<td>${goods.goodsprice }</td>
										<td><img src="${goods.picture }" width="40px"
											height="40px" /></td>
										<td>${goods.goodspubdate }</td>
										<td>${goods.typename }</td>
										<td><a
											href="GoodsServlet?goodsid=${goods.goodsid }&word=c">修改</a>&nbsp;&nbsp;
											<a href="GoodsServlet?goodsid=${goods.goodsid }&word=e">删除</a>
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</table>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>