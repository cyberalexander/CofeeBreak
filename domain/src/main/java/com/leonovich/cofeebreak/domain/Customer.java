package com.leonovich.cofeebreak.domain;

import com.leonovich.cofeebreak.domain.enums.RoleEnum;
import com.leonovich.cofeebreak.model.CustomerDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.LAZY;

/**
 * Created by alexanderleonovich on 27.08.15.
 * Domain entity Customer
 */
@Entity
@Table(name = "T_CUSTOMER")
public class Customer implements Serializable {
    private static final long serialVersionUID = 3981886551884753881L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_CUSTOMER_ID")
    private Long customerId;

    @Column(name = "F_FIRST_NAME")
    private String firstName;

    @Column(name = "F_LAST_NAME")
    private String lastName;

    @Column(name = "F_LOGIN", unique = true, nullable = false)
    private String login;

    @Column(name = "F_PASSWORD", nullable = false, updatable = false)
    private String password;

    @Column(name = "F_ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @OneToMany(mappedBy = "customer", fetch = LAZY, cascade = {REFRESH, REMOVE})
    private List<Address> addresses;

    @OneToMany(mappedBy = "customer", fetch = LAZY, cascade = {REFRESH, REMOVE})
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Customer(CustomerDTO customerDTO) {
        this.customerId = customerDTO.getCustomerId();
        this.firstName = customerDTO.getFirstName();
        this.lastName = customerDTO.getLastName();
        this.login = customerDTO.getLogin();
        this.password = customerDTO.getPassword();
    }

    public Customer(Long customerId, String firstName, String lastName, String login, String password) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public Customer(Long customerId, String firstName, String lastName, String login, String password, RoleEnum role) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
        if (login != null ? !login.equals(customer.login) : customer.login != null) return false;
        return !(password != null ? !password.equals(customer.password) : customer.password != null);

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

