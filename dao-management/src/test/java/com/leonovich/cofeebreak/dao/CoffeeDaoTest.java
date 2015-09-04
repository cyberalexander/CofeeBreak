package com.leonovich.cofeebreak.dao;

import com.leonovich.cofeebreak.dao.configuration.DaoConfiguration;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Coffee;
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
 * Test class for CRUD operations with Coffee-entity.
 * Created 28.08.15.
 * @author Alexander Leonovich
 * @version 1.0
 */
@DataSet
@Transactional
public class CoffeeDaoTest extends UnitilsJUnit4 {

    @SpringBeanByName
    private ICoffeeDao coffeeDao;

    private Coffee objectI;
    private Coffee objectII;
    private Coffee objectIII;

    @SpringApplicationContext
    public ConfigurableApplicationContext createAppContext() {
        return new AnnotationConfigApplicationContext(DaoConfiguration.class);
    }

    @Before
    public void setUp() throws Exception {
        objectI = new Coffee(ONE, "testSort_1", "testDescription_1", 100.1);
        objectII = new Coffee(TWO, "testSort_2", "testDescription_2", 200.1);
        objectIII = new Coffee(THREE, "testSort_3", "testDescription_3", 300.1);
    }

    @Test
    public void testGetCoffee() throws DaoException {
        Coffee result = coffeeDao.get(objectI.getCoffeeId());
        assertNotNull(result);
        assertEquals(objectI, result);
    }

    @Test
    public void testGetAllCoffies() throws DaoException {
        List<Coffee> result = coffeeDao.getAll();
        assertNotNull(result);
        assertTrue(result.size() > ZERO);
    }

    @Test
    public void testAddCoffee() throws DaoException {
        Long result = coffeeDao.add(objectIII);
        assertNotNull(result);
    }

    @Test
    public void testUpdateCoffee() throws DaoException {
        objectI.setSort(objectII.getSort());
        coffeeDao.update(objectI);
        Coffee result = coffeeDao.get(objectI.getCoffeeId());
        assertNotNull(result);
        assertEquals(objectI, result);
    }

    @Test
    public void testDeleteCoffee() throws DaoException {
        coffeeDao.delete(objectII);
        Coffee result = coffeeDao.get(objectII.getCoffeeId());
        assertNull(result);
    }

    @Test
    public void testFindCoffee() throws DaoException {
        List<Coffee> result = coffeeDao.findCoffee(objectI.getSort());
        assertNotNull(result);
        assertTrue(result.size() > ZERO);
    }
}
