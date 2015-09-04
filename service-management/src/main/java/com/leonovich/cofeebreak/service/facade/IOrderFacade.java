package com.leonovich.cofeebreak.service.facade;

import com.leonovich.cofeebreak.model.CoffeeDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;

import java.util.List;

/**
 * Interface using facade pattern for OrderFacade class.
 * @see CustomerFacade
 * Created by alexanderleonovich on 28.08.15.
 */
public interface IOrderFacade {

    Long saveOrder(String login, List<CoffeeDTO> coffeeDTOs, Double price) throws ServiceException;

}
