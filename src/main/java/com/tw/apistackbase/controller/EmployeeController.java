package com.tw.apistackbase.controller;

import com.tw.apistackbase.dao.Database;
import com.tw.apistackbase.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EmployeeController {
    @Autowired
    Database dataService;

    @GetMapping(path = "")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(dataService.getEmployees());
    }

    @GetMapping(path = "/{employeeID}")
    public ResponseEntity<Employee> getCompany(@PathVariable int employeeID) {
        return ResponseEntity.ok(dataService.getEmployee(employeeID));
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Employee>> CompanyPages(@RequestParam int page, @RequestParam int pageSize) {
        List<Employee> employee = dataService.getEmployeePages(page, pageSize);
        if (employee.size() > 0) {
            return ResponseEntity.ok(employee);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/gender")
    public ResponseEntity<List<Employee>> CompanyPages(@RequestParam String gender) {
        List<Employee> employee = dataService.getEmployeeByGender(gender);
        if (employee.size() > 0) {
            return ResponseEntity.ok(employee);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        dataService.addEmployee(employee);
        return new ResponseEntity(employee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeID}")
    public ResponseEntity<Employee> updateCompanies(@PathVariable int employeeID,
                                                    @RequestBody Employee employee) {
        dataService.updateEmployee(employeeID, employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping(path = "/{employeeID}")
    public ResponseEntity<Integer> deleteCompanies(@PathVariable int employeeID) {
        dataService.deleteEmployee(employeeID);
        return ResponseEntity.ok(employeeID);
    }

}
