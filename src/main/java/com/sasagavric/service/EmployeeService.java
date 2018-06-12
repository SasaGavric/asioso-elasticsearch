package com.sasagavric.service;

import java.util.List;

import com.sasagavric.model.Employee;

/**
 * @author Sasa Gavric
 *
 */
public interface EmployeeService {
	
	public List<Employee> performSearchOperation(String searchData);

}
