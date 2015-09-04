package com.leonovich.cofeebreak.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by alexanderleonovich on 27.08.15.
 * Data transfer object. Copy of domain entity Order
 */
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 8621393897830674821L;
    private Long orderId;
    private Date orderDate;
    private Double totalPrice;
    private Long customerId;

    public OrderDTO() {
    }

    public OrderDTO(Long orderId, Double totalPrice) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
    }

    public OrderDTO(Long orderId, Date orderDate, Double totalPrice, Long customerId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.customerId = customerId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDTO orderDTO = (OrderDTO) o;

        if (orderId != null ? !orderId.equals(orderDTO.orderId) : orderDTO.orderId != null) return false;
        if (orderDate != null ? !orderDate.equals(orderDTO.orderDate) : orderDTO.orderDate != null) return false;
        return !(customerId != null ? !customerId.equals(orderDTO.customerId) : orderDTO.customerId != null);

    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", customerId=" + customerId +
                '}';
    }
}
