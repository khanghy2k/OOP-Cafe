package com.ra.QUẢNLYCAFE.Data;

import com.ra.QUẢNLYCAFE.model.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataContext implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Order> orderList;
    private List<OrderDetail> orderDetailList;
    private List<Category> categoryList;
    private List<Product> productList;
    private List<Employee> employeeList;
    private List<Table> tableList;

    transient private String pathContext;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }

    public DataContext(String pathContext) {
        this.pathContext = pathContext;
        this.orderList = new ArrayList<>();
        this.orderDetailList = new ArrayList<>();
        this.categoryList = new ArrayList<>(List.of(
                new Category("TU01", "Sinh Tố", true),
                new Category("TU02", "Cafe", true),
                new Category("TU03", "Nước Ép", true)
        ));
        this.productList = new ArrayList<>(List.of(
                new Product("DU01", "Sinh Tố Bơ", "TU01", 40000, true),
                new Product("DU02", "Cafe Muối", "TU02", 20000, true),
                new Product("DU03", "Nước Ép Cóc", "TU03", 50000, true)
        ));
        this.employeeList = new ArrayList<>(List.of(
                new Employee("NV01", "Hy", "hy@gmail.com", "123", "345", "Huế", true)
        ));
        this.tableList = new ArrayList<>(List.of(
                new Table("MB001", true),
                new Table("MB002", true),
                new Table("MB003", false),
                new Table("MB004", false),
                new Table("MB005", true)


        ));

    }
}
