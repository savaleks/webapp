<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">

	<c:if test="${not empty message}">
		<div class="alert alert-info">
			<h4 class="text-center">${message}</h4>
		</div>
	</c:if>

	<c:choose>
	
		<c:when test="${not empty cardLines}">
			<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach items="${cardLines}" var="cardLine">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="${images}/${cardLine.product.code}.jpg" alt="${cardLine.product.name}" class="img-responsive cardImg"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${cardLine.product.name}
											<c:if test="${cardLine.available == false}">
												<strong class="unavailable">(Not Available)</strong>
											</c:if>
										</h4>
										<p>Brand - ${cardLine.product.brand}</p>
										<p>Description - ${cardLine.product.description}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">&#8364; ${cardLine.buyingPrice}</td>
							<td data-th="Quantity">
								<input type="number" id="count_${cardLine.id}" min="1" max="3" class="form-control text-center" value="${cardLine.productCount}">
							</td>
							<td data-th="Subtotal" class="text-center">&#8364; ${cardLine.total}</td>
							<td class="actions" data-th="">
								<button type="button" name="refreshCard" value="${cardLine.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-refresh"></span></button>
								<a href="${contextRoot}/card/${cardLine.id}/delete" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span></a>								
							</td>
						</tr>
					</c:forEach>
					
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total &#8364; ${userModel.card.grandTotal}</strong></td>
						</tr>
						<tr>
							<td><a href="${contextRoot}/show/all/products" class="btn btn-warning"><span class="glyphicon glyphicon-angle-left"></span> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total &#8364; ${userModel.card.grandTotal}</strong></td>
							<td><a href="#" class="btn btn-success btn-block">Checkout <span class="glyphicon glyphicon-chevron-right"></span></a></td>
						</tr>
					</tfoot>
				</table>
		</c:when>
		
		<c:otherwise>
			<div class="jumbotron">
				<div class="text-center">
					<h3>Your card is empty</h3>
				</div>
			</div>
		</c:otherwise>
	
	</c:choose>
</div>