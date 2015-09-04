package com.leonovich.cofeebreak.dao;

import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Customer;

/**
 * Interface for implementation by CustomerDao class
 * for specific operations with Customer-entity
 *
 * @see com.leonovich.cofeebreak.dao.CustomerDao
 * Created by alexanderleonovich on 28.08.15.
 */
public interface ICustomerDao extends IGenericDao<Customer, Long> {

    /**
     * Method get Customer entity by unique login
     * @param login unique identifier of Customer entity
     * @return Customer entity
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    Customer getByLogin(String login) throws DaoException;
}
