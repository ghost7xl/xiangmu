<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://localhost:8080/Shopping/css/bootstrap.min.css" />
<script src="http://localhost:8080/Shopping/js/jquery.min.js"></script>
<script src="http://localhost:8080/Shopping/js/bootstrap.min.js"></script>
<title>添加商品种类</title>
<script>
	$(function() {
		$.ajax({
			type : "get",
			dataType : "json",
			url : "../GoodsServlet",
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
	<div style="width: 98%; margin-left: 1%;">
		<div class="panel panel-default">
			<div class="panel-heading">添加商品种类</div>
			<div class="panel-body">
				<form action="../GoodsTypeServlet" method="post">
					<div class="row">
						<div class="form-group form-inline">
							<span>所属类型</span> <select id="type" name="parentid">
								<option value="0">--请选择所属类型--</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-inline">
							<span>种类名称</span> <input type="text" name="name"
								class="form-control">
						</div>
					</div>
					<div class="form-group form-inline">
						<label>评分:</label>
						<!-- <input type="text" name="star" class="form-control" /> -->
						<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
						<select id="level" name="level" class="form-control">
							<option value="0">---请选择商品类型---</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>
					<div class="row">
						<div class="btn-group">
							<button type="reset" class="btn btn-default">清空</button>
							<button type="submit" class="btn btn-default">添加</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>