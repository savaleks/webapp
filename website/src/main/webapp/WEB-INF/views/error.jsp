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

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

			<div class="container">

				<div class="navbar-header">

					<a class="navbar-brand" href="${contextRoot}/home">Back Home</a>

				</div>

			</div>

		</nav>

		<div class="content">

			<div class="container">

				<div class="row">

					<div class="col-xs-12">
						<div class="jumbotron jumbotron-fluid">
							<div class="container">
								<h2 class="display-4"><b>${errorTitle}</b></h2>
								<hr/>
								<p class="lead">${errorDescription}</p>
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
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/dataTables.bootstrap.js"></script>

	</div>

</body>

</html>
