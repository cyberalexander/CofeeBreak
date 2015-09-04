package com.leonovich.cofeebreak.service;

import com.leonovich.cofeebreak.model.SailDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;

/**
 * Created by alexanderleonovich on 03.09.15.
 * Specific intarface for Sail entity service
 * @see SailService
 */
public interface ISailService {

    /**
     * Get Sail persisted object from database
     * by unique id and convert it in DTO-object
     * @param id - id of entity in database
     * @return DTO copy of object
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    SailDTO getSailDTO(Long id) throws ServiceException;

    /**
     * Update instance of Sail after convertation it from
     * DTO object
     * @param sailDTO object for convertation in Sail entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    void updateSail(SailDTO sailDTO) throws ServiceException;
}
