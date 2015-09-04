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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static com.leonovich.cofeebreak.util.TestConstants.TestConst.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Test class for test methods in InquiryService.class. Mockito used.
 * Created 31.08.15.
 * @author Alexander Leonovich
 * @version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {
    private static Logger logger = Logger.getLogger(AddressServiceTest.class);

    @Mock
    private IGenericDao<Address, Long> addressDao;
    @Mock
    private ICustomerDao customerDao;
    @Mock
    private DtoConverter converter;
    @InjectMocks
    private IAddressService addressService = new AddressService();

    private Customer customerI;
    private Address objectII;
    private AddressDTO objectDTOI;
    private AddressDTO objectDTOII;
    private List<AddressDTO> objectDTOs;

    @Before
    public void setUp() throws Exception {
        customerI = new Customer(ONE, "testFirstName_1", "testLastName_1", TEST_LOGIN_1, "testPassword_1");
        customerI.setAddresses(Arrays.asList(objectII));
        objectII = new Address(TWO, "testStreet_2", 200, 199);
        objectDTOI = new AddressDTO(ONE, "testStreet_1", 100, 99);
        objectDTOII = new AddressDTO(TWO, "testStreet_2", 200, 199);
        objectDTOs = Arrays.asList(objectDTOI, objectDTOII);
    }

    @Test
    public void testGetAddressDTOsByCustomerLoginStub()
            throws DaoException, ServiceException {
        try {
            stub(customerDao
                    .getByLogin(anyString()))
                    .toReturn(customerI);
            stub(addressService
                    .getAddressDTOsByCustomerLogin(anyString()))
                    .toReturn(objectDTOs);
            assertEquals(objectDTOs, addressService
                    .getAddressDTOsByCustomerLogin(anyString()));
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testGetAddressDTOsByCustomerLoginVerify() throws DaoException, ServiceException {
        try {
            stub(customerDao.getByLogin(anyString())).toReturn(customerI);
            addressService.getAddressDTOsByCustomerLogin(anyString());
            verify(customerDao).getByLogin(anyString());
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test(expected = ServiceException.class)
    public void testGetAddressDTOsByCustomerLoginException() throws DaoException, ServiceException {
        when(customerDao.getByLogin(anyString())).thenThrow(new DaoException());
        addressService.getAddressDTOsByCustomerLogin(anyString());
    }


    @Test
    public void testSaveAddressVerify() throws DaoException, ServiceException{
        try {
            addressService.saveAddress(objectDTOI, anyString());
            verify(addressDao).add(any(Address.class));
            verify(customerDao).getByLogin(anyString());
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }
}
