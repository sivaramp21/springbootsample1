package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CollegeEntity;
import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.Friend;
import com.example.demo.service.FriendService;

@RestController
@RequestMapping("/controller")
public class SpringBootController {

	@Autowired
	FriendService friendService;

	@RequestMapping("/app")
	public String getMessage() {
		return "SpringBootController";
	}

	@GetMapping("/all")
	public List<Friend> getAllFriendEntities() {
		return friendService.getAllFriendEntities();
	}

	@GetMapping("/get/{id}")
	public FriendEntity getFriendDetailsById(@PathVariable int id) {

		return friendService.getFriendDetailsById(id);
	}

	@RequestMapping(value = "/update/{id}" , method = RequestMethod.POST)
	public FriendEntity updateFriend(FriendEntity friendEntity, int id) {
		return friendService.updateFriend(friendEntity , id);

	}

	@GetMapping("/name/{friendName}")
	public FriendEntity getFriendDetailsByName(String name) {

		return friendService.getFriendDetailsByName(name);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<FriendEntity> deleteFriendEntities() {
		return null;
		
	}
	
	@PostMapping("/add")
	public Friend addFriend(@RequestBody FriendEntity fe) {
		System.out.println("entity iss"+fe);
		return friendService.addFriend(fe);
		
	}
	
	@PostMapping("/addCollege")
	public CollegeEntity addFriend(@RequestBody CollegeEntity ce) {
		System.out.println("entity iss"+ce);
		
		return friendService.addCollege(ce);
		
	}
	
	
	
	@GetMapping("/getCollege")
	public CollegeEntity getCollegeUsingId(@PathVariable int id) {
		System.out.println("entity iss"+id);
		return friendService.getCollegeUsingId(id);
		
	}
	
	

}
