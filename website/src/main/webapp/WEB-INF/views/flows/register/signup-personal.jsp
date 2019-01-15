<%@include file="../shared/flows-header.jsp" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">
			<div class="row">
				<div class="col-md-6 text-center">
				<h3>Sign up form</h3>
				<br>
				
				<sf:form method="POST" class="form-horizontal" id="registerForm" modelAttribute="user">
						
						<div class="form-group">
							<label for="name" class="col-md-4 control-label">First Name</label>
							<div class="col-md-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
									<sf:input type="text" class="form-control" path="firstName" id="firstName"  placeholder="Enter your First Name"/>
									<sf:errors path="firstName" cssClass="help-block" element="em"/>
								</div>
							</div>
						</div>
				
						<div class="form-group">
							<label for="username" class="col-md-4 control-label">Last Name</label>
							<div class="col-md-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
									<sf:input type="text" class="form-control" path="lastName" id="lastName"  placeholder="Enter your Last Name"/>
									<sf:errors path="lastName" cssClass="help-block" element="em"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="col-md-4 control-label">Your Email</label>
							<div class="col-md-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
									<sf:input type="text" class="form-control" path="email" id="email"  placeholder="Enter your Email"/>
									<sf:errors path="email" cssClass="help-block" element="em"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="email" class="col-md-4 control-label">Contact Number</label>
							<div class="col-md-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
									<sf:input type="text" class="form-control" path="contactNumber" id="contactNumber"  placeholder="Enter your Phone Number"/>
									<sf:errors path="contactNumber" cssClass="help-block" element="em"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-md-4 control-label">Password</label>
							<div class="col-md-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-ok"></i></span>
									<sf:input type="password" class="form-control" path="password" id="password"  placeholder="Enter your Password"/>
									<sf:errors path="password" cssClass="help-block" element="em"/>
								</div>
							</div>
						</div>

<%-- 						<div class="form-group">
							<label for="confirm" class="col-md-4 control-label">Confirm Password</label>
							<div class="col-md-8">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
									<sf:input type="password" class="form-control" path="confirmPassword" id="confirmPassword"  placeholder="Confirm your Password"/>
									<sf:errors path="confirmPassword" cssClass="help-block" element="em"/>
								</div>
							</div>
						</div> --%>
						
						<div class="form-group">
							<label class="col-md-4 control-label">Select Role</label>
							<div class="col-md-8">
								<label class="radio-inline">
									<sf:radiobutton path="role" value="USER" checked="checked"/> USER
								</label>
								<label class="radio-inline">
									<sf:radiobutton path="role" value="SUPPLIER"/> SUPPLIER
								</label>
							</div>
						</div>

						<div class="form-group ">
							<button type="submit" class="btn btn-primary" name="_eventId_billing">
								Next - Billing <span class="button-group-addon"><i class="glyphicon glyphicon-chevron-right"></i></span>
							</button>
						</div>
						
					</sf:form>
				</div>
			</div>
		</div>

<%@include file="../shared/flows-footer.jsp" %>
		
