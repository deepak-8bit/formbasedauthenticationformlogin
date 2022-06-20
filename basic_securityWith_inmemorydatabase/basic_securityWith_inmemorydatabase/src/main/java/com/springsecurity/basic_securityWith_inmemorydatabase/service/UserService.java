package com.springsecurity.basic_securityWith_inmemorydatabase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.basic_securityWith_inmemorydatabase.modal.User;
import com.springsecurity.basic_securityWith_inmemorydatabase.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repository;
	
	
//	 post
	public User saved(User user) {
		
		return repository.save(user);
	}
	
//	get
	
	public List<User> getalluser(){
		return repository.findAll();
	}
	
//	getbyid
	public Optional<User> getbyid(int id) {
	   return  repository.findById(id);
	}
	
//	deletebyid
	public void deletebyid(int id) {
	    repository.deleteById(id);
	}
	
//	update
	public User updatebyid(User user) {
		
//		Optional<User> getbyids(int id) {
//			     repository.findById(id);
//			}
		User exstinguser = repository.findById(user.getId()).orElse(null);
		
		exstinguser.setUsername(user.getUsername());
		exstinguser.setPassword(user.getPassword());
		
	return	repository.save(exstinguser);
		
		
	}

}
