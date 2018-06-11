package com.sasagavric.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.sasagavric.model.Employee;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, Long> {

	

}
