package com.leonovich.cofeebreak.dao;

import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Customer;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static com.leonovich.cofeebreak.dao.util.DaoConstants.Const.LOGIN;
import static com.leonovich.cofeebreak.dao.util.DaoConstants.Const.ZERO;

/**
 * Class of specific operations with Customer-entity
 * Created by alexanderleonovich on 28.08.15.
 */
@Repository("customerDao")
@PropertySource(value = {"classpath:query.properties"})
public class CustomerDao extends GenericDao<Customer, Long> implements ICustomerDao  {
    @Autowired
    private Environment env;

    public CustomerDao() {
        super(Customer.class);
    }

    /**
     * Method get Customer entity by unique login
     * @param login unique identifier of Customer entity
     * @return Customer entity
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    @Override
    @SuppressWarnings("unchecked")
    public Customer getByLogin(String login) throws DaoException{
        List<Customer> customers = Collections.emptyList();
        String hql = env.getRequiredProperty("get.by.login");
        Query query = getQuery(hql)
                .setParameter(LOGIN, login);
        customers = (List<Customer>) query.list();
        if (customers.size() > ZERO) {
            return customers.get(ZERO);
        } else {
            return null;
        }
    }
}
