package com.socialnetwork;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.socialnetwork.users.User;
import com.socialnetwork.users.UserRepository;

@Controller
public class HomeController {

	@Autowired
	UserRepository dao;
	
	 @GetMapping(value= {"/", "/home"})
	    public String getHome() {
		 	
	        return "home";
	    }
	@GetMapping("/login")
    public String getLogin() {
        
        return "login";
    }
	
	@GetMapping("/register")
    public String getRegister(Model model) {
		model.addAttribute("User", new User());
        return "register";
    }
	
	
	//TODO add new user to database
	
	
	
}
