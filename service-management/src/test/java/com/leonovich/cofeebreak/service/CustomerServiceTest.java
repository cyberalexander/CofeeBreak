package com.leonovich.cofeebreak.service;


import com.leonovich.cofeebreak.dao.ICustomerDao;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Customer;
import com.leonovich.cofeebreak.model.CustomerDTO;
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
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Test class for test methods in InquiryService.class. Mockito used.
 * Created 31.08.15.
 * @author Alexander Leonovich
 * @version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    private static Logger logger = Logger.getLogger(CustomerServiceTest.class);

    @Mock
    private ICustomerDao customerDao;
    @Mock
    private DtoConverter converter;
    @InjectMocks
    private ICustomerService customerService = new CustomerService();

    private Customer customerI;
    private Customer customerII;
    private CustomerDTO customerDTOI;
    private CustomerDTO customerDTOII;
    private CustomerDTO customerDTOIII;
    private List<CustomerDTO> customerDTOs;

    @Before
    public void setUp() throws Exception {
        customerI = new Customer(ONE, "testFirstName_1", "testLastName_1", TEST_LOGIN_1, "testPassword_1");
        customerII = new Customer(TWO, "testFirstName_2", "testLastName_2", TEST_LOGIN_2, "testPassword_2");
        customerDTOI = new CustomerDTO(ONE, "testFirstName_1", "testLastName_1", TEST_LOGIN_1, "testPassword_1");
        customerDTOII = new CustomerDTO(TWO, "testFirstName_2", "testLastName_2", TEST_LOGIN_2, "testPassword_2");
        customerDTOIII = new CustomerDTO(THREE, "testFirstName_3", "testLastName_3", TEST_LOGIN_3, "testPassword_3");
        customerDTOs = Arrays.asList(customerDTOI, customerDTOII);
    }

    @Test
    public void testGetCustomerDTOStub() throws DaoException, ServiceException {
        try {
            stub(customerService.getCustomerDTO(customerDTOI.getCustomerId()))
                    .toReturn(customerDTOI);
            assertEquals(customerDTOI, customerService.getCustomerDTO(customerDTOI
                    .getCustomerId()));
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testGetCustomerDTOVerify() throws DaoException, ServiceException {
        try {
            customerService.getCustomerDTO(anyLong());
            verify(customerDao).get(anyLong());
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test(expected = ServiceException.class)
    public void testGetCustomerDTOException() throws DaoException, ServiceException {
        when(customerDao.get(anyLong())).thenThrow(new DaoException());
        customerService.getCustomerDTO(anyLong());
    }

    @Test
    public void testGetAllCustomerDTOsStub() throws DaoException, ServiceException{
        try{
            stub(customerService.getAllCustomerDTOs()).toReturn(customerDTOs);
            assertEquals(customerDTOs, customerService.getAllCustomerDTOs());
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testSaveCustomerVerify() throws DaoException, ServiceException{
        try {
            customerService.saveCustomer(customerDTOIII);
            verify(customerDao).add(any(Customer.class));
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testUpdateCustomer() throws DaoException, ServiceException{
        customerI.setFirstName(customerII.getFirstName());
        customerDTOI.setFirstName((customerDTOII.getFirstName()));
        try {
            customerService.updateCustomer(customerDTOI);
            verify(customerDao).update(any(Customer.class));
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testDeleteCustomer() throws DaoException, ServiceException {
        try {
            doNothing().when(customerDao).delete(customerII);
            assertTrue(customerService.deleteCustomer(customerII.getCustomerId()));
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testGetCustomerByLoginStub() throws DaoException, ServiceException {
        try {
            stub(customerService.getCustomerByLogin(customerDTOI.getLogin()))
                    .toReturn(customerDTOI);
            assertEquals(customerDTOI, customerService.getCustomerByLogin(customerDTOI
                    .getLogin()));
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testGetCustomerByLoginVerify() throws DaoException, ServiceException {
        try {
            customerService.getCustomerByLogin(anyString());
            verify(customerDao).getByLogin(anyString());
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test(expected = ServiceException.class)
    public void testGetCustomerByLoginException() throws DaoException, ServiceException {
        when(customerDao.getByLogin(anyString())).thenThrow(new DaoException());
        customerService.getCustomerByLogin(anyString());
    }
}
