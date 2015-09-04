package com.leonovich.cofeebreak.service;

import com.leonovich.cofeebreak.model.CoffeeDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;

import java.util.List;

/**
 * Created by alexanderleonovich on 01.09.15.
 * Specific intarface for Order entity service
 * @see OrderService
 */
public interface IOrderService {

    /**
     * Save new instance of Order after convertation it from
     * DTO object
     * @param login unique login of Customer, who create order
     * @param coffeeDTOs objects of CoffeeDTO for adding in order
     * @param price total price of Order
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    Long saveOrder(String login, List<CoffeeDTO> coffeeDTOs, Double price) throws ServiceException;

}
