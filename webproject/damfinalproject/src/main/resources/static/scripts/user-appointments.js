$(document).ready(function () {
	$("#deleteButton").click(function() {
		$("#deleteModal").show();
		$("#modal-overlay").show();
	});
	
	$("#cancel").click(function() {
		$("#deleteModal").hide();
		$("#modal-overlay").hide();
	});
	
    /*FooTable*/
	jQuery(function($){
		var ft = FooTable.init('#services-list', {}),
		uid = 10001;
	});
});