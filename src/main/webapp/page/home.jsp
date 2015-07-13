<%@ page import="com.alibaba.monitor.mavenWeb.pojos.*" language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" ng-app="paibanApp">
<head>
<meta charset="UTF-8" />
<title>阿里排班系统</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="dist/paiban.css" />

</head>
<%!
	User user;
%>
<% 
	user=(User)session.getAttribute("user");
%>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">阿里排班系统</a>
			</div>

			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav" id="nav">
					<li class="active"><a href="#/">Home</a></li>
					<li><a href="#/about">About</a></li>
					<li><a href="#/">Contact</a></li>
				</ul>
				<!--            <div th:with="currentUser=${#httpServletRequest.userPrincipal?.principal}">
                            <form class="navbar-form navbar-right"
                                  th:if="${currentUser != null}" th:action="@{/logout}" method="post">
                                <button type="submit" class="btn btn-success">Logout</button>
                            <span type="text" class="btn btn-primary"
                                  th:text="${currentUser?.email} + ' ' + ${currentUser?.nickname}">Sample user</span>
                            </form>
                        </div>-->
				<div class="navbar-form navbar-right">
	                
					<span type="text" class="btn btn-primary"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;
	            	<%
	            		if(user==null) out.print("<a href='login.html' style=\"color:#f00\">请登录</a>");
	            		else out.print(user.getUsername());
	            	%>
                </span>
                <span type="text" class="btn btn-success"><a href="logout.html" style="color:#fff"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp;退出</a></span>
				</div>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container-fluid">
		<div class='row'>
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar" id="navLink">
					<li class="active"><a href="#/employee/"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;人员管理</a></li>
					<li><a href="#/department"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;部门管理</a></li>
					<li><a href="#/shiftcfg"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>&nbsp;排班管理</a></li>
					<li><a href="#/shift/0/0"><span class="glyphicon glyphicon-th" aria-hidden="true"></span>&nbsp;班次管理</a></li>
					<li><a href="#/stat/0"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>&nbsp;班次统计</a></li>
					<li><a href="#/search"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;日期检索</a></li>
				</ul>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"
				ng-view="myview"></div>

		</div>
	</div>
	<!-- /.container -->


	<script src="dist/lib/jquery-2.1.4.min.js"></script>
	<script src="dist/lib/bootstrap.min.js"></script>
	<script src="dist/lib/bootstrap-datepicker.min.js"></script>


	<script src="dist/lib/angular.min.js"></script>
	<script src="dist/lib/angular-animate.min.js"></script>
	<script src="dist/lib/angular-sanitize.min.js"></script>
	<script src="dist/lib/angular-route.min.js"></script>
	<script src="dist/lib/angular-resource.min.js"></script>


	<script lang="javascript" src="dist/lib/xlsx.core.min.js"></script>
	<script lang="javascript" src="sheetjs/Blob.js"></script>
	<script lang="javascript" src="sheetjs/FileSaver.js"></script>
	<script lang="javascript" src="sheetjs/Export2Excel.js"></script>

	<script src="dist/app.js"></script>
	<script src="dist/services.js"></script>
	<script src="dist/empl-ctrl.js"></script>
	<script src="dist/dept-ctrl.js"></script>
	<script src="dist/shift-ctrl.js"></script>
	<script src="dist/shiftcfg-ctrl.js"></script>
	<script src="dist/stat-ctrl.js"></script>
	<script src="dist/search-ctrl.js"></script>

	<!-- <script src="readerjs/filters.js"></script>
<script src="readerjs/animations.js"></script> -->
</body>
</html>