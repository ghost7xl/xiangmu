<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Insert title here</title>
<script>
	$(function() {
		$.ajax({
			type : "get",
			dataType : "json",
			url : "GoodsServlet",
			success : function(data) {
				var gtList = data.gtList;
				for (var i = 0; i < gtList.length; i++) {
					var option = "<option value='"+gtList[i].id+"'>"
							+ gtList[i].name + "</option>";
					$("#type").append(option);
				}
			}
		});
	})
</script>
</head>
<body>
	<div class="row" style="width: 98%; margin-left: 1%;">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">修改商品信息</div>
				<div class="panel-body">
					<form action="GoodsServlet" method="get">
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
								<c:if test="${gvs != null }">
									<tr>
										<td>${gvs.goodsid }<input type="hidden" value="d"
											name="word" /> <input type="hidden" value="${gvs.goodsid }"
											name="goodsid">
										</td>
										<td><input type="text" style="height: 30px; width: 100px"
											value="${gvs.goodsname }" name="goodsname"></td>
										<td><input type="text" style="height: 30px; width: 100px"
											value="${gvs.goodsprice }" name="goodsprice"></td>
										<td><img src="${gvs.picture }" width="40px" height="40px" />
											<input type="hidden" name="goodsintro"
											value="${gvs.goodsintro }"> <input type="hidden"
											name="picture" value="${gvs.picture }"> <input
											type="hidden" name="star" value="${gvs.goodsstar }">
										</td>
										<td>
											<%-- <input type="text" style="height:30px;width:100px"  value="${gvs.goodspubdate }" name="goodspubdate">
										 --%> ${gvs.goodspubdate }
										</td>
										<%-- <td><input type="text" style="height:30px;width:100px" value="${gvs.typename }" name="typename"></td> --%>
										<td>
											<div class="form-group form-inline">
												<select id="type" name="typeid" class="form-control">
												</select>
											</div>
										<td><input type="submit" value="修改"></td>
									</tr>
								</c:if>
							</table>
							<center>
								<a href="GoodsServlet?word=b"><h3>返回</h3></a>
							</center>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>