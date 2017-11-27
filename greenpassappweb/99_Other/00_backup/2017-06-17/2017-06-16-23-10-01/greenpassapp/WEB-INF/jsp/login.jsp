<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta name="author" content="成都四方信息技术有限公司" />
	<meta name="keywords" content="农业基础信息化管理平台" />
	<meta name="description" content="农业基础信息化管理平台" />
	<title>协同办公系统 - 登录</title>
    <link rel="stylesheet" href="<s:url value="/static/skin/green/css/global.css?ver=20140102"/>">
    <link rel="stylesheet" href="<s:url value="/static/skin/green/css/login.css?ver=20140102"/>">
</head>
<body>
<div class="wrap">
    <div class="login-container">
        <div class="logo"></div>
        <div class="login-form">
            <div class="header">
                <span>用户登录</span>
                <i class="icon"></i>
            </div>
 <form action="<%=request.getContextPath()%>/j_security_check" method="post">
                <div class="form-item">
                    <label class="user" for="j_username">Account</label>
                    <input type="text" id="j_username" name="j_username" value="系统管理员" />
                </div>
                <div class="form-item">
                    <label class="password" for="j_password">Password</label>
                    <input type="password" id="j_password" name="j_password"  value="1"/>
                </div>
                <input type="submit" value="登 录" class="login-btn"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>
