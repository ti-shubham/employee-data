package com.example.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {

		//create a query
		Query theQuery=entityManager.createQuery("from Employee");
		
		//execute Query and get the resilt list
		List<Employee> employee=theQuery.getResultList();
		
		//return the result
		return employee;
		
		
	}

	@Override
	public Employee findById(int theId) {

		//get Employee
		Employee employees=entityManager.find(Employee.class, theId);
		
		//return the result
		return employees;
	}

	@Override
	public void save(Employee employee) {

		//save or update employees
		Employee dbemployees=entityManager.merge(employee);
		
		//update with id from db... so we can get generated id for save/insert
		employee.setId(dbemployees.getId());
		

	}

	@Override
	public void deleteById(int theId) {

		// delete object with primay key
		Query theQuery=entityManager.createQuery("delete from Employee where id=: employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
