package com.mysql.Repository;

import com.mysql.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

   // Optional<Employee> findAllById(Long id);
}
