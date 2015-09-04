package com.leonovich.cofeebreak.dao;

import com.leonovich.cofeebreak.dao.configuration.DaoConfiguration;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Customer;
import com.leonovich.cofeebreak.domain.enums.RoleEnum;
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
 * Test class for CRUD operations with Customer-entity.
 * Created 28.08.15.
 * @author Alexander Leonovich
 * @version 1.0
 */
@DataSet
@Transactional
public class CustomerDaoTest extends UnitilsJUnit4 {

    @SpringBeanByName
    private ICustomerDao customerDao;

    private Customer objectI;
    private Customer objectII;
    private Customer objectIII;

    @SpringApplicationContext
    public ConfigurableApplicationContext createAppContext() {
        return new AnnotationConfigApplicationContext(DaoConfiguration.class);
    }

    @Before
    public void setUp() throws Exception {
        objectI = new Customer(ONE, "testFirstName_1", "testLastName_1", "testLogin_1", "testPassword_1", RoleEnum.ROLE_ADMIN);
        objectII = new Customer(TWO, "testFirstName_2", "testLastName_2", "testLogin_2", "testPassword_2", RoleEnum.ROLE_USER);
        objectIII = new Customer(THREE, "testFirstName_3", "testLastName_3", "testLogin_3", "testPassword_3", RoleEnum.ROLE_USER);
    }

    @Test
    public void testGetCustomer() throws DaoException {
        Customer result = customerDao.get(objectI.getCustomerId());
        assertNotNull(result);
        assertEquals(objectI, result);
    }

    @Test
    public void testGetAllCustomers() throws DaoException {
        List<Customer> result = customerDao.getAll();
        assertNotNull(result);
        assertTrue(result.size() > ZERO);
    }

    @Test
    public void testAddCustomer() throws DaoException {
        Long result = customerDao.add(objectIII);
        assertNotNull(result);
    }

    @Test
    public void testUpdateCustomer() throws DaoException {
        objectI.setFirstName(objectII.getFirstName());
        customerDao.update(objectI);
        Customer result = customerDao.get(objectI.getCustomerId());
        assertNotNull(result);
        assertEquals(objectI, result);
    }

    @Test
    public void testDeleteCustomer() throws DaoException {
        customerDao.delete(objectII);
        Customer result = customerDao.get(objectII.getCustomerId());
        assertNull(result);
    }
}
