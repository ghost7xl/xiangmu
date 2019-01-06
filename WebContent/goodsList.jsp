<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="panel panel-primary" style="margin: 0 auto; width: 95%;">
		<div class="panel-heading">
			<h3 class="panel-title">
				<span class="glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;商品列表
			</h3>
		</div>
		<div class="panel-body">
			<!-- 列表开始 -->
			<div class="row" style="margin: 0 auto;">
				<c:forEach items="${l}" var="g">
					<div class="col-sm-3">
						<div class="thumbnail">
							<img src="${g.picture}" width="180" height="180"
								alt="${g.goodsname}" />
							<div class="caption">
								<h4>
									商品名称：<a href="FGoodsServlet?id=${g.goodsid}">${g.goodsname}</a>
								</h4>
								<p>
									热销指数：
									<c:forEach begin="1" end="${g.goodsstar}">
										<img src="image/star_red.gif" alt="star" />
									</c:forEach>
								</p>
								<p>上架日期：${g.goodspubdate}</p>
								<p style="color: orange">价格：${g.goodsprice}元</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

	</div>

	<%@ include file="footer.jsp"%>

</body>
</html>