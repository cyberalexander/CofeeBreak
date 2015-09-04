package com.leonovich.cofeebreak.service;

import com.leonovich.cofeebreak.dao.ICustomerDao;
import com.leonovich.cofeebreak.dao.IGenericDao;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Address;
import com.leonovich.cofeebreak.domain.Customer;
import com.leonovich.cofeebreak.model.AddressDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;
import com.leonovich.cofeebreak.service.util.DtoConverter;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.leonovich.cofeebreak.service.exception.ServiceExceptionCode.SERVICE_01;
import static com.leonovich.cofeebreak.service.exception.ServiceExceptionCode.SERVICE_02;
import static com.leonovich.cofeebreak.service.util.ServiceConstants.Const.CUSTOMER_ADDRESSES;
import static com.leonovich.cofeebreak.service.util.ServiceConstants.Const.PERSIST_ADDRESS;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;
import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

/**
 * Created by alexanderleonovich on 01.09.15.
 * Service class, for do operations
 * with Address entity on Service layer
 * In this class entity convert to DTO object
 */
@Service
@Transactional(propagation = REQUIRED, readOnly = false)
public class AddressService implements IAddressService {
    private static Logger logger = Logger.getLogger(CustomerService.class);

    @Autowired
    private IGenericDao<Address, Long> addressDao;
    @Autowired
    private ICustomerDao customerDao;
    @Autowired
    private DtoConverter converter;

    public AddressService() {
    }

    /**
     * Method getting list of addresses by unique customer login
     * @param login unique customer login for search addresses of customer
     * @return list of addresses
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = SUPPORTS, readOnly = true)
    public List<AddressDTO> getAddressDTOsByCustomerLogin(
            String login) throws ServiceException {
        Customer customer;
        try {
            customer = customerDao.getByLogin(login);
            Hibernate.initialize(customer.getAddresses());
            logger.info(CUSTOMER_ADDRESSES
                    + customer.getAddresses().size());
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_01);
        }
        List<Address> addresses = customer.getAddresses();
        return converter.convertToAddressDTOlist(addresses);
    }

    /**
     * Save new instance of Address after convertation it from
     * DTO object
     * @param addressDTO object for convertation in Address entity
     * @param login  unique customer login
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    public Boolean saveAddress(AddressDTO addressDTO,
                               String login) throws ServiceException {
        Address address = new Address(addressDTO);
        try {
            address.setCustomer(customerDao.getByLogin(login));
            logger.info(PERSIST_ADDRESS + address);
            addressDao.add(address);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_02);
        }
    }
}
