package com.leonovich.cofeebreak.domain;

import com.leonovich.cofeebreak.model.SailDTO;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by alexanderleonovich on 03.09.15.
 * Sail entity class. Contains sail options for application
 */
@Entity
@Table(name = "T_SAIL")
public class Sail implements Serializable {
    private static final long serialVersionUID = -2138803325534397895L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "F_ID")
    private Long id;

    @Column(name = "F_FREE_CUP")
    private Integer freeCup;

    @Column(name = "F_FREE_DELIVERY")
    private Double freeDelivery;

    @Column(name = "F_DELIVERY")
    private Double delivery;

    public Sail() {
    }

    public Sail(Long id, Integer freeCup, Double freeDelivery, Double delivery) {
        this.id = id;
        this.freeCup = freeCup;
        this.freeDelivery = freeDelivery;
        this.delivery = delivery;
    }

    public Sail(SailDTO sailDTO) {
        this.id = sailDTO.getId();
        this.freeCup = sailDTO.getFreeCup();
        this.freeDelivery = sailDTO.getFreeDelivery();
        this.delivery = sailDTO.getDelivery();
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

        Sail sail = (Sail) o;

        if (freeCup != null ? !freeCup.equals(sail.freeCup) : sail.freeCup != null) return false;
        if (freeDelivery != null ? !freeDelivery.equals(sail.freeDelivery) : sail.freeDelivery != null) return false;
        return !(delivery != null ? !delivery.equals(sail.delivery) : sail.delivery != null);

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
        return "Sail{" +
                "id=" + id +
                ", freeCup=" + freeCup +
                ", freeDelivery=" + freeDelivery +
                ", delivery=" + delivery +
                '}';
    }
}
