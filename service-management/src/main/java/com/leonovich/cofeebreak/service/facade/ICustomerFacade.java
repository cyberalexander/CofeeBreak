package com.leonovich.cofeebreak.service.facade;

import com.leonovich.cofeebreak.model.CustomerDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;

/**
 * Interface using facade pattern for CustomerFacade class.
 * @see CustomerFacade
 * Created by alexanderleonovich on 28.08.15.
 */
public interface ICustomerFacade {

    Boolean saveCustomer(CustomerDTO customerDTO) throws ServiceException;

    CustomerDTO getCustomerDTOByLogin(String login) throws ServiceException;
}
