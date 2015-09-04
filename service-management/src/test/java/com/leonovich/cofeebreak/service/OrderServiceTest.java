package com.leonovich.cofeebreak.service;


import com.leonovich.cofeebreak.dao.ICustomerDao;
import com.leonovich.cofeebreak.dao.IGenericDao;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Customer;
import com.leonovich.cofeebreak.domain.Order;
import com.leonovich.cofeebreak.model.CoffeeDTO;
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
public class OrderServiceTest {
    private static Logger logger = Logger.getLogger(OrderServiceTest.class);

    @Mock
    private IGenericDao<Order, Long> orderDao;
    @Mock
    private ICustomerDao customerDao;
    @Mock
    private DtoConverter converter;
    @InjectMocks
    private IOrderService orderService = new OrderService();

    private Customer customerI;
    private List<CoffeeDTO> coffeeDTOs;

    @Before
    public void setUp() throws Exception {
        customerI = new Customer(
                ONE, "testFirstName_1", "testLastName_1", TEST_LOGIN_1, "testPassword_1");
        coffeeDTOs = Arrays.asList(
                new CoffeeDTO(ONE, TEST_SORT_2, TEST_DESCRIPTION_2, TEST_PRICE_2, TEN_INT));
    }

    @Test
    public void testSaveOrderStub() throws DaoException, ServiceException {
        try {
            stub(customerDao.getByLogin(TEST_LOGIN_1)).toReturn(customerI);
            stub(orderService.saveOrder(TEST_LOGIN_1, coffeeDTOs, TEST_PRICE_1))
                    .toReturn(ONE);
            assertEquals(ONE, orderService
                    .saveOrder(TEST_LOGIN_1, coffeeDTOs, TEST_PRICE_1));
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

    @Test(expected = ServiceException.class)
    public void testSaveOrderException() throws DaoException, ServiceException {
        when(orderDao.add(any(Order.class))).thenThrow(new DaoException());
        orderService.saveOrder(TEST_LOGIN_1, coffeeDTOs, TEST_PRICE_1);
    }

    @Test
    public void testSaveOrderVerify() throws DaoException, ServiceException{
        try {
            when(customerDao.getByLogin(TEST_LOGIN_1)).thenReturn(customerI);
            orderService.saveOrder(TEST_LOGIN_1, coffeeDTOs, TEST_PRICE_1);
            verify(orderDao).add(any(Order.class));
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

   /* private void invokeInnerMethodFromOrderService() {
        Class[] paramTypes = new Class[] {List.class, Order.class};
        Method m = null;
        try {
            m = OrderService.class.getDeclaredMethod("createCoffeeCupList", paramTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        m.setAccessible(true);
        Object[] args = new Object[] {coffeeDTOs, new Order()};
        try {
            stub(m.invoke(OrderService.class, args)).toReturn(new ArrayList<CoffeeCup>());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }*/

}
