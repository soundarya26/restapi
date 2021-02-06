package com.tavant.employeerestapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.employeerestapi.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	boolean addEmployee(Employee employee);
//
//	
//	public Optional<Employee> updateEmployee(String empId , Employee employee);
//	public Optional<Employee> getEmployeeById(int empid);
//	public static Optional<List<Employee>> getEmployees(){
//		return null;
//	}


}
