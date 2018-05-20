$(document).ready(function () {
    $('.btn.btn-default.footable-edit').click(function() {
    	$('#editor-modal').show();
    });
    
    
    
    /*FooTable*/
    jQuery(function($){
    	var $modal = $('#editor-modal'),
    		$editor = $('#editor'),
    		$editorTitle = $('#editor-title'),
    		ft = FooTable.init('#showcase-example-1', {
    			editing: {
    				addRow: function(){
    					$modal.removeData('row');
    					$editor[0].reset();
    					$editorTitle.text('Añadir un nuevo elemento');
    					$modal.modal('show');
    				},
    				editRow: function(row){
    					var values = row.val();
    					$editor.find('#id').val(values.id);
    					$editor.find('#firstName').val(values.firstName);
    					$editor.find('#lastName').val(values.lastName);
    					$editor.find('#jobTitle').val(values.jobTitle);
    					$editor.find('#status').val(values.status);
    					$editor.find('#startedOn').val(values.started.format('YYYY-MM-DD'));
    					$editor.find('#dob').val(values.dob.format('YYYY-MM-DD'));
    					$modal.data('row', row);
    					$editorTitle.text('Editar elemento #' + values.id);
    					$modal.modal('show');
    				},
    				deleteRow: function(row){
    					if (confirm('¿Está seguro de eliminar el elemento?')){
    						row.delete();
    					}
    				}
    			}
    		}),
    		uid = 10001;

    	$editor.on('submit', function(e){
    		if (this.checkValidity && !this.checkValidity()) return;
    		e.preventDefault();
    		var row = $modal.data('row'),
    			values = {
    				id: $editor.find('#id').val(),
    				firstName: $editor.find('#firstName').val(),
    				lastName: $editor.find('#lastName').val(),
    				jobTitle: $editor.find('#jobTitle').val(),
    				started: moment($editor.find('#startedOn').val(), 'YYYY-MM-DD'),
    				dob: moment($editor.find('#dob').val(), 'YYYY-MM-DD'),
    				status: $editor.find('#status option:selected').val()
    			};

    		if (row instanceof FooTable.Row){
    			row.val(values);
    		} else {
    			values.id = uid++;
    			ft.rows.add(values);
    		}
    		$modal.modal('hide');
    	});
    });
});