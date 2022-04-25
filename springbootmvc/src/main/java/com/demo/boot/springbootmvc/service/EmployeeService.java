package com.demo.boot.springbootmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.boot.springbootmvc.model.Employee;

@Service
public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	
	public Employee getEmployeeById(int employeeId);
	
	public List<Employee> employeeList();
	
	public void deleteEmployee(int employeeId);
	
}
