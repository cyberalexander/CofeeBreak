package com.leonovich.cofeebreak.web.controller;

import com.leonovich.cofeebreak.model.AddressDTO;
import com.leonovich.cofeebreak.model.CoffeeDTO;
import com.leonovich.cofeebreak.model.SailDTO;
import com.leonovich.cofeebreak.service.exception.ServiceException;
import com.leonovich.cofeebreak.service.facade.IAddressFacade;
import com.leonovich.cofeebreak.service.facade.ICoffeeFacade;
import com.leonovich.cofeebreak.service.facade.IOrderFacade;
import com.leonovich.cofeebreak.service.facade.ISailFacade;
import com.leonovich.cofeebreak.web.exception.WebException;
import com.leonovich.cofeebreak.web.exception.WebExceptionCode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.leonovich.cofeebreak.web.util.WebConstants.Const.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by alexanderleonovich on 29.08.15.
 * Controller of application. Contains methods, what perform the function
 * of show coffe menu, all cicles of creating order and other
 */
@RestController
@RequestMapping("/coffeebreak")
@PropertySource(value = {"classpath:messages.properties"})
public class AppController {
    private static Logger logger = Logger.getLogger(AppController.class);

    @Autowired
    private ICoffeeFacade coffeeFacade;
    @Autowired
    private IAddressFacade addressFacade;
    @Autowired
    private IOrderFacade orderFacade;
    @Autowired
    private ISailFacade sailFacade;
    @Autowired
    private Environment env;

