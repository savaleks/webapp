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
	default: 
		$('#productList').addClass('active');
		$('a_' + menu).addClass('active');
		break;
	}
});
