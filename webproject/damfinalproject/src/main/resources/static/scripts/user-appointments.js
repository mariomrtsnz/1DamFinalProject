$(document).ready(function() {
	$(document).on('click', '.deleteButton', function() {
		$("#modal-container").show();
	});
	
	$("#cancel").click(function() {
		$("#modal-container").hide();
	});
	
    /*FooTable*/
	jQuery(function($){
		var ft = FooTable.init('#services-list', {}),
		uid = 10001;
	});
});