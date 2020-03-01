<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">

<%@ include file="/view/layout/header.jsp"%>

<body id="login_bg">
	
	<nav id="menu" class="fake_menu"></nav>
	
	<div id="preloader">
		<div data-loader="circle-side"></div>
	</div>
	<!-- End Preload -->
	
	<div id="login">
		<aside>
			<figure>
				<a href="${pageContext.request.contextPath}/">
				<img src="${pageContext.request.contextPath}/resources/img/logo.png" width="149" height="42" data-retina="true" alt=""></a>
			</figure>
			  <form:form method="post" action="${pageContext.request.contextPath}/login" name="form">
				<div class="form-group">
					<span class="input">
					<input class="input_field" type="text" autocomplete="off" name="username" required="required">
						<label class="input_label">
						<span class="input__label-content">Your email</span>
					</label>
					</span>
					<span class="input">
					<input class="input_field" type="password" name="password" required="required">
						<label class="input_label">
						<span class="input__label-content">Your password</span>
					</label>
					</span>
					<span class="input">
						<input id="checkbox-signup" type="checkbox" name="remember-me" value="true">
						<label for="checkbox-signup">remember me</label>
					</span>					
					<small><a href="#0">Forgot password?</a></small>
				</div>
				<button type="submit" class="btn_1 rounded full-width add_top_60">Log
					in</button>
				<div class="text-center add_top_10">New to Udema? <strong><a href="register.html">Sign up!</a></strong></div>
			</form:form>
			<div class="copy">© 2017 Udema</div>
		</aside>
	</div>
	<!-- /login -->
		
	<!-- COMMON SCRIPTS -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/common_scripts.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
   
</body>
</html>