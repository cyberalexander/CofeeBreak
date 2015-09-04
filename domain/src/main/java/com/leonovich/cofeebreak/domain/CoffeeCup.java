package com.leonovich.cofeebreak.domain;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by alexanderleonovich on 02.09.15.
 * Domain entity CoffeeCup
 */
@Entity
@Table(name = "T_COFFEE_CUP")
public class CoffeeCup implements Serializable {
    private static final long serialVersionUID = 2413338865695114925L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "F_COFFEE_CUP_ID")
    private Long coffeeCupId;

    @ManyToOne(cascade = PERSIST)
    @JoinColumn(name = "F_COFFEE_ID")
    private Coffee coffee;

    @ManyToOne(cascade = REFRESH)
    @JoinColumn(name = "F_ORDER_ID")
    private Order order;

    public CoffeeCup() {
    }

    public CoffeeCup(Long coffeeCupId, Coffee coffee) {
        this.coffeeCupId = coffeeCupId;
        this.coffee = coffee;
    }

    public Long getCoffeeCupId() {
        return coffeeCupId;
    }

    public void setCoffeeCupId(Long coffeeCupId) {
        this.coffeeCupId = coffeeCupId;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoffeeCup coffeeCup = (CoffeeCup) o;

        return !(coffeeCupId != null ? !coffeeCupId.equals(coffeeCup.coffeeCupId) : coffeeCup.coffeeCupId != null);

    }

    @Override
    public int hashCode() {
        return coffeeCupId != null ? coffeeCupId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CoffeeCup{" +
                "coffeeCupId=" + coffeeCupId +
                '}';
    }
}
