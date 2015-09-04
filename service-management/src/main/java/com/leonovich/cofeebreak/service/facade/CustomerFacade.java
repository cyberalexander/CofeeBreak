package com.leonovich.cofeebreak.service.facade;

import com.leonovich.cofeebreak.model.CustomerDTO;
import com.leonovich.cofeebreak.service.ICustomerService;
import com.leonovich.cofeebreak.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Facade layer for CustomerService
 * @see com.leonovich.cofeebreak.service.CustomerService
 * Created by alexanderleonovich on 28.08.15.
 */
@Service("customerFacade")
@Transactional
public class CustomerFacade implements ICustomerFacade{

    @Autowired
    private ICustomerService customerService;

    @Override
    public Boolean saveCustomer(CustomerDTO customerDTO) throws ServiceException {
        return customerService.saveCustomer(customerDTO);
    }

    @Override
    public CustomerDTO getCustomerDTOByLogin(String login) throws ServiceException {
        return customerService.getCustomerByLogin(login);
    }
}
