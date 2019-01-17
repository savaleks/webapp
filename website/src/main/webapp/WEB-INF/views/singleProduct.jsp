<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div class="container">

	<div class="row">
	
		<div class="col-xs-12">
		
			<ol class="breadcrumb">
			
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>
			</ol>
		
		</div>
	
	</div>
	
	<div class="row">
	
		<div class="col-xs-12 col-sm-4">
		
			<div class="thumbnail">
				<img src="${images}/${product.code}.jpg" class="img img-responsive"/>
			</div>
		
		</div>
		
		<div class="col-xs-12 col-sm-8">
		
			<h4><b>${product.name}</b></h4>
			<hr/>
			<p><i>${product.description}</i></p>
			<hr/>
			<h5>Price: <strong>&#8364;${product.unitPrice}</strong></h5>
			<hr/>
			
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<h6>Qty.Available: <span style="color:red"><b>Out of Stock</b></span></h6>
				</c:when>
				<c:otherwise>
					<h6>Qty.Available: ${product.quantity}</h6>
				</c:otherwise>
			</c:choose>
			
			<security:authorize access="hasAuthority('USER')">
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<a href="javascript:void(0)" class="btn btn-success disabled">Add to Card</a>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/card/add/${product.id}/product" class="btn btn-success">Add to Card</a>
				</c:otherwise>
			</c:choose>
			</security:authorize>
			
			<security:authorize access="hasAuthority('ADMIN')">
				<a href="${contextRoot}/manage/${product.id}/product" class="btn btn-warning">Edit</a>
			</security:authorize>

			<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
		
		</div>
	
	</div>

</div>