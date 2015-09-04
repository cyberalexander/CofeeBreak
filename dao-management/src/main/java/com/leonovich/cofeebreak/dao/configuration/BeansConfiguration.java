package com.leonovich.cofeebreak.dao.configuration;


import com.leonovich.cofeebreak.dao.GenericDao;
import com.leonovich.cofeebreak.dao.IGenericDao;
import com.leonovich.cofeebreak.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alexanderleonovich on 28.08.15.
 * Configuration class for GenericDao Spring beans
 */
@Configuration
public class BeansConfiguration {

    /**
     * Initialize GenericDao-Bean for work with Address entity
     * @return GenericDao for Address.class
     */
    @Bean(name = "addressDao")
    public IGenericDao<Address, Long> addressDao() {
        return new GenericDao<>(Address.class);
    }

    /**
     * Initialize GenericDao-Bean for work with Coffee entity
     * @return GenericDao for Coffee.class
     *//*
    @Bean(name = "coffeeDao")
    public IGenericDao<Coffee, Long> coffeeDao() {
        return new GenericDao<>(Coffee.class);
    }*/

    /**
     * Initialize GenericDao-Bean for work with CoffeeCup entity
     * @return GenericDao for CoffeeCup.class
     */
    @Bean(name = "coffeeCupDao")
    public IGenericDao<CoffeeCup, Long> coffeeCupDao() {
        return new GenericDao<>(CoffeeCup.class);
    }

    /**
     * Initialize GenericDao-Bean for work with Order entity
     * @return GenericDao for Order.class
     */
    @Bean(name = "orderDao")
    public IGenericDao<Order, Long> orderDao() {
        return new GenericDao<>(Order.class);
    }

    /**
     * Initialize GenericDao-Bean for work with Sail entity
     * @return GenericDao for Sail.class
     */
    @Bean(name = "sailDao")
    public IGenericDao<Sail, Long> sailDao() {
        return new GenericDao<>(Sail.class);
    }


}
