<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/login2.css">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>个人中心-收货地址页面</title>
<script type="text/javascript">
        $(function () {
            //初始化省份
            $.ajax({
                type: "get",
                dataType: "json",
                url: "AddressServlet",
                success: function (data) {
                    var pList = data.pList;
                    for (var i = 0; i < pList.length; i++) {
                        var option = "<option value='" + pList[i].id + "'>"
                            + pList[i].name + "</option>";
                        $("#province").append(option);
                    }
                }
            });
            //选择省后获取市列表
            $("#province")
                .change(
                    function () {
                        var pid = $(this).val();
                        $(".city").remove();
                        $
                            .ajax({
                                type: "get",
                                dataType: "json",
                                data: {
                                    "pid": pid,
                                    "method": "city"
                                },
                                url: "AddressServlet",
                                success: function (data) {
                                    var cityList = data.cityList;
                                    for (var i = 0; i < cityList.length; i++) {
                                        var option = "<option class='city' value='" + cityList[i].id + "'>"
                                            + cityList[i].name
                                            + "</option>";
                                        $("#city").append(option);
                                    }
                                }
                            });
                    })
            //选择市后获取县列表
            $("#city")
                .change(
                    function () {
                        var cid = $(this).val();
                        $(".county").remove();
                        $
                            .ajax({
                                type: "get",
                                dataType: "json",
                                data: {
                                    "cid": cid,
                                    "method": "county"
                                },
                                url: "AddressServlet",
                                success: function (data) {
                                    var countyList = data.countyList;
                                    for (var i = 0; i < countyList.length; i++) {
                                        var option = "<option class='county' value='" + countyList[i].id + "'>"
                                            + countyList[i].name
                                            + "</option>";
                                        $("#county").append(option);
                                    }
                                }
                            });
                    })
        });
    </script>
</head>
<body>
	<!--网站中间内容开始-->
	<div class="row" style="width: 98%; margin-left: 1%; margin-top: 5px;">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="panel panel-default">
				<div style="margin: 0 20px;">
					<h3>收货地址</h3>
					<hr>
					<table class="table table-striped table-hover table-bordered">
						<tr>
							<th>序号</th>
							<th>收件人</th>
							<th>手机号</th>
							<th>地址</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${userAdList}" var="u">
							<form action="UserAddressServlet" method="get">
								<input type="hidden" name="method" value="update"> <input
									type="hidden" name="pid" value="${u.pid }"> <input
									type="hidden" name="cityid" value="${u.cityid }"> <input
									type="hidden" name="countyid" value="${u.countyid }"> <input
									type="hidden" name="uid" value="${u.uid }"> <input
									type="hidden" name="flag" value="${u.flag }">
								<tr>
									<td><input style="width: 50px;" class="form-control"
										type="text" name="id" value="${u.id}" /></td>
									<td><input style="width: 100px;" class="form-control"
										type="text" name="name" value="${u.name}" /></td>
									<td><input style="width: 150px;" class="form-control"
										type="text" name="phone" value="${u.phone}" /></td>
									<td><input class="form-control" type="text" name="detail"
										value="${u.detail}" /></td>
									<td>
										<button style="color: #fff;">
											<a href="UserAddressServlet?method=delete&id=${u.id }">删除</a>
										</button>&nbsp;&nbsp; <input style="height: 23px; width: 40px;"
										type="submit" value="修改" />
									</td>
								</tr>
							</form>
						</c:forEach>
					</table>
				</div>
				<hr />
				<div class="container" style="width: 960px;">
					<form action="UserAddressServlet" method="get"
						class="form-horizontal">
						<div class="form-group">
							<input type="hidden" name="uid" value="${user.id}" /> <label
								class="col-sm-2 form-label">收件人</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" name="name" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 form-label">手机号</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" name="phone" />
							</div>
						</div>
						<div class="form-group">
							<label class="form-label">地址</label> <br /> <select id="province"
								name="province">
								<option value="0">--选择省份--</option>
							</select> <select id="city" name="city">
								<option value="0">--选择市--</option>
							</select> <select id="county" name="county">
								<option value="0">--选择县区--</option>
							</select>
						</div>
						<div class="form-group">
							<label class="form-label">详细地址</label>
							<textarea rows="1" style="width: 600px;" class="form-control"
								name="detail"></textarea>
						</div>
						<div class="form-group col-md-12" style="width: 80px;">
							<input type="submit" style="height: 30px"
								class="btn btn-primary btn-xs" value="添加地址">
						</div>
						<input type="hidden" value="add" name="method" />
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>