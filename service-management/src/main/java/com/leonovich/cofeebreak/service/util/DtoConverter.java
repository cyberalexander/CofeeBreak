package com.leonovich.cofeebreak.service.util;

import com.leonovich.cofeebreak.domain.*;
import com.leonovich.cofeebreak.model.*;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.leonovich.cofeebreak.service.util.ServiceConstants.Const.ZERO;

/**
 * Custom class - converter from Persisted entity to DTO object
 * Created by alexanderleonovich on 29.08.15.
 */
@Component
public class DtoConverter {

    public DtoConverter() {
    }

    /**
     * Method create new instance of DTO object form
     * persisted instance of Address entity
     * @param address object for convertation
     * @return DTO Address object
     */
    public AddressDTO createAddressDTO(Address address) {
        return new AddressDTO(
                address.getAddressId(),
                address.getStreet(),
                address.getHouse(),
                address.getApartment(),
                address.getCustomer().getCustomerId());
    }

    /**
     * Method create new instance of DTO object form
     * persisted instance of Customer entity
     * @param customer object for convertation
     * @return DTO Customer object
     */
    public CustomerDTO createCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getLogin(),
                customer.getPassword());
        return customerDTO;
    }

    /**
     * Method create new instance of DTO object form
     * persisted instance of Coffee entity
     * @param coffee object for convertation
     * @return DTO Coffee object
     */
    public CoffeeDTO createCoffeeDTO(Coffee coffee) {
        CoffeeDTO coffeeDTO = new CoffeeDTO(
                coffee.getCoffeeId(),
                coffee.getSort(),
                coffee.getDescription(),
                coffee.getCost());
        Hibernate.initialize(coffee.getCoffeeCups());
        coffeeDTO.setNumberOfCups(coffee.getCoffeeCups().size());
        return coffeeDTO;
    }

    /**
     * Method create new instance of DTO object form
     * persisted instance of Order entity
     * @param order object for convertation
     * @return DTO Order object
     */
    public OrderDTO createOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO(
                order.getOrderId(),
                order.getOrderDate(),
                order.getTotalPrice(),
                order.getCustomer().getCustomerId());
        return orderDTO;
    }

    /**
     * Method create new instance of DTO object form
     * persisted instance of Sail entity
     * @param sail object for convertation
     * @return DTO Sail object
     */
    public SailDTO createSailDTO(Sail sail) {
        SailDTO sailDTO = new SailDTO(
                sail.getId(),
                sail.getFreeCup(),
                sail.getFreeDelivery(),
                sail.getDelivery());
        return sailDTO;
    }


    /**
     * Util method for convert List Persisted ojects
     * in DTO objects
     * @param customers list of entities
     * @return list of DTO objects
     */
    public List<CustomerDTO> convertToCustomerDTOlist(List<Customer> customers){
        List<CustomerDTO> customerDTOs = new ArrayList<>(
                customers != null ? customers.size() : ZERO);
        if (customers != null) {
            for (Customer customer : customers) {
                customerDTOs.add(createCustomerDTO(customer));
            }
        }
        return customerDTOs;
    }

    /**
     * Util method for convert List Persisted ojects
     * in DTO objects
     * @param addresses list of entities
     * @return list of DTO objects
     */
    public List<AddressDTO> convertToAddressDTOlist(List<Address> addresses){
        List<AddressDTO> addressDTOs = new ArrayList<>(
                addresses != null ? addresses.size() : ZERO);
        if (addresses != null) {
            for (Address address : addresses) {
                addressDTOs.add(
                        createAddressDTO(address));
            }
        }
        return addressDTOs;
    }

    /**
     * Util method for convert List Persisted ojects
     * in DTO objects
     * @param coffees list of entities
     * @return list of DTO objects
     */
    public List<CoffeeDTO> convertToCoffeeDTOlist(List<Coffee> coffees){
        List<CoffeeDTO> coffeeDTOs = new ArrayList<>(
                coffees != null ? coffees.size() : ZERO);
        if (coffees != null) {
            for (Coffee coffee : coffees) {
                coffeeDTOs.add(createCoffeeDTO(coffee));
            }
        }
        return coffeeDTOs;
    }

    /**
     * Util method for convert List Persisted ojects
     * in DTO objects
     * @param orders list of entities
     * @return list of DTO objects
     */
    public List<OrderDTO> convertToOrderDTOlist(List<Order> orders){
        List<OrderDTO> orderDTOs = new ArrayList<>(
                orders != null ? orders.size() : ZERO);
        if (orders != null) {
            for (Order order : orders) {
                orderDTOs.add(createOrderDTO(order));
            }
        }
        return orderDTOs;
    }
}
