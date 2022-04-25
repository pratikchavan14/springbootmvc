package com.demo.boot.springbootmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.boot.springbootmvc.model.Employee;
import com.demo.boot.springbootmvc.repository.EmployeeRepository;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	EmployeeRepository repo;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee emp = repo.save(employee); 
		return emp;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return repo.findByEmployeeId(employeeId);
	}

	@Override
	public List<Employee> employeeList() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		repo.deleteById(employeeId);
	}

}
