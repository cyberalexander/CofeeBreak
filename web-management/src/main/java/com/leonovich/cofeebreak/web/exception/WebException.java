package com.leonovich.cofeebreak.web.exception;

/**
 * Created by alexanderleonovich on 29.08.15.
 * Create custom exception on web layer.
 */
public class WebException extends Exception {

    private WebExceptionCode code;
    private Object[] params;
    private String message;

    public WebException(Throwable t, WebExceptionCode code, Object... params) {
        super(t);
        this.code = code;
        this.params = params;
        this.message = String.format(code.toString(), params);
    }

    public WebException(WebExceptionCode code, Object... params) {
        this.code = code;
        this.params = params;
        this.message = String.format(code.toString(), params);
    }

    public WebExceptionCode getCode() {
        return code;
    }

    public void setCode(WebExceptionCode code) {
        this.code = code;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
