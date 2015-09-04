package com.leonovich.cofeebreak.service.facade;

import com.leonovich.cofeebreak.model.AddressDTO;
import com.leonovich.cofeebreak.service.IAddressService;
import com.leonovich.cofeebreak.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexanderleonovich on 01.09.15.
 * Facade layer for AddressService
 * @see com.leonovich.cofeebreak.service.AddressService
 */
@Service
public class AddressFacade implements IAddressFacade {

    @Autowired
    private IAddressService addressService;

    @Override
    public List<AddressDTO> getAddressDTOsByCustomerLogin(String login) throws ServiceException {
        return addressService.getAddressDTOsByCustomerLogin(login);
    }

    @Override
    public Boolean saveAddress(AddressDTO addressDTO, String login) throws ServiceException {
        return addressService.saveAddress(addressDTO, login);
    }
}
