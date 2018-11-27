$(document).ready(function(){
	$("#registerSubmit").click(function(e){
		e.preventDefault()
		const user ={
			firstName: $("#firstName").val().trim(),
			lastName: $("#lastName").val().trim(),
			username: $("#username").val().trim(),
			password: $("#password").val().trim()
		}
		$.ajax({
			type: "POST",
			url: "/register",
			data: JSON.stringify(user),
			contentType: 'application/json; charset=utf-8'
		}).done(function(data){
			if(data === "Successful") window.location.href = "/"
			if(data === "Unsuccessful") alert("That username is taken already")
			}).catch(function(e){
				console.log(e)
			})
	})
	
	$("#loginSubmit").click(function(e){
		
		var username = $("username").val();
		var password = $("password").val();
		var url = '/login/'+username +"/"+ password;
		
		$.get(url, function(data){
			if(data === "Successful") window.location.href = "/test"
			if(data === "Unsuccessful") alert("Username or password is incorrect")
		}).catch(function(e){
			console.log(e)
		})
		
//		e.preventDefault()
//		$.ajax({
//			type: "POST",
//			url: "/login",
//			data: JSON.stringify({
//				username: $("#username").val().trim(),
//				password: $("#password").val().trim()
//			}),
//			contentType: 'application/json; charset=utf-8'
//		}).done(function(data){
//			if(data === "Successful") window.location.href = "/test"
//			if(data === "Unsuccessful") alert("Password or Username is incorrect")
//		}).catch(function(e){
//			console.log(e)
//		})
	})
	
})