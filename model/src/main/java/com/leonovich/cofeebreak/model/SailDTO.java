package com.leonovich.cofeebreak.model;

import java.io.Serializable;

/**
 * Created by alexanderleonovich on 03.09.15.
 * DTO copy of Sail entity class. Contains sail options for application
 */
public class SailDTO implements Serializable {
    private static final long serialVersionUID = 289489995883641018L;
    private Long id;
    private Integer freeCup;
    private Double freeDelivery;
    private Double delivery;

    public SailDTO() {
    }

    public SailDTO(Long id, Integer freeCup, Double freeDelivery, Double delivery) {
        this.id = id;
        this.freeCup = freeCup;
        this.freeDelivery = freeDelivery;
        this.delivery = delivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFreeCup() {
        return freeCup;
    }

    public void setFreeCup(Integer freeCup) {
        this.freeCup = freeCup;
    }

    public Double getFreeDelivery() {
        return freeDelivery;
    }

    public void setFreeDelivery(Double freeDelivery) {
        this.freeDelivery = freeDelivery;
    }

    public Double getDelivery() {
        return delivery;
    }

    public void setDelivery(Double delivery) {
        this.delivery = delivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SailDTO sailDTO = (SailDTO) o;

        if (freeCup != null ? !freeCup.equals(sailDTO.freeCup) : sailDTO.freeCup != null) return false;
        if (freeDelivery != null ? !freeDelivery.equals(sailDTO.freeDelivery) : sailDTO.freeDelivery != null)
            return false;
        return !(delivery != null ? !delivery.equals(sailDTO.delivery) : sailDTO.delivery != null);

    }

    @Override
    public int hashCode() {
        int result = freeCup != null ? freeCup.hashCode() : 0;
        result = 31 * result + (freeDelivery != null ? freeDelivery.hashCode() : 0);
        result = 31 * result + (delivery != null ? delivery.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SailDTO{" +
                "id=" + id +
                ", freeCup=" + freeCup +
                ", freeDelivery=" + freeDelivery +
                ", delivery=" + delivery +
                '}';
    }
}
