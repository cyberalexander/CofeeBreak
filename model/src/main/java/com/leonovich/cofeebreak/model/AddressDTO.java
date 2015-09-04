package com.leonovich.cofeebreak.model;

import java.io.Serializable;

/**
 * Created by alexanderleonovich on 27.08.15.
 * Data transfer object. Copy of domain entity Address
 */
public class AddressDTO implements Serializable {
    private static final long serialVersionUID = -4363167192576464317L;
    private Long addressId;
    private String street;
    private Integer house;
    private Integer apartment;
    private Long customerId;

    public AddressDTO() {
    }

    public AddressDTO(Long addressId, String street, Integer house, Integer apartment) {
        this.addressId = addressId;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public AddressDTO(Long addressId, String street, Integer house, Integer apartment, Long customerId) {
        this.addressId = addressId;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.customerId = customerId;
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

        AddressDTO that = (AddressDTO) o;

        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (house != null ? !house.equals(that.house) : that.house != null) return false;
        if (apartment != null ? !apartment.equals(that.apartment) : that.apartment != null) return false;
        return !(customerId != null ? !customerId.equals(that.customerId) : that.customerId != null);

    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (apartment != null ? apartment.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", apartment=" + apartment +
                ", customerId=" + customerId +
                '}';
    }
}
