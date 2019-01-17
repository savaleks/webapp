<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<!-- HEADER -->
<%@include file="./shared/header.jsp"%>

<body>

	<div class="wrapper">

		<!-- NAVIGATION -->
		
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Online Store</a>
				</div>
			</div>
		</nav>

		<!-- PAGE CONTENT -->

		<div class="content">
			<div class="container">
			<c:if test="${not empty message}">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div class="alert alert-danger">${message}</div>	
					</div>
				</div>
			</c:if>
			
			<c:if test="${not empty logout}">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div class="alert alert-default">${logout}</div>	
					</div>
				</div>
			</c:if>
			
			    <div class="row">
					<div class="col-md-4 col-md-offset-4">
			    		<div class="panel panel-default">
						  	<div class="panel-heading">
						    	<h3 class="panel-title">Please sign in</h3>
						 	</div>
						  	<div class="panel-body">
						    	<form action="${contextRoot}/login" method="POST" id="loginForm">
			                    <fieldset>
						    	  	<div class="form-group">
						    		    <input class="form-control" id="username" placeholder="E-mail" name="username" type="text">
						    		</div>
						    		<div class="form-group">
						    			<input class="form-control" id="password" placeholder="Password" name="password" type="password" value="">
						    		</div>
						    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
						    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						    	</fieldset>
						      	</form>
						    </div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- FOOTER -->
		<%@include file="./shared/footer.jsp"%>


		<!-- JavaScript -->
		<script src="${js}/jquery-1.10.2.js"></script>
		<script src="${js}/bootstrap.js"></script>
		<!-- My javascript -->
		<script src="${js}/myjquery.js"></script>
		<script src="${js}/jquery.validate.js"></script>
		

	</div>

</body>

</html>
