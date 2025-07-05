package com.mysql.Controller;

import com.mysql.Entity.Employee;
import com.mysql.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //save user
    @PostMapping("/api/save")
    public ResponseEntity<String> saveUser(@RequestBody Employee employee)
    {
        Employee e1 = employeeService.saveUser(employee);
        String msg = "Employee " + e1.getName()+"save successfully!!!";
        return ResponseEntity.ok(msg);

    }
    //getuserby id
    @GetMapping("/api/get/{id}")
    public ResponseEntity<Employee> getUser(@PathVariable Long id)
    {
        Employee e1 = employeeService.getUser(id);
        return new ResponseEntity<>(e1, HttpStatus.CREATED);
    }
    //get all user
    @GetMapping("/api/getAll")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        List<Employee> l1 = employeeService.getAllEmployee();
        return new ResponseEntity<>(l1,HttpStatus.OK);
    }
    //update user
    @PutMapping("/api/update/{id}")
    public ResponseEntity<Employee> updateUser(@PathVariable Long id,@RequestBody Employee updatedEmployee)
    {
        Employee e1 = employeeService.updateUser(id,updatedEmployee);
        return new ResponseEntity<>(e1,HttpStatus.OK);
    }
    //delete user
    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id)
    {
        employeeService.deleteuser(id);

        return ResponseEntity.ok("Employee with ID " + id + " deleted successfully");
    }
}
