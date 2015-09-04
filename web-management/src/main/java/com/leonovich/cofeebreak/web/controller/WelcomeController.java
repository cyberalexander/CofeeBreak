package com.leonovich.cofeebreak.web.controller;

import com.leonovich.cofeebreak.model.AddressDTO;
import com.leonovich.cofeebreak.model.CustomerDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;
import com.leonovich.cofeebreak.service.facade.IAddressFacade;
import com.leonovich.cofeebreak.service.facade.ICustomerFacade;
import com.leonovich.cofeebreak.web.exception.WebException;
import com.leonovich.cofeebreak.web.exception.WebExceptionCode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

import static com.leonovich.cofeebreak.web.util.WebConstants.Const.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by alexanderleonovich on 29.08.15.
 * Controller of application. Contains methods, what perform the function
 * of registration of customer and signi in customer on site and other.
 */
@Controller
@RequestMapping("/")
@PropertySource(value = {"classpath:messages.properties"})
public class WelcomeController {
    private static final Logger logger = Logger.getLogger(WelcomeController.class);

    @Autowired
    private ICustomerFacade customerFacade;
    @Autowired
    private IAddressFacade addressFacade;
    @Autowired
    private AppController appController;
    @Autowired
    private Environment env;

    /**
     * Method send client from index to welcome page
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     */
    @RequestMapping(value = "index", method = GET)
    public String welcome(Model model){
        return SHOWCOFFEEMENU;
    }

    /**
     * Method send client from welcome to login page
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     */
    @RequestMapping(value = "login", method = GET)
    public String loginPage(Model model){
        return "login";
    }

    /**
     * Method create new instance of CustomerDTO andsend it in client
     * for setting parameters in this instance
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = "registration", method = {GET, POST})
    public ModelAndView registration(ModelAndView model) {
        model.addObject(CUSTOMERDTO, new CustomerDTO());
        model.setViewName(REGISTRATION);
        return model;
    }

    /**
     * Method get instance of CustomerDTO from client and
     * save this instance in database
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @param customerDTO object with setted parameters from client
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = "save/customer", method = {POST})
    public ModelAndView saveCustomer(ModelAndView model,
                                     @Validated CustomerDTO customerDTO) throws WebException{
        logger.info(CUSTOMER_FOR_SAVE + customerDTO.toString());
        try {
            customerFacade.saveCustomer(customerDTO);
        } catch (ServiceException e) {
            throw new WebException(e, WebExceptionCode.WEB_012);
        }
        model.addObject(SUCCESS, env.getRequiredProperty("save.ok"));
        model.setViewName(SHOWCOFFEEMENU);
        return model;
    }

    /**
     * Method create new instance of AddressDTO and send it in client
     * for setting parameters in this instance
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @Secured({ADMIN, USER})
    @RequestMapping(value = "add/address", method = RequestMethod.GET)
    @SuppressWarnings("unchecked")
    public ModelAndView addAddress(ModelAndView model) throws WebException {
            model.addObject(ADDRESSDTO, new AddressDTO());
            model.setViewName(ADDADDRESS);
        return model;
    }

    /**
     * Method get instance of AddressDTO from client and
     * save this instance in database
     * @param addressDTO object with setted parameters from client
     * @param principal spring cridentials object. Contains unique login
     *                  of User
     * @param request HttpServlet request from client
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @Secured({ADMIN, USER})
    @RequestMapping(value = "save/address", method = {POST})
    public ModelAndView saveAddress(ModelAndView model,
                                     @Validated AddressDTO addressDTO,
                                     Principal principal,
                                     HttpServletRequest request) throws WebException{
        logger.info(ADDRESS_FOR_SAVE + addressDTO.toString());
        try {
            addressFacade.saveAddress(addressDTO, principal.getName());
        } catch (ServiceException e) {
            throw new WebException(e, WebExceptionCode.WEB_013);
        }
        return appController.createOrderNextStep(model, principal, request);
    }

    /**
     * Method send message view in client if auhorization is failed
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = "loginfailed", method = RequestMethod.GET)
    @SuppressWarnings("unchecked")
    public ModelAndView loginFailed(ModelAndView model) throws WebException {
        model.addObject(SUCCESS, env.getRequiredProperty("loginfailed"));
        model.setViewName(LOGINFAILED);
        return model;
    }

    /**
     * Method show inclient cabinet of customer
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = "customer/cabinet", method = RequestMethod.GET)
    @SuppressWarnings("unchecked")
    public void customerCabinet(ModelAndView model) throws WebException {
        throw new UnsupportedOperationException();
    }


    /**
     * Method show inclient orders of customer
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = "customer/orders", method = RequestMethod.GET)
    @SuppressWarnings("unchecked")
    public void customerOrders(ModelAndView model) throws WebException {
        throw new UnsupportedOperationException();
    }

}
