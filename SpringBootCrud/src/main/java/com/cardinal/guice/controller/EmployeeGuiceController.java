/** USING GUICE **/
package com.cardinal.guice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardinal.boot.exception.ResourceNotFoundException;
import com.cardinal.guice.module.EmployeeModule;
import com.cardinal.guice.request.RequestEmployees;
import com.cardinal.model.Employee;
import com.cardinal.service.SequenceGeneratorService;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/guice")

public class EmployeeGuiceController {

	private SequenceGeneratorService sequenceGeneratorService;

	@Inject
	public EmployeeGuiceController(SequenceGeneratorService sequenceGeneratorService) {
		this.sequenceGeneratorService = sequenceGeneratorService;
	}

	private static Injector injector = Guice.createInjector(new EmployeeModule());
	RequestEmployees requestEmployees = injector.getInstance(RequestEmployees.class);

	@GetMapping("/employees")
	public List<?> RequestGetAll() {
		return requestEmployees.RequestGetAll();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Object> RequestGetOne(@PathVariable long id) throws ResourceNotFoundException {

		String notPresent = "Employee not found for this id :: " + id;
//		return Optional.ofNullable(requestEmployees.RequestGetOne(id)).isPresent() ? requestEmployees.RequestGetOne(id)
//				: notPresent;
		// Optional<RequestEmployees> f= requestEmployees.RequestGetOne(id).;
		// .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this
		// id :: " + id));
		Object b = requestEmployees.RequestGetOne(id);
		System.out.println("------>" + b);
		return ResponseEntity.ok().body(b);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) // String
			throws ResourceNotFoundException {
//		Employee employee = requestEmployees.findById(employeeId)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		requestEmployees.RequestDeleteOne(employeeId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/employees/all")
	public Map<String, Boolean> deleteAllEmployee() throws ResourceNotFoundException {
		requestEmployees.RequestDeleteAll();
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		employee.setId(sequenceGeneratorService.generateSequence(Employee.USERS_SEQUENCE));
		// return employeeRepository.save(employee);
		return requestEmployees.RequestPostOne(employee);
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") Long id, // String
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		
		Object b = requestEmployees.RequestGetOne(id);
		if(b!=null) {
			return requestEmployees.RequestPutOne(id,employeeDetails);
		}else {
			return null;
		}
	
	}

}
