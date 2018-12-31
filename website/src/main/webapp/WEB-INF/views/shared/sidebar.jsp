<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p class="lead">Shop Name</p>
<div class="list-group">

	<c:forEach items="${category}" var="product">
	<a href="#" class="list-group-item active">${product.name}</a> 	
	</c:forEach>

</div>