$(document).ready(function() {
	toastr.options = {
			"closeButton": false,
			"debug": false,
			"newestOnTop": false,
			"progressBar": true,
			"positionClass": "toast-bottom-center",
			"preventDuplicates": false,
			"onclick": null,
			"showDuration": "300",
			"hideDuration": "1000",
			"timeOut": "5000",
			"extendedTimeOut": "1000",
			"showEasing": "swing",
			"hideEasing": "linear",
			"showMethod": "fadeIn",
			"hideMethod": "fadeOut"
	};
	toastr.success("Elemento eliminado con éxito");
	
	
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