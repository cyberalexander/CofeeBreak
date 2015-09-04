package com.leonovich.cofeebreak.service;


import com.leonovich.cofeebreak.dao.ICoffeeDao;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Coffee;
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
public class CoffeeServiceTest {
    private static Logger logger = Logger.getLogger(CoffeeServiceTest.class);

    @Mock
    private ICoffeeDao coffeeDao;
    @Mock
    private DtoConverter converter;
    @InjectMocks
    private ICoffeeService coffeeService = new CoffeeService();

    private Coffee objectI;
    private Coffee objectII;
    private CoffeeDTO objectDTOI;
    private CoffeeDTO objectDTOII;
    private CoffeeDTO objectDTOIII;
    private List<CoffeeDTO> objectDTOs;

    @Before
    public void setUp() throws Exception {
        objectI = new Coffee(ONE, "testSort_1", "testDescription_1", TEST_PRICE_1);
        objectII = new Coffee(TWO, "testSort_2", "testDescription_2", TEST_PRICE_2);
        objectDTOI = new CoffeeDTO(ONE, "testSort_1", "testDescription_1", TEST_PRICE_1);
        objectDTOII = new CoffeeDTO(TWO, TEST_SORT_2, TEST_DESCRIPTION_2, TEST_PRICE_2);
        objectDTOIII = new CoffeeDTO(THREE, "testSort_3", "testDescription_3", TEST_PRICE_3);
        objectDTOs = Arrays.asList(objectDTOI, objectDTOII);
    }

    @Test
    public void testGetCoffeeDTOStub() throws DaoException, ServiceException {
        try {
            stub(coffeeService.getCofeeDTO(objectDTOI.getCoffeeId()))
                    .toReturn(objectDTOI);
            assertEquals(objectDTOI, coffeeService.getCofeeDTO(objectDTOI
                    .getCoffeeId()));
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testGetCoffeeDTOVerify() throws DaoException, ServiceException {
        try {
            coffeeService.getCofeeDTO(anyLong());
            verify(coffeeDao).get(anyLong());
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test(expected = ServiceException.class)
    public void testGetCoffeeDTOException() throws DaoException, ServiceException {
        when(coffeeDao.get(anyLong())).thenThrow(new DaoException());
        coffeeService.getCofeeDTO(anyLong());
    }

    @Test
    public void testGetAllCoffeeDTOsStub() throws DaoException, ServiceException{
        try{
            stub(coffeeService.getAllCofeeDTOs()).toReturn(objectDTOs);
            assertEquals(objectDTOs, coffeeService.getAllCofeeDTOs());
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testSaveCoffeeVerify() throws DaoException, ServiceException{
        try {
            coffeeService.saveCofee(objectDTOIII);
            verify(coffeeDao).add(any(Coffee.class));
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testUpdateCoffee() throws DaoException, ServiceException{
        objectI.setSort(objectII.getSort());
        objectDTOI.setSort((objectDTOII.getSort()));
        try {
            coffeeService.updateCofee(objectDTOI);
            verify(coffeeDao).update(any(Coffee.class));
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testDeleteCoffee() throws DaoException, ServiceException {
        try {
            doNothing().when(coffeeDao).delete(objectII);
            assertTrue(coffeeService.deleteCofee(objectII.getCoffeeId()));
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }



}
