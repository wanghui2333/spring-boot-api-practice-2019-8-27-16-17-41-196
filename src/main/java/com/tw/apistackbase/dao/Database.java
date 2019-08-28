package com.tw.apistackbase.dao;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Database {
    private List<Company> companines = new ArrayList<>();
    private List<Employee> employees1 = new ArrayList<>();
    private List<Employee> employees2 = new ArrayList<>();

    public Database() {
        this.employees1.add(new Employee(0, "小明", 23, "男", 8000));
        this.employees1.add(new Employee(1, "小红", 26, "女", 9000));
        this.employees1.add(new Employee(2, "小智", 21, "男", 7000));
        this.companines.add(new Company(0, "zybank", employees1.size(), this.employees1));

        this.employees2.add(new Employee(0, "jerry", 15, "男", 5000));
        this.employees2.add(new Employee(1, "sherry", 16, "女", 6000));
        this.employees2.add(new Employee(2, "tom", 17, "男", 7000));
        this.companines.add(new Company(1, "thoughtworks", employees2.size(), this.employees2));
    }

    public List<Company> getCompanines() {
        return companines;
    }

    public Company getCompany(int id) {
        List<Company> company = companines
                .stream()
                .filter(s -> s.getId() == id)
                .collect(Collectors.toList());
        return company.get(0);
    }

    public void addCompany(Company company) {
        this.companines.add(company);
    }

    public void deleteCompany(int companyID) {
        List<Company> company = companines
                .stream()
                .filter(s -> s.getId() == companyID)
                .collect(Collectors.toList());
        this.companines.remove(company.get(0));
    }

    public void updateCompany(int companyID, Company company) {
        List<Company> company1 = companines
                .stream()
                .filter(s -> s.getId() == companyID)
                .collect(Collectors.toList());
        company1.get(0).setCampanyName(company.getCampanyName());
        company1.get(0).setEmployeeNumber(company.getEmployeeNumber());
        company1.get(0).setEmployees(company.getEmployees());
    }

    public List<Employee> getEmployees() {
        return employees1;
    }

    public Employee getEmployee(int employeeID) {
        List<Employee> employees = employees1
                .stream()
                .filter(s -> s.getId() == employeeID)
                .collect(Collectors.toList());
        return employees.get(0);
    }


    public void addEmployee(Employee employee) {
        this.employees1.add(employee);

    }

    public void deleteEmployee(int employeeID) {
        List<Employee> employee3 = employees1
                .stream()
                .filter(s -> s.getId() == employeeID)
                .collect(Collectors.toList());
        this.companines.remove(employee3.get(0));
    }

    public void updateEmployee(int employeeID, Employee employee) {
        List<Employee> employee2 = employees1
                .stream()
                .filter(s -> s.getId() == employeeID)
                .collect(Collectors.toList());
        employee2.get(0).setAge(employee.getAge());
        employee2.get(0).setGender(employee.getGender());
        employee2.get(0).setName(employee.getName());
        employee2.get(0).setSalary(employee.getSalary());
    }

    public List<Company> getCompanyPages(int page, int pageSize) {
        if (page < pageSize && pageSize <= this.companines.size()) {
            return this.companines.subList(page, pageSize);
        }
        return new ArrayList<Company>();
    }

    public List<Employee> getEmployeePages(int page, int pageSize) {
        if (page < pageSize && pageSize <= this.companines.size()) {
            return this.employees1.subList(page, pageSize);
        }
        return new ArrayList<Employee>();
    }

    public List<Employee> getEmployeeByGender(String gender) {
        List<Employee> employee2 = employees1
                .stream()
                .filter(s -> s.getGender() == gender)
                .collect(Collectors.toList());
        return employee2;
    }

}