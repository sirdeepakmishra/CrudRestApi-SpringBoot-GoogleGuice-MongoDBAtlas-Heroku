package com.cardinal.boot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cardinal.model.Employee;


@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long>{  //Long String

}
