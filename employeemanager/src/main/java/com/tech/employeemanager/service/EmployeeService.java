package com.tech.employeemanager.service;

import com.tech.employeemanager.Model.Employee;
import com.tech.employeemanager.exception.EmailAlreadyExistsException;
import com.tech.employeemanager.exception.EmployeeNotFoundException;
import com.tech.employeemanager.exception.UserNotFoundException;
import com.tech.employeemanager.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new EmailAlreadyExistsException("Employee with email " + employee.getEmail() + " already exists");
        }

        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee by  id "+id +" Was not found"));
    }
    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }
    public Employee updateEmployee(Employee employee) {
        if (employee.getId() == null) {
            throw new IllegalArgumentException("Employee ID must not be null for update");
        }
        Employee existingEmployee = employeeRepository.findEmployeeById(employee.getId())
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID " + employee.getId()));

        if (!existingEmployee.getEmail().equals(employee.getEmail()) &&
                employeeRepository.existsByEmail(employee.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + employee.getEmail());
        }

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setJobTitle(employee.getJobTitle());
        existingEmployee.setImageUrl(employee.getImageUrl());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployeeById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Cannot delete. Employee with ID " + id + " not found.");
        }
        employeeRepository.deleteById(id);
    }

}
