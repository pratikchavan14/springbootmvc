package com.demo.boot.springbootmvc.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.boot.springbootmvc.model.Employee;
import com.demo.boot.springbootmvc.model.Status;
import com.demo.boot.springbootmvc.service.EmployeeService;

@RestController
public class EmployeeRestController {

	EmployeeRestController(){
		
	}
	
	Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	
	@Autowired
	EmployeeService empService;
	
	
	@PostMapping("/saveEmployee")
	public @ResponseBody Status saveEmployee(@RequestBody Employee employee) {
	  
		  try { 
			    Employee emp = empService.saveEmployee(employee);
			    logger.info("Employee added successfully."); 
			    return new Status(emp.getEmployeeId() , 1, "Employee added successfully.", emp); 
		  
		  } catch (Exception e) { 
			  
			    e.printStackTrace();
			    logger.info("Exception at Employee save failed. "+e.toString());
			    return new Status(0, 0, "Failed to add address.",null); 
		  } 
	 }
	
	
	@GetMapping("/getEmployeeById/{employeeId}")
	public @ResponseBody Status getEmployeeById(@PathVariable int employeeId) {
		
		 try { 			    
			    logger.info("Employee record fetched for Id = "+employeeId); 
			    return new Status(employeeId , 1, "Employee record fetched.", empService.getEmployeeById(employeeId)); 
		  
		  } catch (Exception e) { 
			  
			    e.printStackTrace();
			    logger.info("Exception at failed to fetch employee record "+e.toString());
			    return new Status(0, 0, "Failed to fetch employee record ",null); 
		  } 
	}
}
