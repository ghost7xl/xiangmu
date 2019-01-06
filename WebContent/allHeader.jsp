<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/login2.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="top">
		<div id="topdiv">
			<span> <a href="http://localhost:8080/Shopping/index.jsp"
				id="a_top">商城主页</a>
			</span> <span style="float: right"> <c:if test="${adminname==null}">
					<a href="admin/login.jsp" id="a_top">管理员登录</a>
					<li>|</li>
				</c:if> <c:if test="${adminname!=null}">
					<a href="http://localhost:8080/Shopping/admin/admin.jsp" id="a_top"
						style="color: red;">${adminname}</a>
					<li>|</li>
				</c:if> <c:if test="${user.username==null}">
					<a href="http://localhost:8080/Shopping/login.jsp" id="a_top">用户登录</a>
					<li>|</li>
				</c:if> <c:if test="${user.username!=null}">
					<a href="http://localhost:8080/Shopping/self_index.jsp" id="a_top"
						style="color: red;">${user.username}</a>
				</c:if> <c:if test="${user.username!=null||adminname!=null}">
					<li>|</li>
					<a href="http://localhost:8080/Shopping/LogoutServlet" id="a_top">注销</a>
				</c:if> <c:if test="${user.username!=null}">
					<a href="http://localhost:8080/Shopping/CartServlet?method=found"
						id="shorpcar">购物车</a>
				</c:if>
			</span>
		</div>
	</div>
</body>
</html>