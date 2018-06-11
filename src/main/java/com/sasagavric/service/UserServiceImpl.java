package com.sasagavric.service;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sasagavric.model.User;
import com.sasagavric.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository usersRepository;

	@Override
	public List<User> performSearchOperation(String searchData) {
		
		MultiMatchQueryBuilder mmqb = QueryBuilders.multiMatchQuery(searchData, "_all").minimumShouldMatch("2");
				
		log.info("Start searching");
		Iterable<User> users= usersRepository.search(mmqb);
		log.info("Searching completed");
		
		List<User> usersList = new ArrayList<>();
		users.forEach(usersList::add);
		
		return usersList;
	}
	
	

}