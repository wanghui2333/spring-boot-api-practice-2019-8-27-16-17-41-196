package com.tw.apistackbase.model;

import java.util.List;

public class Company {
    private int id;
    private String campanyName;
    private int employeeNumber;
    private List<Employee> employees;

    public Company(int id, String campanyName, int employeeNumber, List<Employee> employees) {
        this.id = id;
        this.campanyName = campanyName;
        this.employeeNumber = employeeNumber;
        this.employees = employees;
    }

    public Company() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCampanyName() {
        return campanyName;
    }

    public void setCampanyName(String campanyName) {
        this.campanyName = campanyName;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


}
