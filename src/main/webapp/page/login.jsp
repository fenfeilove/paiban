<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>排班</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"/>
    <link href="dist/paiban.css" rel="stylesheet"/>
</head>
<body style="font-family:微软雅黑;padding-top:50px;">
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="margin-bottom:0px;">
	    <div class="container">
	        <div class="navbar-header">
	            <button type="button" class="navbar-toggle" data-toggle="collapse"
	                    data-target=".navbar-collapse">
	                <span class="sr-only">Toggle navigation</span> <span
	                    class="icon-bar"></span> <span class="icon-bar"></span> <span
	                    class="icon-bar"></span>
	            </button>
	            <a class="navbar-brand" href="#">排班系统</a>
	        </div>
	
	        <div class="navbar-collapse collapse">
	            <ul class="nav navbar-nav">
	                <li class="active"><a href="home">Home</a></li>
	            </ul>
	        </div>
	        <!--/.nav-collapse -->
	    </div>
	</div>
<div style="width:1500px;height:600px;background:url('dist/login.jpg') no-repeat;" class="img-responsive" alt="Responsive image">
<div class="col-md-3" style="margin-left:850px; margin-top:100px;margin-bottom:30px; background-color:#000000;opacity: 0.7 ;padding-right:0px;padding-left:0px;"  >
  		
  		<div class="panel panel-primary" style="background-color:#000000;border-color:#000">
			  <div class="panel-heading" style="background-color:#000000;border-color:#000;font-size:16px;border-bottom:1px solid #bbb;"> 
			  		<span class="glyphicon glyphicon-user" aria-hidden="true"></span> 
			 		 登录
			  </div>
			  <div class="panel-body">
	            <form class="form-signin" role="form" action="login.html" method="post">
	                <h2 class="form-signin-heading"></h2>
	                <span>${result}</span>
	                <label for="inputEmail" class="sr-only" >用户名</label>
	                <input name="username" type="text" id="inputEmail" class="form-control" placeholder="用户名"
	                       required="true" autofocus="true" />
	                <br/>
	                <label for="inputPassword" class="sr-only">Password</label>
	                <input name="password" type="password" id="inputPassword" class="form-control" placeholder="密码"
	                       required="true" />
	                <!--<div class="checkbox">-->
	                <!--<label>-->
	                <!--<input type="checkbox" value="remember-me"> Remember me-->
	                <!--</label>-->
	                <!--</div>-->
	                <br/>
	                <input class="btn btn-lg btn-primary btn-block" type="submit"value="登录" style="width:100%;line-height:1;"/>
	            </form>
	            <!--<a href="/signup">
	                <button class="btn btn-lg btn-success btn-block">Sign up</button>
	            </a>-->
	        </div>
    	</div>

</div>	  

</body>
</html>