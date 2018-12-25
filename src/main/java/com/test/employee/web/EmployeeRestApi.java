package com.test.employee.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.employee.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeRestApi {

	private final Map<Integer, Employee> employees = new HashMap<>();

	@GetMapping
	public Collection<Employee> getEmployees() {
		return employees.values();
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) {
		if (employees.containsKey(id)) {
			return employees.get(id);
		} else {
			throw new ResourceNotFoundException("There is no employee with id: " + id);
		}
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Employee addEmployee(@RequestBody Employee employee) {
		if (employees.containsKey(employee.getId())) {
			throw new DuplicateRecordException("Employee with id: " + employee.getId() + " already exists.");
		} else {
			employees.put(employee.getId(), employee);
			return employee;
		}
	}

	@PutMapping("/{id}")
	@ResponseBody
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		if (employees.containsKey(id)) {
			employees.put(id, employee);
			return employee;
		} else {
			throw new ResourceNotFoundException("There is no employee with id: " + id);
		}
	}

	@DeleteMapping("/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		if (employees.containsKey(id)) {
			return employees.remove(id);
		} else {
			throw new ResourceNotFoundException("There is no employee with id: " + id);
		}
	}

	@DeleteMapping
	public void deleteEmployees() {
		employees.clear();
	}
}
