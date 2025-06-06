package com.performance.kpis.listofvalues.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.performance.kpis.listofvalues.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    // Default CRUD operations provided
}
