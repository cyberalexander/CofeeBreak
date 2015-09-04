package com.leonovich.cofeebreak.service;

import com.leonovich.cofeebreak.model.AddressDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;

import java.util.List;

/**
 * Created by alexanderleonovich on 01.09.15.
 * Specific intarface for Address entity service
 * @see AddressService
 */
public interface IAddressService {

    /**
     * Method getting list of addresses by unique customer login
     * @param login unique customer login for search addresses of customer
     * @return list of addresses
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    List<AddressDTO> getAddressDTOsByCustomerLogin(String login) throws ServiceException;

    /**
     * Save new instance of Address after convertation it from
     * DTO object
     * @param addressDTO object for convertation in Address entity
     * @param login  unique customer login
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    Boolean saveAddress(AddressDTO addressDTO, String login) throws ServiceException;

}
