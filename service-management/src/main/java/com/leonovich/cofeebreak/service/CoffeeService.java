package com.leonovich.cofeebreak.service;

import com.leonovich.cofeebreak.dao.ICoffeeDao;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Coffee;
import com.leonovich.cofeebreak.model.CoffeeDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;
import com.leonovich.cofeebreak.service.exception.ServiceExceptionCode;
import com.leonovich.cofeebreak.service.util.DtoConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.leonovich.cofeebreak.service.exception.ServiceExceptionCode.*;
import static com.leonovich.cofeebreak.service.util.ServiceConstants.Const.*;
import static org.springframework.transaction.annotation.Propagation.*;

/**
 * Service class, for do operations
 * with Coffee entity on Service layer
 * In this class entity convert to DTO object
 * Created by alexanderleonovich on 16.08.15.
 */
@Service("coffeeService")
@Transactional(propagation = REQUIRED, readOnly = false)
public class CoffeeService implements ICoffeeService {
    private static Logger logger = Logger.getLogger(CoffeeService.class);

    @Autowired
    private ICoffeeDao coffeeDao;
    @Autowired
    private DtoConverter converter;

    public CoffeeService() {
    }


    /**
     * Get Coffee persisted object from database
     * by unique id and convert it in DTO-object
     * @param id - id of entity in database
     * @return DTO copy of object
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = SUPPORTS, readOnly = true)
    public CoffeeDTO getCofeeDTO(Long id) throws ServiceException {
        Coffee coffee;
        try {
            coffee = coffeeDao.get(id);
            logger.info(RECEIVED_COFFEE + coffee);
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_03);
        }
        return converter.createCoffeeDTO(coffee);
    }

    /**
     * Get all Coffee entities from database and
     * convert it in DTO objects
     * @return List of DTO objects
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = SUPPORTS, readOnly = true)
    public List<CoffeeDTO> getAllCofeeDTOs() throws ServiceException {
        List<Coffee> cofies;
        try {
            cofies = coffeeDao.getAll();
            logger.info(RECEIVE_ALL_COFFIES + cofies.size());
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_04);
        }
        return converter.convertToCoffeeDTOlist(cofies);
    }

    /**
     * Save new instance of Coffee after convertation it from
     * DTO object
     * @param coffeeDTO object for convertation in Coffee entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    public Boolean saveCofee(CoffeeDTO coffeeDTO) throws ServiceException {
        Coffee coffee = new Coffee(coffeeDTO);
        try {
            coffeeDao.add(coffee);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_05);
        }
    }

    /**
     * Update instance of Coffee, what contains in
     * database after convertation it from DTO object
     * @param coffeeDTO object for convertation in Coffee entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = REQUIRES_NEW, readOnly = false)
    public Boolean updateCofee(CoffeeDTO coffeeDTO) throws ServiceException {
        Coffee coffee = new Coffee(coffeeDTO);
        try {
            coffeeDao.update(coffee);
            logger.info(UPDATING_COFFEE + coffee);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_06);
        }
    }

    /**
     * Delete persisted entity from database by unique id
     * @param id unique identifier of entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    public Boolean deleteCofee(Long id) throws ServiceException {
        Coffee coffee;
        try {
            coffee = coffeeDao.get(id);
            coffeeDao.delete(coffee);
            logger.info(DELETE_COFFEE + coffee);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_07);
        }
    }

    /**
     * Get list of Coffee entities by search parameter
     * from database and convert it in DTO objects
     * @return List of DTO objects
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = SUPPORTS, readOnly = true)
    public List<CoffeeDTO> findCoffee(String searchString) throws ServiceException {
        List<Coffee> coffies;
        try {
            coffies = coffeeDao.findCoffee(searchString);
            logger.info(FIND_COFFEE + coffies.size());
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceExceptionCode.SERVICE_17);
        }
        return converter.convertToCoffeeDTOlist(coffies);
    }
}
