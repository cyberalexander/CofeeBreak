package com.leonovich.cofeebreak.service.facade;

import com.leonovich.cofeebreak.model.CoffeeDTO;
import com.leonovich.cofeebreak.service.IOrderService;
import com.leonovich.cofeebreak.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexanderleonovich on 01.09.15.
 * Facade layer for OrderService
 * @see com.leonovich.cofeebreak.service.OrderService
 */
@Service
public class OrderFacade implements IOrderFacade {

    @Autowired
    private IOrderService orderService;

    @Override
    public Long saveOrder(String login, List<CoffeeDTO> coffeeDTOs, Double price) throws ServiceException {
        return orderService.saveOrder(login, coffeeDTOs, price);
    }
}
