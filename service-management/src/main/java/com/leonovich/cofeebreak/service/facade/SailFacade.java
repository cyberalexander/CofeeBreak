package com.leonovich.cofeebreak.service.facade;

import com.leonovich.cofeebreak.model.SailDTO;
import com.leonovich.cofeebreak.service.ISailService;
import com.leonovich.cofeebreak.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alexanderleonovich on 03.09.15.
 * Facade layer for SailService
 * @see com.leonovich.cofeebreak.service.SailService
 */
@Service
public class SailFacade implements ISailFacade {

    @Autowired
    private ISailService sailService;

    @Override
    public SailDTO getSailDTO(Long id) throws ServiceException {
        return sailService.getSailDTO(id);
    }

    @Override
    public void updateSail(SailDTO sailDTO) throws ServiceException {
        sailService.updateSail(sailDTO);
    }
}
