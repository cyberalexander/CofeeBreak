package com.leonovich.cofeebreak.dao;

import com.leonovich.cofeebreak.dao.configuration.DaoConfiguration;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Address;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByName;

import java.util.List;

import static com.leonovich.cofeebreak.util.TestConstants.TestConst.*;
import static org.junit.Assert.*;


/**
 * Test class for CRUD operations with Address-entity.
 * Created 28.08.15.
 * @author Alexander Leonovich
 * @version 1.0
 */
@DataSet
@Transactional
public class AddressDaoTest extends UnitilsJUnit4 {

    @SpringBeanByName
    private IGenericDao<Address, Long> addressDao;

    private Address objectI;
    private Address objectII;
    private Address objectIII;

    @SpringApplicationContext
    public ConfigurableApplicationContext createAppContext() {
        return new AnnotationConfigApplicationContext(DaoConfiguration.class);
    }

    @Before
    public void setUp() throws Exception {
        objectI = new Address(ONE, "testStreet_1", 100, 99);
        objectII = new Address(TWO, "testStreet_2", 200, 199);
        objectIII = new Address(THREE, "testStreet_3", 300, 299);
    }

    @Test
    public void testGetAddress() throws DaoException {
        Address result = addressDao.get(objectI.getAddressId());
        assertNotNull(result);
        assertEquals(objectI, result);
    }

    @Test
    public void testGetAllAddresses() throws DaoException {
        List<Address> result = addressDao.getAll();
        assertNotNull(result);
        assertTrue(result.size() > ZERO);
    }

    @Test
    public void testAddAddress() throws DaoException {
        Long result = addressDao.add(objectIII);
        assertNotNull(result);
    }

    @Test
    public void testUpdateAddress() throws DaoException {
        objectI.setStreet(objectII.getStreet());
        addressDao.update(objectI);
        Address result = addressDao.get(objectI.getAddressId());
        assertNotNull(result);
        assertEquals(objectI, result);
    }

    @Test
    public void testDeleteAddress() throws DaoException {
        addressDao.delete(objectII);
        Address result = addressDao.get(objectII.getAddressId());
        assertNull(result);
    }
}
