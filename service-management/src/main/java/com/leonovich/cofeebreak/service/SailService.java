package com.leonovich.cofeebreak.service;

import com.leonovich.cofeebreak.dao.IGenericDao;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Sail;
import com.leonovich.cofeebreak.model.SailDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;
import com.leonovich.cofeebreak.service.util.DtoConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.leonovich.cofeebreak.service.exception.ServiceExceptionCode.SERVICE_15;
import static com.leonovich.cofeebreak.service.exception.ServiceExceptionCode.SERVICE_16;
import static com.leonovich.cofeebreak.service.util.ServiceConstants.Const.RECEIVED_SAIL;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;
import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

/**
 * Created by alexanderleonovich on 29.08.15.
 * Service class, for do operations
 * with Sail entity on Service layer
 * In this class entity convert to DTO object
 */
@Transactional(propagation = REQUIRED, readOnly = false)
@Service("sailService")
public class SailService implements ISailService {
    private static Logger logger = Logger.getLogger(SailService.class);

    @Autowired
    private IGenericDao<Sail, Long> sailDao;
    @Autowired
    private DtoConverter converter;

    /**
     * Get Sail persisted object from database
     * by unique id and convert it in DTO-object
     * @param id - id of entity in database
     * @return DTO copy of object
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = SUPPORTS, readOnly = true)
    public SailDTO getSailDTO(Long id) throws ServiceException {
        Sail sail;
        try {
            sail = sailDao.get(id);
            logger.info(RECEIVED_SAIL + sail);
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_15);
        }
        return converter.createSailDTO(sail);
    }

    /**
     * Update instance of Sail after convertation it from
     * DTO object
     * @param sailDTO object for convertation in Sail entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    public void updateSail(SailDTO sailDTO) throws ServiceException {
        Sail sail = new Sail(sailDTO);
        try {
            sailDao.update(sail);
        } catch (DaoException e) {
            throw new ServiceException(e, SERVICE_16);
        }
    }
}
