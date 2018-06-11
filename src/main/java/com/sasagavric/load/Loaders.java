package com.sasagavric.load;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sasagavric.model.Employee;
import com.sasagavric.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Loaders {

	@Autowired
	ElasticsearchOperations operations;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostConstruct
	@Transactional
	public void loadAll() {
		log.info("Loading Data in ES");
		operations.putMapping(Employee.class);
			
		employeeRepository.save(getData());
		log.info("Loading Completed");
	}

	private List<Employee> getData() {

		//users for loading data in Elasticsearch
		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee(1L, "John", "Doe", "Accounting", 2500.00));
		employees.add(new Employee(2L, "Maria", "Smith", "Accounting", 2800.00));
		employees.add(new Employee(3L, "Olivia", "Doe", "Accounting", 2500.00));
		employees.add(new Employee(4L, "Kari", "Hardy", "Accounting", 2200.00));
		
		employees.add(new Employee(5L, "Kristin", "Morgan", "Finance", 3500.00));
		employees.add(new Employee(6L, "Juana", "Jennings", "Finance", 3800.00));
		employees.add(new Employee(7L, "Brenda", "Romero", "Finance", 3050.00));
		employees.add(new Employee(8L, "Erick", "Warner", "Finance", 3300.00));
		
		employees.add(new Employee(9L, "Frederick", "Howard", "Managing", 5500.00));
		employees.add(new Employee(10L, "Maria", "Smith", "Managing", 5100.00));
		employees.add(new Employee(11L, "Claire", "Lopez", "Managing", 5200.00));
		employees.add(new Employee(12L, "Santos", "Fowler", "Managing", 4200.00));
		
		employees.add(new Employee(13L, "Gerardo", "Web", "IT", 3000.00));
		employees.add(new Employee(14L, "Lena", "Hudson", "IT", 3300.00));
		employees.add(new Employee(15L, "Ismael", "Powers", "IT", 2200.00));
		employees.add(new Employee(16L, "Teresa", "Butler", "IT", 3050.00));
		
		return employees;
	}
	
}
