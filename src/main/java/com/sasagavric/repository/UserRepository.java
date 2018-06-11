package com.sasagavric.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.sasagavric.model.User;

public interface UserRepository extends ElasticsearchRepository<User, Long> {

	

}
