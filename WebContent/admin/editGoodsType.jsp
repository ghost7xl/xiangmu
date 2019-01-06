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
<script src="http://localhost:8080/Shopping/js/jquery.min.js"></script>
<script src="http://localhost:8080/Shopping/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="http://localhost:8080/Shopping/js/jquery-1.9.1.js"></script>
<title>Insert title here</title>
<script>
	$(function(){
		$.ajax({
			type:"get",
			dataType:"json",
			url:"GoodsServlet",
			success:function(data){
				var gtList = data.gtList;
				for(var i = 0; i < gtList.length;i++){
					var option = "<option value='"+gtList[i].id+"'>"+gtList[i].name+"</option>";
					$("#type").append(option);
				}
			}
		});
	})
</script>
</head>
<body>
	<div class="row" style="width: 98%; margin-left: 1%; height: 100px">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">商品类型修改</div>
				<div class="panel-body">
					<div style="height: 400px; overflow: scroll;">
						<form action="GoodsTypeServlet" method="get">
							<table id="tb_list"
								class="table table-striped table-hover table-bordered">
								<tr>
									<td>序号</td>
									<td>类型</td>
									<td>等级</td>
									<td>所属类型序号</td>
									<td>操作</td>
								</tr>
								<c:if test="${gts != null }">
									<tr>
										<!--
							 	<input style="height:30px;width:50px" disabled="disabled" type="text" value="${gts.id }" name="typeid">
							  -->
										<td style="height: 50px;">${gts.id }<input type="hidden"
											value="${gts.id }" name="typeid">
										</td>
										<td><input type="text" style="height: 30px; width: 150px"
											value="${gts.name }" name="typename"></td>
										<td><input type="text" style="height: 30px; width: 150px"
											value="${gts.level }" name="typelevel"></td>
										<td>
											<div class="form-group form-inline">
												<select id="type" name="typeparentid" class="form-control">
													<option value="0">---请修改商品类型---</option>
												</select> <input type="hidden" name="word" value="d">
											</div>
										</td>
										<td>
											<!--
									 	typename=${goods.name }&typelevel=${goods.level }&typeparentid=${goods.parentid }
									  --> <%-- <a href="GoodsTypeServlet?typename=${gts.name }&typelevel=${gts.level }&typeparentid=${gts.parentid }&word=d">修改</a>&nbsp;&nbsp; --%>
											<input type="submit" value="修改">
										</td>
									</tr>
								</c:if>
							</table>
						</form>
						<center>
							<a href="GoodsTypeServlet?word=a"><h3>返回</h3></a>
						</center>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>