package com.cardinal.guice.request;

import java.util.List;

import com.cardinal.guice.service.IEmployees;
import com.cardinal.model.Employee;
import com.google.inject.Inject;

public class RequestEmployees {

	private final IEmployees emp;

	@Inject
	public RequestEmployees(IEmployees emp) {
		this.emp = emp;
	}

	public List<?> RequestGetAll() {
		return emp.getAll();
	}
	
	public Object RequestGetOne(long id) {
		return emp.getOne(id);
	}
	
	public Employee RequestPostOne(Employee e) {
		return emp.postOne(e);
	}
	public Employee RequestPutOne(Long id,Employee e) {
		return emp.putOne(id,e);
	}
	public boolean RequestDeleteOne(long id) {
		return  emp.deleteOne(id);
	};
	public boolean RequestDeleteAll() {
		return emp.deleteAll();
	};
}
