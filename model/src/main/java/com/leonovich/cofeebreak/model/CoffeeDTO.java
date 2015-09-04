package com.leonovich.cofeebreak.model;

import java.io.Serializable;

/**
 * Created by alexanderleonovich on 27.08.15.
 * Data transfer object. Copy of domain entity Coffee
 */
public class CoffeeDTO implements Serializable {
    private static final long serialVersionUID = 8342547667614066921L;
    private Long coffeeId;
    private String sort;
    private String description;
    private Double cost;
    private Integer numberOfCups;
    private Long orderId;

    public CoffeeDTO() {
    }

    public CoffeeDTO(Long coffeeId, String sort, String description, Double cost, Integer numberOfCups) {
        this.coffeeId = coffeeId;
        this.sort = sort;
        this.description = description;
        this.cost = cost;
        this.numberOfCups = numberOfCups;
    }

    public CoffeeDTO(Long coffeeId, String sort, String description, Double cost) {
        this.coffeeId = coffeeId;
        this.sort = sort;
        this.description = description;
        this.cost = cost;
    }

    public CoffeeDTO(Long coffeeId, String sort, Long orderId) {
        this.coffeeId = coffeeId;
        this.sort = sort;
        this.orderId = orderId;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getNumberOfCups() {
        return numberOfCups;
    }

    public void setNumberOfCups(Integer numberOfCups) {
        this.numberOfCups = numberOfCups;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoffeeDTO coffeeDTO = (CoffeeDTO) o;

        if (coffeeId != null ? !coffeeId.equals(coffeeDTO.coffeeId) : coffeeDTO.coffeeId != null) return false;
        if (sort != null ? !sort.equals(coffeeDTO.sort) : coffeeDTO.sort != null) return false;
        if (description != null ? !description.equals(coffeeDTO.description) : coffeeDTO.description != null)
            return false;
        if (cost != null ? !cost.equals(coffeeDTO.cost) : coffeeDTO.cost != null) return false;
        if (numberOfCups != null ? !numberOfCups.equals(coffeeDTO.numberOfCups) : coffeeDTO.numberOfCups != null)
            return false;
        return !(orderId != null ? !orderId.equals(coffeeDTO.orderId) : coffeeDTO.orderId != null);

    }

    @Override
    public int hashCode() {
        int result = coffeeId != null ? coffeeId.hashCode() : 0;
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (numberOfCups != null ? numberOfCups.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CoffeeDTO{" +
                "coffeeId=" + coffeeId +
                ", sort='" + sort + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", numberOfCups=" + numberOfCups +
                ", orderId=" + orderId +
                '}';
    }
}
