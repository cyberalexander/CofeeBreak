package com.leonovich.cofeebreak.domain;

import com.leonovich.cofeebreak.model.AddressDTO;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by alexanderleonovich on 27.08.15.
 * Domain entity Address
 */
@Entity
@Table(name = "T_ADDRESS")
public class Address implements Serializable {

    private static final long serialVersionUID = 111197073224479438L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "F_ADDRESS_ID")
    private Long addressId;

    @Column(name = "F_STREET")
    private String street;

    @Column(name = "F_HOUSE")
    private Integer house;

    @Column(name = "F_APARTMENT")
    private Integer apartment;

    @ManyToOne(cascade = REFRESH)
    @JoinColumn(name = "F_CUSTOMER_ID")
    private Customer customer;

    public Address() {
    }

    public Address(Long addressId, String street, Integer house, Integer apartment) {
        this.addressId = addressId;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public Address(AddressDTO addressDTO) {
        this.addressId = addressDTO.getAddressId();
        this.street = addressDTO.getStreet();
        this.house = addressDTO.getHouse();
        this.apartment = addressDTO.getApartment();
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (house != null ? !house.equals(address.house) : address.house != null) return false;
        return !(apartment != null ? !apartment.equals(address.apartment) : address.apartment != null);

    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (apartment != null ? apartment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", apartment=" + apartment +
                '}';
    }
}
