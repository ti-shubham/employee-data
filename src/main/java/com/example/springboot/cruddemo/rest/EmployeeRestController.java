package com.example.springboot.cruddemo.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.cruddemo.dao.EmployeeDAO;
import com.example.springboot.cruddemo.entity.Employee;
import com.example.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private final Logger log=org.slf4j.LoggerFactory.getLogger(this.getClass());

	private EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	
	//expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}

	//add mapping for GET /employees/{employeeId}-- to get the employee based on id
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee employee=employeeService.findById(employeeId);
		
		if(employee==null) {
			log.info("Employee Id not found "+employeeId);
			throw new RuntimeException("Employee Id not found "+employeeId);
		}
		
		return employee;
	}
	
	//add mapping for POST /employees-- to add an new entry
	
	@PostMapping("/employees")
	public Employee addEmployee(@Valid @RequestBody Employee theEmployee) {
		
		//also just in case they pass th id in json .. set it to 0
		// this is to force to save a new item.. instaed of update
		
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	//add mapping for PUT /employees-- to update the existing details
	@PutMapping("/employees")
	public Employee updateEmployee(@Valid @RequestBody Employee employee) {
		
		employeeService.save(employee);
		
		return employee;
	}
	
	//add mapping for DELETE /employee/{employeeId}-- delete employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		log.warn("Going to delete employee with id "+employeeId);
		Employee theEmployee=employeeService.findById(employeeId);
		
		if(theEmployee==null) {
			throw new RuntimeException("no Employee found with id "+employeeId);
		}
		employeeService.deleteById(employeeId);
		
		log.info("employee with id "+employeeId+" deleted");
		return "Deleted Employee id is : "+employeeId;
	}
}
