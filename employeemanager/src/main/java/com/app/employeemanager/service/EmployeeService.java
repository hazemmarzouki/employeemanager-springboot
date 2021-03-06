package com.app.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.app.employeemanager.exceptions.UserNotFoundException;
import com.app.employeemanager.model.Employee;
import com.app.employeemanager.repos.EmployeeRepo;

@Service
public class EmployeeService {
	private final EmployeeRepo employeeRepo;;

	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);

	}

	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll();
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);

	}

	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}

	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException ("User by id"+id+"was not found !"));

	}

}
