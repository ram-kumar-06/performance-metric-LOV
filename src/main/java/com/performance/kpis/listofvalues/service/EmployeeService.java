package com.performance.kpis.listofvalues.service;

import com.performance.kpis.listofvalues.globalException.ResourceNotFoundException;
import com.performance.kpis.listofvalues.model.Employee;
import com.performance.kpis.listofvalues.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Constructor injection
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    // Get employee by id
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
    }

    // Create employee
    public Employee createEmployee(Employee employee) {
        employee.setVersion(1);
        return employeeRepository.save(employee);
    }

    // Update employee
    public Employee updateEmployee(Integer id, Employee employeeDetails) {
        Employee existing = getEmployeeById(id);

        existing.setFirstName(employeeDetails.getFirstName());
        existing.setLastName(employeeDetails.getLastName());
        existing.setEmail(employeeDetails.getEmail());
        existing.setEmployeeNo(employeeDetails.getEmployeeNo());
        existing.setPractice(employeeDetails.getPractice());
        existing.setPortfolio(employeeDetails.getPortfolio());
        existing.setCpdLevel(employeeDetails.getCpdLevel());
        existing.setCpdStage(employeeDetails.getCpdStage());
        existing.setScore(employeeDetails.getScore());
        existing.setIsAdmin(employeeDetails.getIsAdmin());
        existing.setModifiedAt(employeeDetails.getModifiedAt());
        existing.setModifiedBy(employeeDetails.getModifiedBy());
        existing.setVersion(existing.getVersion() + 1);

        return employeeRepository.save(existing);
    }

    // Delete employee by id
    public void deleteEmployee(Integer id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with ID: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
