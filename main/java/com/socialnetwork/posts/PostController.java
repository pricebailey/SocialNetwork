package com.socialnetwork.posts;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.users.User;
import com.socialnetwork.users.UserRepository;

@RestController
public class PostController {

	UserRepository dao;
	
	@GetMapping("/posts")
	public @ResponseBody String getPosts() {
		return "posts";
	}
	
	
	@GetMapping("/test")
    public String getTest(Model model) {
        
		model.addAttribute("post", new Post());
		return "test.html";
        
    }
	@GetMapping("/test/{message}")
    public String getMessage(@PathVariable("message") String message, User user) {
        
		Post createdPost = new Post(user, message);
		System.out.println(createdPost);
		return createdPost.toString();
        
    }
	
	@PostMapping("/test")
	@ResponseBody
	public ResponseEntity<Post> createPost(@ModelAttribute Post post, User user) {
		Post createdPost = new Post();
		return null;
	}
}
