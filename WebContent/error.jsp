<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<title>错误页面</title>

<style type="text/css">
#main {
	font-size: 28px;
	color: red;
	position: absolute;
	width: 50%;
	height: 50%;
	left: 50%;
	top: 50%;
	margin-left: -100px;
	margin-top: -50px;
}
</style>
</head>
<body>
	<div id="main" class="panel panel-primary">
		操作失败!请<a href="javascript:history.go(-1)">返回</a>重试!
	</div>
</body>
</html>
