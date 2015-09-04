package com.leonovich.cofeebreak.domain;

import com.leonovich.cofeebreak.model.OrderDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by alexanderleonovich on 27.08.15.
 * Domain entity Order
 */
@Entity
@Table(name = "T_ORDER")
public class Order implements Serializable {
    private static final long serialVersionUID = 1728690078088535130L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "F_ORDER_ID")
    private Long orderId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "F_ORDER_DATE", updatable = false)
    private Date orderDate;

    @Column(name = "F_TOTAL_PRICE")
    private Double totalPrice;

    @ManyToOne(cascade = REFRESH)
    @JoinColumn(name = "F_CUSTOMER_ID")
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = LAZY, cascade = {ALL})
    private List<CoffeeCup> coffeeCups;

    public Order() {
    }

    public Order(Long orderId, Double totalPrice) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
    }

    public Order(OrderDTO orderDTO) {
        this.orderId = orderDTO.getOrderId();
        this.orderDate = orderDTO.getOrderDate();
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CoffeeCup> getCoffeeCups() {
        return coffeeCups;
    }

    public void setCoffeeCups(List<CoffeeCup> coffeeCups) {
        this.coffeeCups = coffeeCups;
    }

   /*public Set<Coffee> getCoffies() {
        return coffies;
    }

    public void setCoffies(Set<Coffee> coffies) {
        this.coffies = coffies;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderDate != null ? !orderDate.equals(order.orderDate) : order.orderDate != null) return false;
        return !(totalPrice != null ? !totalPrice.equals(order.totalPrice) : order.totalPrice != null);

    }

    @Override
    public int hashCode() {
        int result = orderDate != null ? orderDate.hashCode() : 0;
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
