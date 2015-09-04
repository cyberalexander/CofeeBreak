package com.leonovich.cofeebreak.dao;

import com.leonovich.cofeebreak.dao.exception.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.List;

import static com.leonovich.cofeebreak.dao.exception.DaoExceptionCode.*;
import static com.leonovich.cofeebreak.dao.util.DaoConstants.Const.*;
import static java.net.InetAddress.getLocalHost;

/**
 * Created by alexanderleonovich on 28.08.15.
 * Implementation of IGenericDao interface.
 * Class with CRUD operations
 */
@Repository
public class GenericDao<T, PK extends Serializable> implements IGenericDao<T, PK> {
    private static Logger logger = Logger.getLogger(GenericDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Class of domain entity for using in dao methods
     */
    private Class<T> genObject;

    public GenericDao() {

    }

    public GenericDao(Class<T> genObject) {
        this.genObject = genObject;

    }

    /**
     * Obtains the current session.  The definition of what exactly "current" means controlled
     * by the {@link org.hibernate.context.spi.CurrentSessionContext} impl configured for use.
     * @return org.hibernate.Session
     */
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Try get entity from database by unique id
     * @param id - must not be null.
     * @return domain entity
     * @throws DaoException
     */
    @Override
    @SuppressWarnings("unchecked")
    public T get(PK id) throws DaoException {
        try {
            logger.info(PREFIX + getLocalHost().getHostAddress() + GET_MESSAGE + id);
            T entity = (T) getCurrentSession().get(genObject, id);
            return entity;
        } catch (UnknownHostException | HibernateException e) {
            throw new DaoException(e, DAO_01);
        }
    }

    /**
     * Get list of objects
     * @return collection of domain entities
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() throws DaoException {
        try {
            logger.info(PREFIX + getLocalHost().getHostAddress() + GET_LIST_MESSAGE);
            List<T> list = getCurrentSession().createCriteria(genObject).list();
            //List<T> list = parseResultSet();
            return list;
        } catch (UnknownHostException | HibernateException e) {
            throw new DaoException(e, DAO_02);
        }
    }

    /**
     * Add domain entity in database.
     * @param object - a transient instance of a persistent class
     * @return id of domain entity.
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    @Override
    @SuppressWarnings("unchecked")
    public PK add(T object) throws DaoException {
        try {
            PK id = (PK) getCurrentSession().save(object);
            logger.info(PREFIX + getLocalHost().getHostAddress() + ADD_MESSAGE + id);
            return id;
        } catch (UnknownHostException | HibernateException e) {
            throw new DaoException(e, DAO_03);
        }
    }

    /**
     * Update state of domain entity in database
     * @param object - a transient or detached instance containing new or updated state
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    @Override
    public void update(T object) throws DaoException {
        try {
            logger.info(PREFIX + getLocalHost().getHostAddress() + UPDATE_MESSAGE);
            getCurrentSession().saveOrUpdate(object);
        } catch (UnknownHostException | HibernateException e) {
            throw new DaoException(e, DAO_04);
        }
    }

    /**
     * Delete object from database
     * @param object - must not be null
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    @Override
    public void delete(T object) throws DaoException {
        try {
            logger.info(PREFIX + getLocalHost().getHostAddress() + DELETE_MESSAGE);
            getCurrentSession().delete(object);
        } catch (UnknownHostException | HibernateException e) {
            throw new DaoException(e, DAO_05);
        }
    }

    /**
     * Getting Query by String-hql
     * @param hql - The HQL query
     * @return org.hibernate.Query
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    @Override
    public Query getQuery(String hql) throws DaoException {
        try {
            logger.info(PREFIX + getLocalHost().getHostAddress() + GET_HQL_MESSAGE);
            Query query = getCurrentSession().createQuery(hql);
            return query;
        } catch (UnknownHostException | HibernateException e) {
            throw new DaoException(e, DAO_06);
        }
    }
}
