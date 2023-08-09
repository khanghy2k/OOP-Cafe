package com.ra;

import com.ra.QUẢNLYCAFE.Data.DataContext;
import com.ra.QUẢNLYCAFE.model.*;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    private static Employee currentUser;

    public static void main(String[] args) {
//        Sau khi đăng nhập
//          Xin chào [Tên NV đã đăng nhập]
//          1. Hiển thị danh sách bàn
//          2. Đặt bàn
//          3. Thanh toán
//          4. Đăng xuất
        Scanner scanner = new Scanner(System.in);
        DataContext data = new DataContext("");

        while (true) {
            System.out.println("1.Đăng Nhập");
            System.out.println("2.Thoát");
            System.out.println("Tính Năng");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1 -> {
                    System.out.println("Email :");
                    String email = scanner.nextLine();
                    System.out.println("Passowrd : ");
                    String password = scanner.nextLine();
                    Employee employee = data.getEmployeeList().stream().filter(x -> x.getEmail().equals(email) && x.getPassword().equals(password))
                            .findFirst().orElse(null);
                    if (employee != null) {
                        currentUser = employee;
                        loggedMenu(scanner, data);
                    } else {
                        System.out.println("Sai mật khẩu hoặc tên đăng nhập");
                    }
                }
                case 2 -> System.exit(0);
                default -> System.out.println("Sai chức năng");
            }
        }
    }

    public static void loggedMenu(Scanner scanner, DataContext data) {
        while (currentUser != null) {
            String welcomeMessage = "Xin Chào " + currentUser.getEmployeeName();
            System.out.println(centerText(welcomeMessage, 80));
            System.out.println(centerText("1. Bàn", 80));
            System.out.println(centerText("2. Thanh Toán", 80));
            System.out.println(centerText("3. Chuyển Bàn", 80));
            System.out.println(centerText("4. Đăng Xuất", 80));
            System.out.print("Chọn chức Năng: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1 -> {
                    System.out.println("Danh Sách Bàn");
                    for (Table t : data.getTableList()
                    ) {
                        System.out.println(" Mã bàn " + t.getTableId() + (t.isStatus() ? "  Có Khách  " : "  Trống "));
                    }
                    System.out.println("Nhập Mã Bàn");
                    String selectedTable = scanner.nextLine();
                    Table table = data.getTableList().stream().filter(x -> x.getTableId().equals(selectedTable))
                            .findFirst().orElse(null);

                    //Menu
                    for (Category c : data.getCategoryList()
                    ) {
                        if (c.isStatus()) {
                            System.out.println(c.getCategoryName());
                            for (Product p : data.getProductList()
                            ) {
                                if (p.getCategoryId().equals(c.getCategoryId())) {
                                    System.out.println(
                                            MessageFormat.format("\f({0}) {1} | {2}", p.getProductId(), p.getProductName(),
                                                    p.getPrice())
                                    );
                                }
                            }
                        }
                    }
                    // chọn đồ uống
                    while (true) {
                        //List đồ uống
                        System.out.println("Danh Sách Orders");
                        assert table != null;
                        for (OrderDetail item : table.getOrderDetails()
                        ) {
                            System.out.println(MessageFormat.format("{0}\t{1}\t{2}\t{3}\t{4}",
                                    item.getProductId(), item.getProductName(), item.getQuantity(), item.getUnitPrice(),
                                    (item.getUnitPrice() * item.getQuantity())));
                        }
                        System.out.println("Mã Đồ Uống");
                        String productId = scanner.nextLine();
                        if (productId.equals("exit")) {
                            break;
                        } else if (productId.equals("cancel")) {
                            table.removeAll();
                            break;
                        }
                        Product pro = data.getProductList().stream().filter(x -> x.getProductId().equals(productId))
                                .findFirst().orElse(null);
                        System.out.println("Số Lượng :  ");
                        int qty = Integer.parseInt(scanner.nextLine());
                        OrderDetail itemOrder = new OrderDetail();
                        assert pro != null;
                        itemOrder.setProductId(pro.getProductId());
                        itemOrder.setProductName(pro.getProductName());
                        itemOrder.setUnitPrice(pro.getPrice());
                        itemOrder.setQuantity(qty);
                        table.setStatus(true);
                        table.addOrder(itemOrder);
                    }
                }
                case 2 -> {
                    System.out.println("Danh Sách Bàn");
                    for (Table t : data.getTableList()
                    ) {
                        System.out.println("Mã bàn: " + t.getTableId() + (t.isStatus() ? " Có Khách" : " Trống"));
                    }
                    System.out.println("Nhập Mã Bàn Thanh Toán");
                    String tableId = scanner.nextLine();
                    Table table1 = data.getTableList().stream().filter(
                            x -> x.getTableId().equals(tableId)
                    ).findFirst().orElse(null);
                    if (table1 != null) {
                        System.out.println("Danh Sách Orders");
                        for (OrderDetail item : table1.getOrderDetails()
                        ) {
                            System.out.println(MessageFormat.format("{0}\t{1}\t{2}\t{3}\t{4}",
                                    item.getProductId(), item.getProductName(), item.getQuantity(), item.getUnitPrice(),
                                     (item.getUnitPrice() * item.getQuantity())));
                        }

                    } else {
                        System.out.println("Mã bàn đã chọn chưa có khách");
                        break;
                    }
                    table1.setStatus(false);
                    table1.removeAll();
                }
                case 3 -> {
                    for (Table t : data.getTableList()
                    ) {
                        System.out.println("Mã bàn: " + t.getTableId() + (t.isStatus() ? " Có Khách" : " Trống"));
                    }
                    System.out.println("Nhập mã bàn muốn chuyển:");
                    String sourceTableId = scanner.nextLine();
                    Table sourceTable = data.getTableList().stream()
                            .filter(x -> x.getTableId().equals(sourceTableId) && x.isStatus())
                            .findFirst()
                            .orElse(null);
                    if (sourceTable != null) {
                        System.out.println("Nhập mã bàn muốn chuyển đến:");
                        String destTableId = scanner.nextLine();
                        Table destTable = data.getTableList().stream()
                                .filter(x -> x.getTableId().equals(destTableId) && !x.isStatus())
                                .findFirst()
                                .orElse(null);
                        if (destTable != null) {
                            // Chuyển chi tiết đơn hàng từ bàn gốc sang bàn đích
                            List<OrderDetail> orderDetails = new ArrayList<>(sourceTable.getOrderDetails());
                            destTable.setStatus(true);
                            destTable.getOrderDetails().addAll(orderDetails);
                            System.out.println("Chuyển bàn thành công");

                            // Xóa chi tiết đơn hàng của bàn gốc sau khi chuyển
                            sourceTable.getOrderDetails().clear();
                            sourceTable.setStatus(false);

                            // In ra danh sách sau khi chuyển
                            System.out.println("Danh sách sau khi chuyển:");
                            for (Table t : data.getTableList()) {
                                System.out.println("Mã bàn: " + t.getTableId() + (t.isStatus() ? " Có Khách" : " Trống"));
                            }
                        } else {
                            System.out.println("Bàn đã có khách hàng.");
                        }
                    } else {
                        System.out.println("Bàn gốc không tồn tại.");
                    }
                }
                case 4 -> currentUser = null;
            }

        }
    }
    public static String centerText(String text, int totalWidth) {
        int padding = (totalWidth - text.length()) / 2;
        return String.format("%" + (padding + text.length()) + "s", text);
    }
}







