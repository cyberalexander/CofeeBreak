package com.leonovich.cofeebreak.service;

import com.leonovich.cofeebreak.dao.ICustomerDao;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Customer;
import com.leonovich.cofeebreak.model.CustomerDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;
import com.leonovich.cofeebreak.service.util.DtoConverter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.leonovich.cofeebreak.domain.enums.RoleEnum.ROLE_USER;
import static com.leonovich.cofeebreak.service.exception.ServiceExceptionCode.*;
import static com.leonovich.cofeebreak.service.util.ServiceConstants.Const.*;
import static org.springframework.transaction.annotation.Propagation.*;

/**
 * Service class, for do operations
 * with Customer entity on Service layer
 * In this class entity convert to DTO object
 * Created by alexanderleonovich on 29.08.15.
 */
@Transactional(propagation = REQUIRED, readOnly = false)
@Service("customerService")
public class CustomerService implements ICustomerService {
    private static Logger logger = Logger.getLogger(CustomerService.class);

    @Autowired
    private ICustomerDao customerDao;
    @Autowired
    private DtoConverter converter;

    public CustomerService() {
    }

    /**
     * Method get Customer persisted object from database
     * by unique id and convert it in DTO-object
     *
     * @param id - id of entity in database
     * @return DTO copy of object
     * @throws ServiceException - custom Exception class
     *                          for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = SUPPORTS, readOnly = true)
    public CustomerDTO getCustomerDTO(Long id) throws ServiceException {
        Customer customer;
        try {
            customer = customerDao.get(id);
            logger.info(RECEIVED_CUSTOMER + customer);
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_08);
        }
        return converter.createCustomerDTO(customer);
    }

    /**
     * This method get all Customer entities from database and
     * convert it in DTO objects
     *
     * @return List of DTO objects
     * @throws ServiceException - custom Exception class
     *                          for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = SUPPORTS, readOnly = true)
    public List<CustomerDTO> getAllCustomerDTOs() throws ServiceException {
        List<Customer> customers;
        try {
            customers = customerDao.getAll();
            logger.info(RECEIVE_ALL_CUSTOMERS + customers.size());
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_09);
        }
        return converter.convertToCustomerDTOlist(customers);
    }

    /**
     * Method for save new instance of Customer after convertation it from
     * DTO object
     *
     * @param customerDTO object for convertation in Customer entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     *                          for handle exceptions on SERVICE layer in application
     */
    @Override
    public Boolean saveCustomer(CustomerDTO customerDTO) throws ServiceException {
        Customer customer = new Customer(customerDTO);
        try {
            Customer testCustomer = customerDao.getByLogin((customer.getLogin()));
            if (null != testCustomer) {
                return false;
            } else {
                customer.setPassword(encodePassowrd(customer.getPassword()));
                customer.setRole(ROLE_USER);
                logger.info(PERSIST_CUSTOMER + customer);
                customerDao.add(customer);
                return true;
            }
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_10);
        }
    }

    /**
     * Update instance of Customer what contains in
     * database after convertation it from DTO object
     *
     * @param customerDTO object for convertation in Customer entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     *                          for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = REQUIRES_NEW, readOnly = false)
    public Boolean updateCustomer(CustomerDTO customerDTO) throws ServiceException {
        Customer customer = new Customer(customerDTO);
        try {
            customerDao.update(customer);
            logger.info(UPDATING_CUSTOMER + customer);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_11);
        }
    }

    /**
     * Delete persisted entity from database by unique id
     *
     * @param id unique identifier of entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     *                          for handle exceptions on SERVICE layer in application
     */
    @Override
    public Boolean deleteCustomer(Long id) throws ServiceException {
        Customer customer;
        try {
            customer = customerDao.get(id);
            customerDao.delete(customer);
            logger.info(DELETE_CUSTOMER + customer);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_12);
        }
    }

    /**
     * Get CUSTOMER persisted object from database
     * by unique login and convert it in DTO-object
     * @param login - unique login of entity in database
     * @return DTO copy of object
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = SUPPORTS, readOnly = true)
    public CustomerDTO getCustomerByLogin(String login) throws ServiceException {
        Customer customer;
        try {
            customer = customerDao.getByLogin(login);
            logger.info(RECEIVED_CUSTOMER_BY_LOGIN + customer);
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_13);
        }
        return converter.createCustomerDTO(customer);
    }

    /**
     * Inner method int this.class what encode password
     * in md5Hex format
     * @param passowrd - string with password for encode
     * @return encoded string password
     */
    private static String encodePassowrd(String passowrd) {
        String md5Hex = DigestUtils.md5Hex(passowrd);
        return md5Hex;
    }
}
