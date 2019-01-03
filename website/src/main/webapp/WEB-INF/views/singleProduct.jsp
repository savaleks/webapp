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
			<h6>Qty.Available: ${product.quantity}</h6>
			
			<a href="${contextRoot}/card/add/${productId}/product" class="btn btn-success">Add to Card</a>
			<a href="${contextRoot}/show/all/product" class="btn btn-primary">Back</a>
		
		</div>
	
	</div>

</div>