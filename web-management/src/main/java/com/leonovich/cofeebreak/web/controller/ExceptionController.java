package com.leonovich.cofeebreak.web.controller;

import com.leonovich.cofeebreak.web.exception.WebException;
import org.apache.log4j.Logger;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import static com.leonovich.cofeebreak.web.exception.WebExceptionCode.WEB_007;
import static com.leonovich.cofeebreak.web.exception.WebExceptionCode.WEB_008;
import static com.leonovich.cofeebreak.web.util.WebConstants.Const.ERRMSG;
import static com.leonovich.cofeebreak.web.util.WebConstants.Const.ERROR;

/**
 * This is controller advice. It is processing exception.
 * Created by alexanderleonovich on 30.08.15.
 */
@ControllerAdvice
public class ExceptionController {
    private static Logger logger = Logger.getLogger(ExceptionController.class);

    /**
     * This method processing WebException and
     * return "error" page and error message.
     * @param ex Get WebException.
     * @return ModelAndView - "error" page and error message.
     */
    @ExceptionHandler(WebException.class)
    public ModelAndView customException(WebException ex) {
        ModelAndView model = new ModelAndView(ERROR, ERRMSG, ex.getMessage());
        logger.info(ex.getMessage());
        return model;
    }

    /**
     * This method work when incoming Not Supported Exception in Http Request.
     * Example: 405 error.
     * @return ModelAndView - "error" page and error message
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ModelAndView statusCustomException() {
        ModelAndView model = new ModelAndView(ERROR, ERRMSG, WEB_007.toString());
        logger.info(WEB_007.toString());
        return model;
    }

    /**
     * This method work when incoming UnsupportedOperationException from server.
     * Example: UnsupportedOperationException.
     * @return ModelAndView - "error" page and error message
     */
    @ExceptionHandler(UnsupportedOperationException.class)
    public ModelAndView unsupportedOperationException() {
        ModelAndView model = new ModelAndView(ERROR, ERRMSG, WEB_008.toString());
        logger.info(WEB_008.toString());
        return model;
    }
}
