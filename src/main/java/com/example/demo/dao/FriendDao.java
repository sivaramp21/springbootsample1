package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CollegeEntity;
import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.Friend;
import com.example.demo.repository.CollegeRepository;
import com.example.demo.repository.FriendRepository;

@Repository("friendDao")
public class FriendDao {
	@Autowired
	private FriendRepository friendRepository;
	
	@Autowired
	private CollegeRepository collegeRepository;

	public List<Friend> getAllFriends() {	
		// TODO Auto-generated method stub
		
		List<Friend> friendList = new ArrayList<Friend>();
		List<FriendEntity> friendEntities = (List<FriendEntity>) friendRepository.findAll();
		 friendEntities.forEach(entity->{
			 Friend friend = new Friend();
			 friend.setId(entity.getId());
			 friend.setName(entity.getName());
			 friend.setAddress(entity.getAddress());
			 friendList.add(friend);
		 });
		return friendList;
	}

	public FriendEntity getFriendDetaildById(int id) {
		// TODO Auto-generated method stub
		Optional<FriendEntity> frOptional = friendRepository.findById((long) id);
		if (!frOptional.isPresent()) {
			return null;
		} else {
			return frOptional.get();
		}
	}

	public FriendEntity updateFriend(FriendEntity fe,int id) {
		// TODO Auto-generated method stub
		FriendEntity friendEntity = null	;
		FriendEntity newFriendEntity = null;
		Optional<FriendEntity> friendEntityOP = friendRepository.findById((long) id);
		if (!friendEntityOP.isPresent()) {
			friendEntity = null;
		} else {
			friendEntity  = friendEntityOP.get();
		}
		if(friendEntity != null) {
			friendEntity.setAddress(fe.getAddress());
			friendEntity.setName(fe.getName());
			newFriendEntity = friendRepository.save(friendEntity);
		}
		
		return newFriendEntity;
	}

	public FriendEntity getFriendDetaildByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Friend addfriend(FriendEntity fe) {
		
		Friend friend = new Friend();
		FriendEntity friendEntity = friendRepository.save(fe);
		//collegeRepository.save(fe.getCollegeEntity());
			 friend.setId(friendEntity.getId());
			 friend.setName(friendEntity.getName());
			 friend.setAddress(friendEntity.getAddress());
		return friend;
	}

	public CollegeEntity getCollegeUsingId(int id) {
		// TODO Auto-generated method stub
		FriendEntity friendEntity = new FriendEntity();
		friendEntity.setId(id);
		//collegeEntity.setFriendEntity(friendEntity);
		return null;
	}

	public CollegeEntity addCollege(CollegeEntity ce) {
		// TODO Auto-generated method stub
		friendRepository.save(ce.getFriendEntity());
		return collegeRepository.save(ce);
	}

}
