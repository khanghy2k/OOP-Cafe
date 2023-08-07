package com.ra.QUẢNLYCAFE.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String orderId;
    private String employeeId;
    private String tableId;
    private LocalDateTime orderDate;
    private List<OrderDetail> orderDetails;

    // Constructors
    public Order() {
    }

    public Order(String orderId, String employeeId, String tableId, LocalDateTime orderDate, List<OrderDetail> orderDetails) {
        this.orderId = orderId;
        this.employeeId = employeeId;
        this.tableId = tableId;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
    }

    // Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}

