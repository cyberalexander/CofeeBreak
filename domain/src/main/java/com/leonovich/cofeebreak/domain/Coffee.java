package com.leonovich.cofeebreak.domain;

import com.leonovich.cofeebreak.model.CoffeeDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by alexanderleonovich on 27.08.15.
 * Domain entity Coffee
 */
@Entity
@Table(name = "T_COFFEE")
public class Coffee implements Serializable {
    private static final long serialVersionUID = -4045723470873420067L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "F_COFFEE_ID")
    private Long coffeeId;

    @Column(name = "F_SORT")
    private String sort;

    @Column(name = "F_DESCRIPTION")
    private String description;

    @Column(name = "F_COST")
    private Double cost;

    @OneToMany(mappedBy = "coffee", fetch = LAZY, cascade = {ALL})
    private List<CoffeeCup> coffeeCups;

    public Coffee() {
    }

    public Coffee(Long coffeeId, String sort, String description, Double cost) {
        this.coffeeId = coffeeId;
        this.sort = sort;
        this.description = description;
        this.cost = cost;
    }

    public Coffee(CoffeeDTO coffeeDTO) {
        this.coffeeId = coffeeDTO.getCoffeeId();
        this.sort = coffeeDTO.getSort();
        this.description = coffeeDTO.getDescription();
        this.cost = coffeeDTO.getCost();
    }

    public Long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(Long coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    /*public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }*/

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public List<CoffeeCup> getCoffeeCups() {
        return coffeeCups;
    }

    public void setCoffeeCups(List<CoffeeCup> coffeeCups) {
        this.coffeeCups = coffeeCups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coffee coffee = (Coffee) o;

        if (coffeeId != null ? !coffeeId.equals(coffee.coffeeId) : coffee.coffeeId != null) return false;
        if (sort != null ? !sort.equals(coffee.sort) : coffee.sort != null) return false;
        if (description != null ? !description.equals(coffee.description) : coffee.description != null) return false;
        return !(cost != null ? !cost.equals(coffee.cost) : coffee.cost != null);

    }

    @Override
    public int hashCode() {
        int result = coffeeId != null ? coffeeId.hashCode() : 0;
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "coffeeId=" + coffeeId +
                ", sort='" + sort + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
