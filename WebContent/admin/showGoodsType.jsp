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
<!--../css/bootstrap.min.css  -->
<script src="http://localhost:8080/Shopping/js/jquery.min.js"></script>
<script src="http://localhost:8080/Shopping/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function judge(){
		var typelevel = document.getElementById("typelevel1").value;
		var re = /^\d+$/;
		if(re.test(typelevel)){
	    	document.form1.submit();
	    }else if(typelevel == ""){
			document.getElementById("typelevel1").value = "0";
	    	document.form1.submit();
	    }else{
	    	alert("商品类型水平必须是数字格式(1~5)");
	    }
	}
</script>

<title>商品分类</title>
</head>
<body>
	<div class="row" style="width: 98%; margin-left: 1%; height: 100px">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">商品类型</div>
				<div class="panel-body">
					<div class="row">
						<form id="form1" name="form1" method="get"
							action="http://localhost:8080/Shopping/GoodsTypeServlet">
							<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
								<div class="form-group form-inline">
									<span>商品类型等级</span> <input type="text" id="typelevel1"
										name="typelevel1" class="form-control"> <input
										type="hidden" name="word" value="b">
								</div>
							</div>
							<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
								<div class="form-group form-inline">
									<span>商品类型名称</span> <input type="text" name="typename1"
										class="form-control">
								</div>
							</div>
							<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
								<button onclick="judge()" type="button" class="btn btn-primary"
									id="search">
									<span class="glyphicon glyphicon-search">搜索</span>
								</button>
							</div>
						</form>
					</div>
					<div style="height: 400px; overflow: scroll;">
						<table id="tb_list"
							class="table table-striped table-hover table-bordered">
							<tr>
								<td>序号</td>
								<td>类型</td>
								<td>等级</td>
								<td>所属类型序号</td>
								<td>操作</td>
							</tr>
							<c:if test="${gtList != null}">
								<c:forEach items="${gtList }" var="goods">
									<tr>
										<td>${goods.id }</td>
										<td>${goods.name }</td>
										<td>${goods.level }</td>
										<td>${goods.parentid }</td>
										<td><a href="GoodsTypeServlet?typeid=${goods.id }&word=c">修改</a>&nbsp;&nbsp;
											<a href="GoodsTypeServlet?typeid=${goods.id }&word=e">删除</a>
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