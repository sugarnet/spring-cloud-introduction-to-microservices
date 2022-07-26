package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.Employee;
import com.example.dao.EmployeeDao;

@RestController
public class MainRESTController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Employee addEmployee(@RequestBody Employee employee) {
		System.out.println("(Service Side) Creating Employee: " + employee.getEmpNo());

		return employeeDao.addEmployee(employee);
	}

	@RequestMapping(value = "/employee/{empNo}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Employee updateEmployee(@PathVariable String empNo, @RequestBody Employee employee) {
		System.out.println("(Service Side) Updating Employee: " + empNo);

		employee.setEmpNo(empNo);
		return employeeDao.addEmployee(employee);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Employee> getAllEmployees() {

		return employeeDao.getAllEmployees();
	}
	
	@RequestMapping(value = "/employee/{empNo}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Employee getEmployee(@PathVariable String empNo) {

		return employeeDao.getEmployee(empNo);
	}
	
	@RequestMapping(value = "/employee/{empNo}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteEmployee(@PathVariable String empNo) {

		employeeDao.deleteEmployee(empNo);
	}

}
