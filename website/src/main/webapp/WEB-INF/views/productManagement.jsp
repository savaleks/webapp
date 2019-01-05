<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">

	<div class="row">
	
		<c:if test="${not empty message}">
	
			<div class="col-md-offset-2 col-md-8">
			
				<div class="alert alert-warning alert-dismissible text-center">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h4><b>${message}</b></h4>
				</div>
			
			</div>
		
		</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-info">

				<div class="panel-heading">
					<h4 class="text-center">Product Management</h4>
				</div>

				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" 
							method="POST" enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Product Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" placeholder="Product name" class="form-control" /> 
								<sf:errors path="name" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter Product Brand: </label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand" placeholder="Product brand" class="form-control" /> 
								<sf:errors path="brand" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Enter Product Description: </label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4" placeholder="Write description" class="form-control"/> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter Product Price: </label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Product price in &#8364;" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Product Qty. Available: </label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity" placeholder="Enter number.." class="form-control" /> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select an Image: </label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" /> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select Category: </label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId" path="categoryId"
								items="${categories}"
								itemLabel="name"
								itemValue="id"/>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary" />
								<sf:hidden path="id"/>
								<sf:hidden path="code"/>
								<sf:hidden path="supplierId"/>
								<sf:hidden path="active"/>
								<sf:hidden path="purchases"/>
								<sf:hidden path="views"/>
							</div>
						</div>
					</sf:form>
				</div>

			</div>

		</div>

	</div>

</div>