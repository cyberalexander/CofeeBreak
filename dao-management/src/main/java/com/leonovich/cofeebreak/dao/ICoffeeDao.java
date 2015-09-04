package com.leonovich.cofeebreak.dao;

import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Coffee;

import java.util.List;

/**
 * Interface for implementation by CoffeeDao class
 * for specific operations with Coffee-entity
 *
 * @see CoffeeDao
 * Created by alexanderleonovich on 04.09.15.
 */
public interface ICoffeeDao extends IGenericDao<Coffee, Long> {

    /**
     * Method find Coffee entity by search parameter
     * @param searchString unique search parameter
     * @return list of Coffee entities
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    List<Coffee> findCoffee(String searchString) throws DaoException;
}
