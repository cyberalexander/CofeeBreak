package com.leonovich.cofeebreak.service;

import com.leonovich.cofeebreak.dao.ICustomerDao;
import com.leonovich.cofeebreak.dao.IGenericDao;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Coffee;
import com.leonovich.cofeebreak.domain.CoffeeCup;
import com.leonovich.cofeebreak.domain.Customer;
import com.leonovich.cofeebreak.domain.Order;
import com.leonovich.cofeebreak.model.CoffeeDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.leonovich.cofeebreak.service.exception.ServiceExceptionCode.SERVICE_14;
import static com.leonovich.cofeebreak.service.util.ServiceConstants.Const.COFFEE_CUP;
import static com.leonovich.cofeebreak.service.util.ServiceConstants.Const.ZERO;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * Created by alexanderleonovich on 02.09.15.
 * Service class, for do operations
 * with Order entity on Service layer
 * In this class entity convert to DTO object
 */
@Service
@Transactional(propagation = REQUIRED, readOnly = false)
public class OrderService implements IOrderService {
    private static Logger logger = Logger.getLogger(OrderService.class);

    @Autowired
    private IGenericDao<Order, Long> orderDao;
    @Autowired
    private ICustomerDao customerDao;

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
    @Override
    public Long saveOrder(String login, List<CoffeeDTO> coffeeDTOs,
                          Double price) throws ServiceException {
        Order order = new Order();
        try {
            Customer customer = customerDao.getByLogin(login);
            order.setTotalPrice(price);
            order.setCustomer(customer);
            order.setCoffeeCups(createCoffeeCupList(coffeeDTOs, order));
            return orderDao.add(order);
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_14);
        }
    }

    /**
     * inner method, what create from CoffeDTOs list
     * list of CoffeeCups
     * @param coffeeDTOs - list of CoffeeDTOs
     * @param order - object of Order, in what we set coffecups
     * @return coffecups list
     */
    private List<CoffeeCup> createCoffeeCupList(
            List<CoffeeDTO> coffeeDTOs, Order order) {
        List<CoffeeCup> coffeeCups = new ArrayList<>();
        for (CoffeeDTO coffeeDTO : coffeeDTOs) {
            Coffee coffee = new Coffee(coffeeDTO);
            for (int i = ZERO; i < coffeeDTO.getNumberOfCups(); i++) {
                CoffeeCup coffeeCup = new CoffeeCup();
                coffeeCup.setCoffee(coffee);
                coffeeCup.setOrder(order);
                logger.info(COFFEE_CUP + coffeeCup.toString());
                coffeeCups.add(coffeeCup);
            }
        }
        return coffeeCups;
    }
}
