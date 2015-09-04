package com.leonovich.cofeebreak.service;


import com.leonovich.cofeebreak.dao.IGenericDao;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Sail;
import com.leonovich.cofeebreak.model.SailDTO;
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
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Test class for test methods in InquiryService.class. Mockito used.
 * Created 31.08.15.
 * @author Alexander Leonovich
 * @version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class SailServiceTest {
    private static Logger logger = Logger.getLogger(SailServiceTest.class);

    @Mock
    private IGenericDao<Sail, Long> sailDao;
    @Mock
    private DtoConverter converter;
    @InjectMocks
    private ISailService sailService = new SailService();

    private Sail objectI;
    private Sail objectII;
    private SailDTO objectDTOI;
    private SailDTO objectDTOII;
    private SailDTO objectDTOIII;
    private List<SailDTO> objectDTOs;

    @Before
    public void setUp() throws Exception {
        objectI = new Sail(ONE, FIVE_INT, TEST_PRICE_2, TEST_PRICE_1);
        objectII = new Sail(TWO, TEN_INT, TEST_PRICE_1, TEST_PRICE_2);
        objectDTOI = new SailDTO(ONE, FIVE_INT, TEST_PRICE_2, TEST_PRICE_1);
        objectDTOII = new SailDTO(TWO, TEN_INT, TEST_PRICE_1, TEST_PRICE_2);
        objectDTOIII = new SailDTO(THREE, FIVETEN_INT, TEST_PRICE_3, TEST_PRICE_3);
        objectDTOs = Arrays.asList(objectDTOI, objectDTOII);
    }

    @Test
    public void testGetSailDTOStub() throws DaoException, ServiceException {
        try {
            stub(sailService.getSailDTO(objectDTOI.getId()))
                    .toReturn(objectDTOI);
            assertEquals(objectDTOI, sailService.getSailDTO(objectDTOI.getId()));
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testGetSailDTOVerify() throws DaoException, ServiceException {
        try {
            sailService.getSailDTO(anyLong());
            verify(sailDao).get(anyLong());
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test(expected = ServiceException.class)
    public void testGetSailDTOException() throws DaoException, ServiceException {
        when(sailDao.get(anyLong())).thenThrow(new DaoException());
        sailService.getSailDTO(anyLong());
    }

    @Test
    public void testUpdateSailVerify() throws DaoException, ServiceException{
        objectI.setFreeCup(objectII.getFreeCup());
        objectDTOI.setFreeCup((objectDTOII.getFreeCup()));
        try {
            sailService.updateSail(objectDTOI);
            verify(sailDao).update(any(Sail.class));
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

}
