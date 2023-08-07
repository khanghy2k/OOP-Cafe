package com.ra.QUẢNLYCAFE.model;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private String tableId;
    private boolean status;
    transient private List<OrderDetail> orderDetails=new ArrayList<>();
    public Table() {

    }
    public void addOrder(OrderDetail item){
        boolean isDuplicate = false;
        for (OrderDetail t:orderDetails
             ) {
            if (t.getProductId().equals(item.getProductId())){
                t.setQuantity(item.getQuantity());
                isDuplicate = true;
                break;
            }
        }
        if (!isDuplicate) {
            orderDetails.add(item);
        }
    }
    public void removeOrder(String productId){
        orderDetails.removeIf(x->x.getProductId().equals(productId));
    }
    public List<OrderDetail> getOrderDetails(){
        return this.orderDetails;
    }
    public void removeAll(){
        this.orderDetails = new ArrayList<>();
    }

    public Table(String tableId, boolean status) {
        this.tableId = tableId;
        this.status = status;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
