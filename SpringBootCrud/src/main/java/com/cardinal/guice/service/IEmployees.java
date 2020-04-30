package com.cardinal.guice.service;

import java.util.List;

import com.cardinal.model.Employee;

//@ProvidedBy(ProviderEmployees.class)
public interface IEmployees {
	
	List<?> getAll();
	Object getOne(long id);
	boolean deleteAll();
	boolean deleteOne(long id);
	Employee postOne(Employee employee);
	Employee putOne(Long id,Employee json1);
	
}
