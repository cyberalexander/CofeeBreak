package com.leonovich.cofeebreak.dao;

import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Coffee;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static com.leonovich.cofeebreak.dao.util.DaoConstants.Const.PARAM;

/**
 * Class of specific operations with Coffee-entity
 * Created by alexanderleonovich on 04.09.15.
 */
@Repository("coffeeDao")
@PropertySource(value = {"classpath:query.properties"})
public class CoffeeDao extends GenericDao<Coffee, Long> implements ICoffeeDao  {
    @Autowired
    private Environment env;

    public CoffeeDao() {
        super(Coffee.class);
    }

    /**
     * Method find Coffee entity by search parameter
     * @param searchString unique search parameter
     * @return list of Coffee entities
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Coffee> findCoffee(String searchString) throws DaoException{
        searchString = '%' + searchString + '%';
        List<Coffee> coffies = Collections.emptyList();
        String hql = env.getRequiredProperty("search.query");
        Query query = getQuery(hql).setParameter(PARAM, searchString);
        coffies = (List<Coffee>) query.list();
        return coffies;
    }
}
