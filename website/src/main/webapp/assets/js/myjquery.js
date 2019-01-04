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
	default: 
		if(menu == "Home") break;
		$('#productList').addClass('active');
		$('a_' + menu).addClass('active');
		break;
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
						
						if(row.quantity<1){
							str += '<a href="javascript:void(0)" class="btn btn-success disabled">Add to Card</a>';
						} else {
							str += '<a href="'+window.contextRoot+'/card/add/'+data+'/product" class="btn btn-success">Add to Card</a>';
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
	
	
	
});
