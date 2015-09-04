package com.leonovich.cofeebreak.dao;

import com.leonovich.cofeebreak.dao.configuration.DaoConfiguration;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Sail;
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
 * Test class for CRUD operations with Sail-entity.
 * Created 03.09.15.
 * @author Alexander Leonovich
 * @version 1.0
 */
@DataSet
@Transactional
public class SailDaoTest extends UnitilsJUnit4 {

    @SpringBeanByName
    private IGenericDao<Sail, Long> sailDao;

    private Sail objectI;
    private Sail objectII;
    private Sail objectIII;

    @SpringApplicationContext
    public ConfigurableApplicationContext createAppContext() {
        return new AnnotationConfigApplicationContext(DaoConfiguration.class);
    }

    @Before
    public void setUp() throws Exception {
        objectI = new Sail(ONE, 10, 100.1, 100.1);
        objectII = new Sail(TWO, 20, 200.1, 200.1);
        objectIII = new Sail(THREE, 30, 300.1, 300.1);
    }

    @Test
    public void testGetCoffee() throws DaoException {
        Sail result = sailDao.get(objectI.getId());
        assertNotNull(result);
        assertEquals(objectI, result);
    }

    @Test
    public void testGetAllCoffies() throws DaoException {
        List<Sail> result = sailDao.getAll();
        assertNotNull(result);
        assertTrue(result.size() > ZERO);
    }

    @Test
    public void testAddCoffee() throws DaoException {
        Long result = sailDao.add(objectIII);
        assertNotNull(result);
    }

    @Test
    public void testUpdateCoffee() throws DaoException {
        objectI.setDelivery(objectII.getDelivery());
        sailDao.update(objectI);
        Sail result = sailDao.get(objectI.getId());
        assertNotNull(result);
        assertEquals(objectI, result);
    }

    @Test
    public void testDeleteCoffee() throws DaoException {
        sailDao.delete(objectII);
        Sail result = sailDao.get(objectII.getId());
        assertNull(result);
    }
}
