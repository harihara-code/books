package com.books.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.books.model.Employee;

@FeignClient(name="employee-service")
public interface EmployeeClient {
	@GetMapping("/employees")
	List<Employee> getAll();
}