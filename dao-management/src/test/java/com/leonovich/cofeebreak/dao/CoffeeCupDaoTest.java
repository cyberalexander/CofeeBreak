package com.leonovich.cofeebreak.dao;

import com.leonovich.cofeebreak.dao.configuration.DaoConfiguration;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Coffee;
import com.leonovich.cofeebreak.domain.CoffeeCup;
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
 * Test class for CRUD operations with CoffeeCup-entity.
 * Created 28.08.15.
 * @author Alexander Leonovich
 * @version 1.0
 */
@DataSet
@Transactional
public class CoffeeCupDaoTest extends UnitilsJUnit4 {

    @SpringBeanByName
    private IGenericDao<CoffeeCup, Long> coffeeCupDao;

    private CoffeeCup objectI;
    private CoffeeCup objectII;
    private CoffeeCup objectIII;

    @SpringApplicationContext
    public ConfigurableApplicationContext createAppContext() {
        return new AnnotationConfigApplicationContext(DaoConfiguration.class);
    }

    @Before
    public void setUp() throws Exception {
        objectI = new CoffeeCup(ONE, new Coffee(ONE, "testSort_1", "testDescription_1", 100.1));
        objectII = new CoffeeCup(TWO, new Coffee(TWO, "testSort_2", "testDescription_2", 200.1));
        objectIII = new CoffeeCup(THREE, new Coffee(THREE, "testSort_3", "testDescription_3", 300.1));
    }

    @Test
    public void testGetCoffeeCup() throws DaoException {
        CoffeeCup result = coffeeCupDao.get(objectI.getCoffeeCupId());
        assertNotNull(result);
        assertEquals(objectI, result);
    }

    @Test
    public void testGetAllCoffeeCups() throws DaoException {
        List<CoffeeCup> result = coffeeCupDao.getAll();
        assertNotNull(result);
        assertTrue(result.size() > ZERO);
    }

    @Test
    public void testAddCoffeeCup() throws DaoException {
        Long result = coffeeCupDao.add(objectIII);
        assertNotNull(result);
    }

    @Test
    public void testUpdateCoffeeCup() throws DaoException {
        objectI.setCoffee(objectII.getCoffee());
        coffeeCupDao.update(objectI);
        CoffeeCup result = coffeeCupDao.get(objectI.getCoffeeCupId());
        assertNotNull(result);
        assertEquals(objectI, result);
    }

    @Test
    public void testDeleteCoffeeCup() throws DaoException {
        coffeeCupDao.delete(objectII);
        CoffeeCup result = coffeeCupDao.get(objectII.getCoffeeCupId());
        assertNull(result);
    }
}
