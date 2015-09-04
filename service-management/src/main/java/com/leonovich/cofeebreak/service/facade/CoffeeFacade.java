package com.leonovich.cofeebreak.service.facade;

import com.leonovich.cofeebreak.model.CoffeeDTO;
import com.leonovich.cofeebreak.service.ICoffeeService;
import com.leonovich.cofeebreak.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alexanderleonovich on 29.08.15.
 * Facade layer for CoffeeService
 * @see com.leonovich.cofeebreak.service.CoffeeService
 */
@Service("coffeeFacade")
@Transactional
public class CoffeeFacade implements ICoffeeFacade {

    @Autowired
    private ICoffeeService coffeeService;

    @Override
    public CoffeeDTO getCofeeDTO(Long id) throws ServiceException {
        return coffeeService.getCofeeDTO(id);
    }

    @Override
    public List<CoffeeDTO> getAllCofeeDTOs() throws ServiceException {
        return coffeeService.getAllCofeeDTOs();
    }

    @Override
    public Boolean saveCofee(CoffeeDTO coffeeDTO) throws ServiceException {
        return coffeeService.saveCofee(coffeeDTO);
    }

    @Override
    public Boolean updateCofee(CoffeeDTO coffeeDTO) throws ServiceException {
        return coffeeService.updateCofee(coffeeDTO);
    }

    @Override
    public Boolean deleteCofee(Long id) throws ServiceException {
        return coffeeService.deleteCofee(id);
    }

    @Override
    public List<CoffeeDTO> findCoffee(String searchString) throws ServiceException {
        return coffeeService.findCoffee(searchString);
    }
}
