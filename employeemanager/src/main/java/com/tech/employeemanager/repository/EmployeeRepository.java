package com.tech.employeemanager.repository;

import com.tech.employeemanager.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    void deleteById(Long id);
    Optional<Employee> findEmployeeById(Long Id);
    boolean existsByEmail(String email);
}

