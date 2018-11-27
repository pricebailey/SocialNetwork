$(function() {
	$('button').click(function(){
		var message = $('#message').val();
		var url = '/test'+message;
		
		$.get(url, function(data){
			console.log(data);
		})
	});
});
	