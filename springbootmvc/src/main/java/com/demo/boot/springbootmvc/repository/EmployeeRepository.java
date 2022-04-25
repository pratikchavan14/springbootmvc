package com.demo.boot.springbootmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.boot.springbootmvc.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public Employee findByEmployeeId(int employeeId);
	
	@Query("select e from Employee e where e.employeeAddress = :employeeAddress")
	public Employee getEmployeeByAddress(String employeeAddress);
}
