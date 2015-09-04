package com.leonovich.cofeebreak.service.facade;

import com.leonovich.cofeebreak.model.SailDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;

/**
 * Created by alexanderleonovich on 03.09.15.
 * Interface using facade pattern for SailFacade class.
 * @see SailFacade
 */
public interface ISailFacade {

    SailDTO getSailDTO(Long id) throws ServiceException;

    void updateSail(SailDTO sailDTO) throws ServiceException;
}
