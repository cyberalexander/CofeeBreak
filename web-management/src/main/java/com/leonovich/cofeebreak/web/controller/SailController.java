package com.leonovich.cofeebreak.web.controller;

import com.leonovich.cofeebreak.model.SailDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;
import com.leonovich.cofeebreak.service.facade.ISailFacade;
import com.leonovich.cofeebreak.web.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static com.leonovich.cofeebreak.web.exception.WebExceptionCode.WEB_010;
import static com.leonovich.cofeebreak.web.exception.WebExceptionCode.WEB_011;
import static com.leonovich.cofeebreak.web.util.WebConstants.Const.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by alexanderleonovich on 03.09.15.
 * Controller of application. Contains methods, what perform the function
 * of updating sail instance of application
 */
@RestController
@RequestMapping("/sail")
@PropertySource(value = {"classpath:messages.properties"})
public class SailController {

    @Autowired
    private ISailFacade sailFacade;
    @Autowired
    private Environment env;

    /**
     * Method get instance of SailDTO by unique ID and send it in client
     * for updating parameters in this instance
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @Secured({ADMIN})
    @RequestMapping(value = "/update/sail", method = GET)
    public ModelAndView updateSail(ModelAndView model) throws WebException {
        try {
            model.addObject("sailDTO", sailFacade.getSailDTO(1L));
        } catch (ServiceException e) {
            throw new WebException(e, WEB_010);
        }
        model.setViewName("updateSail");
        return model;
    }

    /**
     * Method get instance of SailDTO from client and
     * update this instance in database
     * @param sailDTO object with updated parameters from client
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @Secured({ADMIN})
    @RequestMapping(value = "update/sail", method = {POST})
    public ModelAndView saveSail(ModelAndView model,
                                    @Validated SailDTO sailDTO) throws WebException{
        try {
            sailFacade.updateSail(sailDTO);
            model.addObject(SUCCESS, env.getRequiredProperty("update.sail.ok"));
        } catch (ServiceException e) {
            throw new WebException(e, WEB_011);
        }
        model.setViewName(SHOWCOFFEEMENU);
        return model;
    }
}
