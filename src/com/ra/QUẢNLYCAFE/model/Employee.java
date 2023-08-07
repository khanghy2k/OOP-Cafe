package com.ra.QUẢNLYCAFE.model;

public class Employee {
    private String employeeId;
    private String employeeName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private boolean status;

    // Constructors
    public Employee() {
    }

    public Employee(String employeeId, String employeeName, String email, String password, String phoneNumber, String address,boolean status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
    }

    // Getters and setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
