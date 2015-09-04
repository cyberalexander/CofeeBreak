package com.leonovich.cofeebreak.service.facade;

import com.leonovich.cofeebreak.model.AddressDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;

import java.util.List;

/**
 * Interface using facade pattern for AddressFacade class.
 * @see AddressFacade
 * Created by alexanderleonovich on 28.08.15.
 */
public interface IAddressFacade {

    List<AddressDTO> getAddressDTOsByCustomerLogin(String login) throws ServiceException;

    Boolean saveAddress(AddressDTO addressDTO, String login) throws ServiceException;
}
