package com.tw.apistackbase.controller;


import com.tw.apistackbase.dao.Database;
import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    Database dataService;

    @GetMapping(path = "")
    public ResponseEntity<List<Company>> getAll() {
        return ResponseEntity.ok(dataService.getCompanines());
    }

    @GetMapping(path = "/{companyID}")
    public ResponseEntity<Company> getCompany(@PathVariable int companyID) {
        return ResponseEntity.ok(dataService.getCompany(companyID));
    }

    @GetMapping(path = "/{companyID}/employees")
    public ResponseEntity<List<Employee>> getEmployees(@PathVariable int companyID) {
        List<Employee> employees = dataService.getCompany(companyID).getEmployees();
        if (employees.size() > 0) {
            return ResponseEntity.ok(employees);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Company>> CompanyPages(@RequestParam int page, @RequestParam int pageSize) {
        List<Company> company = dataService.getCompanyPages(page, pageSize);
        if (company.size() > 0) {
            return ResponseEntity.ok(company);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @PostMapping(path = "/")
    public ResponseEntity<Company> addCompanies(@RequestBody Company company) {
        dataService.addCompany(company);
        return new ResponseEntity(company, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{companyID}")
    public ResponseEntity<Company> updateCompanies(@PathVariable int companyID,
                                                   @RequestBody Company company) {
        dataService.updateCompany(companyID, company);
        return ResponseEntity.ok(company);
    }

    @DeleteMapping(path = "/{companyID}")
    public ResponseEntity<Integer> deleteCompanies(@PathVariable int companyID) {
        dataService.deleteCompany(companyID);
        return ResponseEntity.ok(companyID);
    }


}
