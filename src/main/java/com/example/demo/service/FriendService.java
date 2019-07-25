package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FriendDao;
import com.example.demo.entity.CollegeEntity;
import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.Friend;

@Service("friendService")
public class FriendService {
	
	@Autowired
	FriendDao friendDao;

	public List<Friend> getAllFriendEntities() {
		// TODO Auto-generated method stub
		return friendDao.getAllFriends();
	}

	public FriendEntity getFriendDetailsById(int id) {
		// TODO Auto-generated method stub
		return friendDao.getFriendDetaildById(id);
	}

	public FriendEntity updateFriend(FriendEntity fe ,int id) {
		// TODO Auto-generated method stub
		return friendDao.updateFriend(fe , id);
	}

	public FriendEntity getFriendDetailsByName(String name) {
		// TODO Auto-generated method stub
		return friendDao.getFriendDetaildByName(name);
	}

	public Friend addFriend(FriendEntity fe) {
		// TODO Auto-generated method stub
		return friendDao.addfriend(fe);
	}

	public CollegeEntity getCollegeUsingId(int id) {
		// TODO Auto-generated method stub
		return friendDao.getCollegeUsingId(id);
	}

	public CollegeEntity addCollege(CollegeEntity ce) {
		// TODO Auto-generated method stub
		return friendDao.addCollege(ce);
	}

}
