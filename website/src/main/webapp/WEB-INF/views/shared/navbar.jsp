    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${contextRoot}/home">Online Store</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li id="about"><a href="${contextRoot}/about">About</a>
                    </li>
                    <li id="productList"><a href="${contextRoot}/show/all/products">View Products</a>
                    </li>
                    <li id="contact"><a href="${contextRoot}/contact">Contact</a>
                    </li>
                    <li id="manageProduct"><a href="${contextRoot}/manage/products">Manage Products</a>
                    </li>
                </ul>
                
                <ul class="nav navbar-nav navbar-right">
                	 <li id="manageProduct"><a href="${contextRoot}/login">Login</a>
                    </li>
                     <li id="manageProduct"><a href="${contextRoot}/register">Sign Up</a>
                    </li>
                    <li class="dropdown">
                    	<a href="javascript:void(0)" class="btn btn-default dropdown-toggle"
                    	id="dropdownMenu1" data-toggle="dropdown">${userModel.fullName} <span class="caret"></span></a>
                    	<ul class="dropdown-menu">
                    		<li>
                    			<a href="${contextRoot}/card">
                    				<span class="glyphicon glyphicon-shopping-cart"></span>
                    				<span class="badge">${userModel.card.cardLines}</span> &#8364; ${userModel.card.grandTotal}
                    			</a>
                    		</li>
                    		<li class="divider" role="separator"></li>
                    		<li><a href="${contextRoot}/logout">Logout</a></li>
                    	</ul>
                    </li>
                </ul>
                
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>