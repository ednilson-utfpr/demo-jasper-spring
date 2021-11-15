package com.mballem.curso.jasper.spring.repository;


import com.mballem.curso.jasper.spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
