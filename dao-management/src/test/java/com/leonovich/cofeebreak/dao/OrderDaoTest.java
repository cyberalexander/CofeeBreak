package com.leonovich.cofeebreak.dao;

import com.leonovich.cofeebreak.dao.configuration.DaoConfiguration;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Order;
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
 * Test class for CRUD operations with Order-entity.
 * Created 28.08.15.
 * @author Alexander Leonovich
 * @version 1.0
 */
@DataSet
@Transactional
public class OrderDaoTest extends UnitilsJUnit4 {

    @SpringBeanByName
    private IGenericDao<Order, Long> orderDao;

    private Order objectI;
    private Order objectII;
    private Order objectIII;

    @SpringApplicationContext
    public ConfigurableApplicationContext createAppContext() {
        return new AnnotationConfigApplicationContext(DaoConfiguration.class);
    }

    @Before
    public void setUp() throws Exception {
        objectI = new Order(ONE, 100.1);
        objectII = new Order(TWO, 200.1);
        objectIII = new Order(THREE, 300.1);
    }

    @Test
    public void testGetCoffee() throws DaoException {
        Order result = orderDao.get(objectI.getOrderId());
        assertNotNull(result);
        assertEquals(objectI, result);
    }

    @Test
    public void testGetAllCoffies() throws DaoException {
        List<Order> result = orderDao.getAll();
        assertNotNull(result);
        assertTrue(result.size() > ZERO);
    }

    @Test
    public void testAddCoffee() throws DaoException {
        Long result = orderDao.add(objectIII);
        assertNotNull(result);
    }

    @Test
    public void testUpdateCoffee() throws DaoException {
        objectI.setTotalPrice(objectII.getTotalPrice());
        orderDao.update(objectI);
        Order result = orderDao.get(objectI.getOrderId());
        assertNotNull(result);
        assertEquals(objectI, result);
    }

    @Test
    public void testDeleteCoffee() throws DaoException {
        orderDao.delete(objectII);
        Order result = orderDao.get(objectII.getOrderId());
        assertNull(result);
    }
}
