<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://localhost:8080/Shopping/css/bootstrap.min.css" />
<script src="http://localhost:8080/Shopping/js/bootstrap.min.js"></script>
<link
	href="http://localhost:8080/Shopping/ueditor/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="http://localhost:8080/Shopping/js/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="http://localhost:8080/Shopping/ueditor/umeditor.config.js"></script>
<script type="text/javascript"
	src="http://localhost:8080/Shopping/ueditor/umeditor.js"></script>
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

<title>商品添加页面</title>
</head>
<body>
	<div class="row" style="margin-left: 20px; height: 100%;">
		<form action="../GoodsServlet" method="post"
			enctype="multipart/form-data">
			<div>
				<h3>新增商品</h3>
			</div>
			<hr />
			<div class="row">
				<div class="col-sm-6">
					<p style="color: red"></p>
					<div class="form-group form-inline">
						<label>名称:</label> <input type="text" name="name"
							class="form-control" /> <input type="hidden" name="word"
							value="a">
					</div>

					<div class="form-group form-inline">
						<label>分类:</label> <select id="type" name="typeid"
							class="form-control">
							<option value="0">---请选择商品类型---</option>
						</select>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group form-inline">
						<label>价格:</label> <input type="text" name="price"
							class="form-control" /> 元
					</div>
					<div class="form-group form-inline">
						<label>评分:</label>
						<!-- <input type="text" name="star" class="form-control" /> -->
						<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
						<select id="level" name="star" class="form-control">
							<option value="0">---请选择商品类型---</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-10">
					<div class="form-group form-inline">
						<label>商品图片</label> <input type="file" name="picture" />
					</div>
					<div class="form-group ">
						<label>商品简介</label>
						<textarea id="mytxt" name="intro"
							style="width: 600px; height: 200px"></textarea>
						<script type="text/javascript">
							var ue = UM.getEditor('mytxt');
						</script>
					</div>
					<div class="form-group form-inline">
						<input type="submit" value="添加" class="btn btn-primary" /> <input
							type="reset" value="重置" class="btn btn-default" />
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>