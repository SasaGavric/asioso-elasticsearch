package com.sasagavric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sasagavric.model.User;
import com.sasagavric.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class IndexSearchController {
	
	UserService userService;
	
	@Autowired	
	public IndexSearchController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/")
	public String getIndexPage() {
		
		return "index";
	}
	
	@PostMapping("/search")
	public String getSearchResults(@RequestParam("searchRequest") String searchRequest, Model model) {
		
		List<User> usersList = userService.performSearchOperation(searchRequest);
		
		log.info("Search results: ");
		usersList.forEach(u -> log.info(u.getId().toString() + ". " + u.getFirstName() + " " + u.getLastName()));
		
		model.addAttribute("listOfUsers", usersList);
		
		
		return "search-result";
	}

}
