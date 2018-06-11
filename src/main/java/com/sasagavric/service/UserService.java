package com.sasagavric.service;

import java.util.List;

import com.sasagavric.model.User;

public interface UserService {
	
	public List<User> performSearchOperation(String searchData);

}
