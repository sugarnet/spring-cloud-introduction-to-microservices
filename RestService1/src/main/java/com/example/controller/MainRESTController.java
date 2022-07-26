package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.Employee;
import com.example.dao.EmployeeDao;

@RestController
public class MainRESTController {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(path = "/employee", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Employee addEmployee(@RequestBody Employee employee) {
		System.out.println("(Service Side) Creating Employee: " + employee.getEmpNo());

		return employeeDao.addEmployee(employee);
	}
}