    /**
     * Method get list of coffies for showing it`s on page "coffee_menu"
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = "/allcoffies", method = GET)
    public ModelAndView showCoffeeMenu(ModelAndView model) throws WebException {
        List<CoffeeDTO> coffeeDTOs;
        try {
            coffeeDTOs = coffeeFacade.getAllCofeeDTOs();
        } catch (ServiceException e) {
            throw new WebException(e, WebExceptionCode.WEB_000);
        }
        model.addObject(COFFEEDTOS, coffeeDTOs);
        model.setViewName(COFFEMENU);
        return model;
    }

    /**
     * Method sending sustomer on page, where he can choose coffies
     * and number of cups for each checked coffee
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = "/create/order", method = GET)
    public ModelAndView createOrder(ModelAndView model) throws WebException {
        List<CoffeeDTO> coffeeDTOs;
        try {
            coffeeDTOs = coffeeFacade.getAllCofeeDTOs();
        } catch (ServiceException e) {
            throw new WebException(e, WebExceptionCode.WEB_000);
        }
        model.addObject(COFFEEDTOS, coffeeDTOs);
        model.addObject(NUMBERS, getNumbers());
        model.setViewName(CREATEORDER);
        return model;
    }

    /**
     * Method add choosed parameters in order for client and after
     * return him on page for choosing other coffies
     * @param coffee sort of coffee, what user choose
     * @param number number of cups of sort of coffee
     * @param request HttpServletrequest from client
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = "/add/to/order", method = POST)
    @SuppressWarnings("unchecked")
    public ModelAndView addToOrder(ModelAndView model,
                                   @ModelAttribute("coffee") String coffee,
                                   @ModelAttribute("number") String number,
                                   HttpServletRequest request) throws WebException {
        List<CoffeeDTO> coffeeOrder =
                (List<CoffeeDTO>) request.getSession().getAttribute(COFFEEORDER);
        if (null == coffeeOrder) {
            coffeeOrder = new ArrayList<>();
        }
        try {
            CoffeeDTO coffeeDTO = coffeeFacade.getCofeeDTO(Long.valueOf(coffee));
            coffeeDTO.setNumberOfCups(Integer.valueOf(number));
            coffeeOrder.add(coffeeDTO);
        } catch (ServiceException e) {
            throw new WebException(e, WebExceptionCode.WEB_001);
        }
        request.getSession().setAttribute(COFFEEORDER, coffeeOrder);
        return createOrder(model);
    }

    /**
     * Method, what send user on page, where he can choose addres for delivery
     * order, and if customer haven`t address redirect user in page
     * for adding address of delivery
     * @param principal spring cridentials object. Contains unique login
     *                  of User
     * @param request HttpServlet request from client
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @Secured({ADMIN, USER})
    @RequestMapping(value = "/create/order/address", method = GET)
    @SuppressWarnings("unchecked")
    public ModelAndView createOrderNextStep(ModelAndView model,
                                            Principal principal,
                                            HttpServletRequest request) throws WebException {
        List<AddressDTO> addressDTOs = Collections.emptyList();
        SailDTO sailDTO;
        try {
            addressDTOs = addressFacade.getAddressDTOsByCustomerLogin(principal.getName());
            sailDTO = sailFacade.getSailDTO(1L);
        } catch (ServiceException e) {
            throw new WebException(e, WebExceptionCode.WEB_002);
        }
        List<CoffeeDTO> coffeOrder = (List<CoffeeDTO>) request.getSession().getAttribute(COFFEEORDER);
        double price = countPriceOfOrder(coffeOrder, sailDTO);
        if (price < sailDTO.getFreeDelivery()) {
            model.addObject(DELIVERY, sailDTO.getDelivery());
        }
        request.getSession().setAttribute(PRICE, price);
        if (addressDTOs.size() == ZERO) {
            model.addObject(ADDRESSDTO, new AddressDTO());
            model.setViewName(ADDADDRESS);
        } else {
            model.addObject(ADDRESSDTOS, addressDTOs);
            model.addObject(CHECKEDADDRESSID, addressDTOs.get(ZERO).getAddressId());
            model.setViewName(CHOOSEADDRESS);
        }
        return model;
    }

    /**
     * Method save order in database and send view with result-message
     * in client
     * @param principal spring cridentials object. Contains unique login
     *                  of User
     * @param request HttpServlet request from client
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @Secured({ADMIN, USER})
    @RequestMapping(value = "/commit/order", method = GET)
    @SuppressWarnings("unchecked")
    public ModelAndView commitOrder(ModelAndView model,
                                    Principal principal,
                                    HttpServletRequest request) throws WebException {
        double price = (double) request.getSession().getAttribute(PRICE);
        List<CoffeeDTO> coffeeOrder = (List<CoffeeDTO>) request.getSession()
                .getAttribute(COFFEEORDER);
        try {
            orderFacade.saveOrder(principal.getName(), coffeeOrder, price);
        } catch (ServiceException e) {
            throw new WebException(e, WebExceptionCode.WEB_003);
        }
        model.addObject(SUCCESS, env.getRequiredProperty("commit.order.ok"));
        model.setViewName(SHOWCOFFEEMENU);
        return model;
    }


    /**
     * Inner method, what contains logic of counting sail of order
     * @param coffeeDTOs list with coffies, what user choose
     * @param sailDTO object, what contain parameters of sail
     * @return price of order
     */
    private Double countPriceOfOrder(List<CoffeeDTO> coffeeDTOs, SailDTO sailDTO) {
        Double costOfCup;
        Double totalPrice = ZEROD;
        int count;
        int freeCups;
        for (CoffeeDTO coffeeDTO : coffeeDTOs) {
            count = coffeeDTO.getNumberOfCups();
            costOfCup = coffeeDTO.getCost();
            freeCups = count / sailDTO.getFreeCup();
            if (freeCups > ZERO) {
                totalPrice += (count - freeCups) * costOfCup;
            } else {
                totalPrice += count * costOfCup;
            }
        }
        return totalPrice;
    }

    /**
     * Inner method, what create list with numbers of coffee cups
     * what user can choose in page. By default it`s from 1 to 12
     * @return list with numbers
     */
    private List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>(TWELVE);
        int n = ONE;
        for (int i = ZERO; i < TWELVE; i++) {
            numbers.add(i, n);
            n++;
        }
        return numbers;
    }
}
