<%@include file="../shared/flows-header.jsp" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">
			<div class="row">
				<div class="col-md-6 text-center">
				<h3>Billing form</h3>
				<br>
				
				<sf:form method="POST" class="form-horizontal" id="billingForm" modelAttribute="billing">
						
						<div class="form-group">
							<label for="name" class="col-md-4 control-label">Street Name</label>
							<div class="col-md-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
									<sf:input type="text" class="form-control" path="addressLine" id="addressLine"  placeholder="Enter Street Name"/>
								</div>
									<sf:errors path="addressLine" style="color:red;" cssClass="help-block" element="em"/>
							</div>
						</div>
				
						<div class="form-group">
							<label for="username" class="col-md-4 control-label">Street Nr.</label>
							<div class="col-md-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
									<sf:input type="text" class="form-control" path="addressNumber" id="addressNumber"  placeholder="Enter Street Nr"/>
								</div>
									<sf:errors path="addressNumber" style="color:red;" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="col-md-4 control-label">City</label>
							<div class="col-md-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
									<sf:input type="text" class="form-control" path="city" id="city"  placeholder="Enter City"/>
								</div>
									<sf:errors path="city" style="color:red;" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="email" class="col-md-4 control-label">State</label>
							<div class="col-md-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
									<sf:input type="text" class="form-control" path="state" id="state"  placeholder="Enter State"/>
								</div>
									<sf:errors path="state" style="color:red;" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-md-4 control-label">Country</label>
							<div class="col-md-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
									<sf:input type="text" class="form-control" path="country" id="country"  placeholder="Enter Country"/>
								</div>
									<sf:errors path="country" style="color:red;" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="col-md-4 control-label">Postal Code</label>
							<div class="col-md-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
									<sf:input type="text" class="form-control" path="postalCode" id="postalCode"  placeholder="Enter Postal Code"/>
								</div>
									<sf:errors path="postalCode" style="color:red;" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group ">
							<button type="submit" class="btn btn-primary btn-md" name="_eventId_personal">
								<span class="button-group-addon"><i class="glyphicon glyphicon-chevron-left"></i></span> Personal - Previuos
							</button>
							<button type="submit" class="btn btn-primary btn-md" name="_eventId_confirm">
								 Next - Confirm <span class="button-group-addon"><i class="glyphicon glyphicon-chevron-right"></i></span> 
							</button>
						</div>
						
					</sf:form>
				</div>
			</div>
		</div>

<%@include file="../shared/flows-footer.jsp" %>