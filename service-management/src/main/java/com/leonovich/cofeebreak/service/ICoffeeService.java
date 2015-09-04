package com.leonovich.cofeebreak.service;


import com.leonovich.cofeebreak.model.CoffeeDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;

import java.util.List;

/**
 * Created by alexanderleonovich on 28.08.15.
 * Specific intarface for Coffee entity service
 * @see CoffeeService
 */
public interface ICoffeeService {

    /**
     * Get Coffee persisted object from database
     * by unique id and convert it in DTO-object
     * @param id - id of entity in database
     * @return DTO copy of object
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    CoffeeDTO getCofeeDTO(Long id) throws ServiceException;

    /**
     * Get all Coffee entities from database and
     * convert it in DTO objects
     * @return List of DTO objects
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    List<CoffeeDTO> getAllCofeeDTOs() throws ServiceException;

    /**
     * Save new instance of Coffee after convertation it from
     * DTO object
     * @param coffeeDTO object for convertation in Coffee entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    Boolean saveCofee(CoffeeDTO coffeeDTO) throws ServiceException;

    /**
     * Update instance of Coffee, what contains in
     * database after convertation it from DTO object
     * @param coffeeDTO object for convertation in Coffee entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    Boolean updateCofee(CoffeeDTO coffeeDTO) throws ServiceException;

    /**
     * Delete persisted entity from database by unique id
     * @param id unique identifier of entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    Boolean deleteCofee(Long id) throws ServiceException;

    /**
     * Get list of Coffee entities by search parameter
     * from database and convert it in DTO objects
     * @return List of DTO objects
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    List<CoffeeDTO> findCoffee(String searchString) throws ServiceException;
}
