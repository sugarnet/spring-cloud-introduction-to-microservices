package com.example.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	private static final Map<String, Employee> empMap = new HashMap<>();

	static {
		initEmps();
	}

	private static void initEmps() {
		Employee emp1 = new Employee("E01", "Smith", "Clerc");
		Employee emp2 = new Employee("E02", "Allen", "Salesman");
		Employee emp3 = new Employee("E03", "Jones", "Manager");

		empMap.put(emp1.getEmpNo(), emp1);
		empMap.put(emp2.getEmpNo(), emp2);
		empMap.put(emp3.getEmpNo(), emp3);
	}

	public Employee addEmployee(Employee employee) {
		empMap.put(employee.getEmpNo(), employee);
		return employee;
	}
	
	public Employee getEmployee(String empNo) {
		return empMap.get(empNo);
	}
	
	public List<Employee> getAllEmployees() {
		Collection<Employee> employees = empMap.values();
		List<Employee> list = new ArrayList<>();
		list.addAll(employees);
		return list;
		
	}
	
	public void deleteEmployee(String empNo) {
		empMap.remove(empNo);
	}

}
