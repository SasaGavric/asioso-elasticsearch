package com.sasagavric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sasagavric.model.Employee;
import com.sasagavric.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class IndexSearchController {
	
	EmployeeService employeeService;
	
	@Autowired	
	public IndexSearchController(EmployeeService userService) {
		this.employeeService = userService;
	}

	@RequestMapping("/")
	public String getIndexPage() {
		
		return "index";
	}
	
	@PostMapping("/search")
	public String getSearchResults(@RequestParam("searchRequest") String searchRequest, Model model) {
		
		List<Employee> employeeList = employeeService.performSearchOperation(searchRequest);
		
		log.info("Search results: ");
		employeeList.forEach(u -> log.info(u.getId().toString() + ". " + u.getFirstName() + " " + u.getLastName()));
		
		model.addAttribute("listOfEmployees", employeeList);
		
		
		return "search-result";
	}

}
