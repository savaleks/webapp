$(function(){
	
	// Active menu config
	
	switch(menu){
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All products':
		$('#productList').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProduct').addClass('active');
		break;
	case 'User card':
		$('#userCard').addClass('active');
		break;
	default: 
		if(menu == "Home") break;
		$('#productList').addClass('active');
		$('a_' + menu).addClass('active');
		break;
	}
	
	// csrf token
	
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	if(token.length>0&&header.length>0){
		$(document).ajaxSend(function(e, xhr, options){
			xhr.setRequestHeader(header,token);
		});
	}
	
	// code for dataTable

	var $table = $('#productListTable');
	
	if($table.length){
		
		var jsonUrl = '';
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'+window.categoryId+'/products';
		}
		
		$table.DataTable({
			lengthMenu: [[3, 5, 10, -1],['3 Item', '5 Item', '10 Item', 'All']],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'code',
					mRender: function(data, type, row){
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg" style="width:100px;height:100px;"/>'
					}
				},
				{
					data: 'name'
				},
				{
					data: 'brand'
				},
				{
					data: 'unitPrice',
					mRender: function(data, type, row){
						return '&#8364;' + data
					}
				},
				{
					data: 'quantity',
					mRender: function(data, type, row){
						if(data<1){
							return '<span style="color:red">Out of Stock</span>';
						}
						return data;
					}
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data, type, row){
						var str = '';
						str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary">View</a> &#160;';
						if(userRole == 'ADMIN'){
							str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">Edit</a>';																		
						} else {
								
							if(row.quantity<1){
								str += '<a href="javascript:void(0)" class="btn btn-success disabled">Add to Card</a>';
							} else {							
									str += '<a href="'+window.contextRoot+'/card/add/'+data+'/product" class="btn btn-success">Add to Card</a>';															
							}
						}
						return str;
					}
				}
			]
		});
	}
	
	// alert settings
	var $alert = $('.alert');
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow');
		},3000)
	}
	
	// switch slider
	
	$('.switch input[type="checkbox"]').on('change', function(){
		var checkbox = $(this);
		var checked = checkbox.prop('checked');
		var dMsg = (checked)?'You want activate Product?':'You want deactivate Product?';
		var value = checkbox.prop('value');
		
		bootbox.confirm({
			size: 'medium',
			title: 'Product ON/OFF',
			message: dMsg,
			callback: function(confirmed){
				if(confirmed){
					console.log(value);
					bootbox.alert({
						size: 'medium',
						title: 'Information',
						message: 'You want perform operation on Product ' + value
					});
				} else {
					checkbox.prop('checked', !checked);
				}
			}
		});
		
	});
	
	// DataTable for admin
	
var $adminProductsTable = $('#adminProductsTable');
	
	if($adminProductsTable.length){
		
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		
		$adminProductsTable.DataTable({
			lengthMenu: [[3, 5, 10, -1],['3', '5', '10', 'All']],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'id'
				},
				{
					data: 'code',
					mRender: function(data, type, row){
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg" style="width:50px;height:50px;"/>'
					}
				},
				{
					data: 'name'
				},
				{
					data: 'brand'
				},
				{
					data: 'quantity',
					mRender: function(data, type, row){
						if(data<1){
							return '<span style="color:red">Out of Stock</span>';
						}
						return data;
					}
				},
				{
					data: 'unitPrice',
					mRender: function(data, type, row){
						return '&#8364;' + data
					}
				},
				{
					data: 'active',
					mRender: function(data,type,row){
						var str = '';
						str += '<label class="switch">';
						if(data){
							str += '<input type="checkbox" checked="checked" value="'+row.id+'"/><span class="slider"></span></label>';
						} else {
							str += '<input type="checkbox" value="'+row.id+'"/><span class="slider"></span></label>';
						}
						return str;
					}
					
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data,type,row){
						var str = '';
						str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">Edit</a>';
						return str;
					}
				}
			],
			
			initComplete: function(){
				var api = this.api();
				api.$('.switch input[type="checkbox"]').on('change', function(){
					var checkbox = $(this);
					var checked = checkbox.prop('checked');
					var dMsg = (checked)?'You want activate Product?':'You want deactivate Product?';
					var value = checkbox.prop('value');
					
					bootbox.confirm({
						size: 'medium',
						title: 'Product ON/OFF',
						message: dMsg,
						callback: function(confirmed){
							if(confirmed){
								console.log(value);
								
								var activationUrl = window.contextRoot + '/manage/product/' + value + '/activation';
								$.post(activationUrl, function(data){
									bootbox.alert({
										size: 'medium',
										title: 'Information',
										message: data
									});
								});
								
							} else {
								checkbox.prop('checked', !checked);
							}
						}
					});
					
				});
			}
		});
	}
	//*******************
	// validation
	
	var $categoryForm = $('#categoryForm');
	if($categoryForm.length){
		$categoryForm.validate({
			rules: {
				name: {
					required: true,
					minlength: 2
				},
				description: {
					required: true
				}
			},
			
			messages: {
				name: {
					required: 'Please enter category Name',
					minlength: 'The category name must be not less than 2 symbols'
				},
				description: {
					required: 'Please enter description',
				}
			},
			errorElement: 'em',
			errorPlacement: function(error, element){
				error.addClass('help-block');
				error.insertAfter(element);
			}
		});
	}
	
	//********************
	
	var $loginForm = $('#loginForm');
	if($loginForm.length){
		$loginForm.validate({
			rules: {
				username: {
					required: true,
					email: true
				},
				password: {
					required: true
				}
			},
			
			messages: {
				username: {
					required: 'Please enter Email',
					email: 'Enter valid email address'
				},
				password: {
					required: 'Please enter password',
				}
			},
			errorElement: 'em',
			errorPlacement: function(error, element){
				error.addClass('help-block');
				error.insertAfter(element);
			}
		});
	}
	
	// refresh card
	$('button[name="refreshCard"]').click(function(){
		var cardLineId = $(this).attr('value');
		var countElement = $('#count_' + cardLineId);
		
		var originalCount = countElement.attr('value');
		var currentCount = countElement.val();
		
		if(currentCount !== originalCount){
			if(currentCount < 1 || currentCount > 3){
				countElement.val(originalCount);
				bootbox.alert({
					size: 'medium',
					title: 'Error',
					message: 'Product count should be from 1 to 3'
				});
			} else {
				var updateUrl = window.contextRoot + '/card/' + cardLineId + '/update?count=' + currentCount;
				window.location.href = updateUrl;
			}
		}
		
	});

	
});
