package com.sasagavric.service;

import java.util.ArrayList;
import java.util.List;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sasagavric.model.Employee;
import com.sasagavric.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Sasa Gavric
 *
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> performSearchOperation(String searchData) {

		MultiMatchQueryBuilder mmqb = QueryBuilders.multiMatchQuery(searchData, "_all").minimumShouldMatch("2");

		log.info("Start searching");
		Iterable<Employee> employees = employeeRepository.search(mmqb);
		log.info("Searching completed");

		List<Employee> employeeList = new ArrayList<>();
		employees.forEach(employeeList::add);

		return employeeList;
	}

}
