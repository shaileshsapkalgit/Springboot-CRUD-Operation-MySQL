package com.mysql.Service;

import com.mysql.Entity.Employee;
import com.mysql.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    //save user
    public Employee saveUser(Employee employee)
    {
        Employee e1 = employeeRepo.save(employee);
        return e1;
    }
    //getAll User
    public List<Employee> getAllEmployee()
    {
        return employeeRepo.findAll();
    }
    //getUserby id
    /*public Optional<Employee> getUser(Long id)
    {
        return employeeRepo.findAllById(id);

    }*/
    public Employee getUser(Long id)
    {
        Employee e1= employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Employee not found with id: "+id));
        return e1;
    }
    // delete uuser
    public void deleteuser(Long id)
    {
        //employeeRepo.deleteById(id);
        if(!employeeRepo.existsById(id))
        {
            throw new RuntimeException("Employee not found with id: "+id);
        }
        employeeRepo.deleteById(id);
    }

    //Update user
    public Employee updateUser(Long id, Employee emp)
    {
        Employee e1 = employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Employee not found with this id: "+ id));
       // Employee e2 =  new Employee();
        e1.setName(emp.getName());
        e1.setEmail(emp.getEmail());
        e1.setGender(emp.getGender());

        return e1;
    }
}
