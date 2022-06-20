package com.springsecurity.basic_securityWith_inmemorydatabase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.basic_securityWith_inmemorydatabase.modal.User;
import com.springsecurity.basic_securityWith_inmemorydatabase.service.UserService;

@RestController
@RequestMapping("test")
public class UserCntrler {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/user")
	public String saved(@RequestBody User user) {
		service.saved(user);
		return "saved successfully  "+user.getId();
		
	}
	
	@GetMapping("/user")
	public List<User> getalluser(){
		return service.getalluser();
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getbyid(@PathVariable   int id) {
		return service.getbyid(id);
	}
	
	
	@DeleteMapping("/user/{id}")
	public String deletebyid(@PathVariable int id) {
		 service.deletebyid(id);
		 return "delete successfully user which id is ======= "+id;
	}
	
	
	@PatchMapping("/user")
	public User updateuser(@RequestBody User user) {
		
		return service.updatebyid(user);
		
		
		
	}
	

}
