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
								<sf:errors path="name" style="color:red;" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter Product Brand: </label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand" placeholder="Product brand" class="form-control" /> 
								<sf:errors path="brand" style="color:red;" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Enter Product Description: </label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4" placeholder="Write description" class="form-control"/> 
								<sf:errors path="description" style="color:red;" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter Product Price: </label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Product price in &#8364;" class="form-control" />
								<sf:errors path="unitPrice" style="color:red;" cssClass="help-block" element="em"/> 
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
								<sf:errors path="file" style="color:red;" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select Category: </label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId" path="categoryId"
								items="${categories}"
								itemLabel="name"
								itemValue="id"/>
								<c:if test="${product.id == 0}">
									<div class="text-right">
										<br/>
										<button type="button" data-toggle="modal" data-target="#categoryModal"
										class="btn btn-xs btn-success">Add Category</button>
									</div>									
								</c:if>
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

	<div class="row">
	
		<div class="col-xs-12">
		
			<h4>Available Products</h4>
			<hr/>
		
		</div>
		
		<div class="col-xs-12">
		
			<div style="overflow:auto">
			
				<table id="adminProductsTable" class="table table-striped table-bordered">
				
					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>
					
					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				
				</table>
			
			</div>
		
		</div>
	
	</div>

	<div class="modal fade" id="categoryModal" role="dialog" tabindex="-1">
	
		<div class="modal-dialog" role="document">
		
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add New Category</h4>
				</div>
				<div class="modal-body">
					<sf:form modelAttribute="category" action="${contextRoot}/manage/category" method="POST" class="form-horizontal">
						<div class="form-group">
							<label for="category_name" class="control-label col-md-4">Category Name: </label>
							<div class="col-md-8">
								<sf:input path="name" type="text" id="category_name" class="form-control"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="category_description" class="control-label col-md-4">Category Description: </label>
							<div class="col-md-8">
								<sf:textarea cols="" rows="4" path="description" type="text" id="category_description" class="form-control"/>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category" class="btn btn-primary"/>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		
		</div>
	
	</div>

</div>