/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cuongnp.models.order;

import java.io.Serializable;

/**
 *
 * @author Cuong
 */
public class OrderDTO implements Serializable{
    private int orderId;
    private int contactId;
    private String orderDate;
    private String status;

    public OrderDTO() {
    }

    
    public OrderDTO(int orderId, int contactId, String orderDate, String status) {
        this.orderId = orderId;
        this.contactId = contactId;
        this.orderDate = orderDate;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
