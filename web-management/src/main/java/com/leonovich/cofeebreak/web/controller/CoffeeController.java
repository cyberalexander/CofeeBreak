package com.leonovich.cofeebreak.web.controller;

import com.leonovich.cofeebreak.model.CoffeeDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;
import com.leonovich.cofeebreak.service.facade.ICoffeeFacade;
import com.leonovich.cofeebreak.web.exception.WebException;
import com.leonovich.cofeebreak.web.exception.WebExceptionCode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.leonovich.cofeebreak.web.util.WebConstants.Const.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by alexanderleonovich on 30.08.15.
 * Controller of application. Contains methods, what perform the function
 * of operations with coffe entity
 */
@RestController
@RequestMapping("/coffee")
@PropertySource(value = {"classpath:messages.properties"})
public class CoffeeController {
    private static Logger logger = Logger.getLogger(CoffeeController.class);

    @Autowired
    private ICoffeeFacade coffeeFacade;
    @Autowired
    private Environment env;
    @Autowired
    private AppController appController;

    /**
     * Method create new instance of CoffeeDTO andsend it in client
     * for setting parameters in this instance
     *
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @Secured({ADMIN})
    @RequestMapping(value = "/create", method = GET)
    public ModelAndView addCoffee(ModelAndView model) throws WebException {
        model.addObject(COFFEEDTO, new CoffeeDTO());
        model.setViewName(ADDCOFFEE);
        return model;
    }

    /**
     * Method get instance of CoffeeDTO from client and
     * save this instance in database
     *
     * @param model     Spring Model for work with attributes of request
     *                  and choose view for response.
     * @param coffeeDTO object with setted parameters from client
     * @return model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @Secured({ADMIN})
    @RequestMapping(value = "/save", method = {POST})
    public ModelAndView saveCoffee(ModelAndView model,
                                   @Validated CoffeeDTO coffeeDTO) throws WebException {
        logger.info(COFFEE_FOR_SAVE + coffeeDTO.toString());

        try {
            coffeeFacade.saveCofee(coffeeDTO);
            model.addObject(SUCCESS, env.getRequiredProperty("save.coffee.ok"));
        } catch (ServiceException e) {
            throw new WebException(e, WebExceptionCode.WEB_004);
        }
        model.setViewName(SHOWCOFFEEMENU);
        return model;
    }

    /**
     * Method get instance of CoffeeDTO by unique ID and send it in client
     * for updating parameters in this instance
     *
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @Secured({ADMIN})
    @RequestMapping(value = "/{coffeeId}/edit", method = GET)
    @ResponseBody
    public ModelAndView editCoffee(ModelAndView model,
                                   @PathVariable Long coffeeId) throws WebException {
        logger.info(COFFEEID_FOR_UPDATE + coffeeId);
        try {
            model.addObject(COFFEEDTO, coffeeFacade.getCofeeDTO(coffeeId));
        } catch (ServiceException e) {
            throw new WebException(e, WebExceptionCode.WEB_005);
        }
        model.setViewName(EDITCOFFEE);
        return model;
    }

    /**
     * Method get instance of CoffeeDTO from client and
     * update this instance in database
     *
     * @param coffeeDTO object with updated parameters from client
     * @param model     Spring Model for work with attributes of request
     *                  and choose view for response.
     * @return model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @Secured({ADMIN})
    @RequestMapping(value = "/edit", method = {POST})
    @ResponseBody
    public ModelAndView editWriteCoffee(ModelAndView model,
                                        @Validated CoffeeDTO coffeeDTO) throws WebException {
        logger.info(COFFEE_FOR_UPDATE + coffeeDTO.toString());
        try {
            coffeeFacade.updateCofee(coffeeDTO);
            model.addObject(SUCCESS, env.getRequiredProperty("edit.coffee.ok"));
        } catch (ServiceException e) {
            throw new WebException(e, WebExceptionCode.WEB_006);
        }
        model.setViewName(SHOWCOFFEEMENU);
        return appController.showCoffeeMenu(model);
    }

    /**
     * Method delete instance of CoffeeDTO by unique ID and send client
     * on page with list of coffies
     *
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @Secured({ADMIN})
    @RequestMapping(value = "/{coffeeId}/delete", method = {POST})
    @ResponseBody
    public ModelAndView deleteCoffee(ModelAndView model,
                                     @PathVariable Long coffeeId) throws WebException {
        logger.info(COFFEE_FOR_DELETE + coffeeId);
        try {
            coffeeFacade.deleteCofee(coffeeId);
            model.addObject(SUCCESS, env.getRequiredProperty("delete.coffee.ok"));
        } catch (ServiceException e) {
            throw new WebException(e, WebExceptionCode.WEB_009);
        }
        return appController.showCoffeeMenu(model);
    }

    /**
     * Method delete instance of CoffeeDTO by unique ID and send client
     * on page with list of coffies
     *
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = "/search", method = {GET})
    @ResponseBody
    public ModelAndView searchCoffee(ModelAndView model,
                                     @ModelAttribute("searchString")
                                     String searchString) throws WebException {
        List<CoffeeDTO> coffeeDTOs;
        logger.info(SEARCH_PARAMETER + searchString);
        try {
            coffeeDTOs = coffeeFacade.findCoffee(searchString);
        } catch (ServiceException e) {
            throw new WebException(e, WebExceptionCode.WEB_014);
        }
        if (coffeeDTOs.size() > ZERO){
            model.addObject(COFFEEDTOS, coffeeDTOs);
            model.addObject(SUCCESS, env.getRequiredProperty("find.ok"));
            model.setViewName(COFFEMENU);
        }else{
            model.addObject(ERRMSG, env.getRequiredProperty("not.found"));
            model.setViewName(ERROR);
        }
        return model;
    }
}
