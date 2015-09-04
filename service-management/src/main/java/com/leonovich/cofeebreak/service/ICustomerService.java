package com.leonovich.cofeebreak.service;


import com.leonovich.cofeebreak.model.CustomerDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;

import java.util.List;

/**
 * Created by alexanderleonovich on 28.08.15.
 * Specific intarface for Customer entity service
 * @see CustomerService
 */
public interface ICustomerService {

    /**
     * Get CUSTOMER persisted object from database
     * by unique id and convert it in DTO-object
     * @param id - id of entity in database
     * @return DTO copy of object
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    CustomerDTO getCustomerDTO(Long id) throws ServiceException;

    /**
     * Get all CUSTOMER entities from database and
     * convert it in DTO objects
     * @return List of DTO objects
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    List<CustomerDTO> getAllCustomerDTOs() throws ServiceException;

    /**
     * Save new instance of CUSTOMER after convertation it from
     * DTO object
     * @param customerDTO object for convertation in CUSTOMER entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    Boolean saveCustomer(CustomerDTO customerDTO) throws ServiceException;

    /**
     * Update instance of CUSTOMER, what contains in
     * database after convertation it from DTO object
     * @param customerDTO object for convertation in CUSTOMER entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    Boolean updateCustomer(CustomerDTO customerDTO) throws ServiceException;

    /**
     * Delete persisted entity from database by unique id
     * @param id unique identifier of entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    Boolean deleteCustomer(Long id) throws ServiceException;

    /**
     * Get CUSTOMER persisted object from database
     * by unique login and convert it in DTO-object
     * @param login - unique login of entity in database
     * @return DTO copy of object
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    CustomerDTO getCustomerByLogin(String login) throws ServiceException;

}
