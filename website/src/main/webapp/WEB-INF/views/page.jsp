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
		<%@include file="./shared/navbar.jsp"%>

		<!-- PAGE CONTENT -->

		<div class="content">

			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="productList.jsp"%>
			</c:if>

		</div>

		<!-- FOOTER -->
		<%@include file="./shared/footer.jsp"%>


		<!-- JavaScript -->
		<script src="${js}/jquery-1.10.2.js"></script>
		<script src="${js}/bootstrap.js"></script>
		<!-- My javascript -->
		<script src="${js}/myjquery.js"></script>

	</div>

</body>

</html>
