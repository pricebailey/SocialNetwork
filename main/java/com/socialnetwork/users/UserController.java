package com.socialnetwork.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

	
	@Autowired
	UserRepository dao;
	//TODO check authorization
	public String[] authorizedUsers(){
		return null;
	}
	@GetMapping("/user")
	public @ResponseBody List<User> getUsers(){
		List<User> foundUsers = dao.findAll();
		System.out.println(foundUsers.toString());
		return foundUsers;
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value="id") String id) {
		User foundUser = dao.findById(id).orElse(null);
		
		System.out.println(foundUser.toString());
		return ResponseEntity.ok(foundUser);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = {"application/json"})
	public String postUser(@RequestBody User user){
		List<User> foundUsers = dao.findAll();
//		for(User currentUser: foundUsers) {
//			if(currentUser.getUsername().equals(user.getUsername())) {
//				return "Unsuccessful";
//			}
//		}
		dao.save(user);
		System.out.println(user.toString());
		return "Successful";
	}
	
	//@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
	@GetMapping("/login?username={username}&password={password}")
	public String loginUser(@PathVariable("username") String username, @PathVariable("password") String password) {
		List<User> foundUsers = dao.findAll();
		for(int i = 0; i < foundUsers.size(); i++) {
			
			System.out.println(foundUsers.get(i).getUsername());
			System.out.println(foundUsers.get(i).getPassword());
			System.out.println(username);
//			if(foundUsers.get(i).getUsername() == (username) && foundUsers.get(i).getPassword() == (password)) {
//				return "Successful";
//			}
		}
			return "Unsuccessful";
	}
	
	
}
