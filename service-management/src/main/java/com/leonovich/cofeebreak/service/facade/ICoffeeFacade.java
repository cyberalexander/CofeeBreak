package com.leonovich.cofeebreak.service.facade;

import com.leonovich.cofeebreak.model.CoffeeDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;

import java.util.List;

/**
 * Created by alexanderleonovich on 29.08.15.
 * Interface using facade pattern for CoffeFacade class.
 * @see CoffeeFacade
 */
public interface ICoffeeFacade {

    CoffeeDTO getCofeeDTO(Long id) throws ServiceException;

    List<CoffeeDTO> getAllCofeeDTOs() throws ServiceException;

    Boolean saveCofee(CoffeeDTO coffeeDTO) throws ServiceException;

    Boolean updateCofee(CoffeeDTO coffeeDTO) throws ServiceException;

    Boolean deleteCofee(Long id) throws ServiceException;

    List<CoffeeDTO> findCoffee(String searchString) throws ServiceException;
}
