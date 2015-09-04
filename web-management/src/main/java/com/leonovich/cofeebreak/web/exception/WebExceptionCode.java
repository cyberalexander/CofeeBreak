package com.leonovich.cofeebreak.web.exception;

/**
 * Created by alexanderleonovich on 29.08.15.
 * Enuming message error on web layer.
 * and send response to user.
 */
public enum WebExceptionCode {

    WEB_000("Cannot get all coffeeDTOs!"),
    WEB_001("Cannot get coffeeDTO by unique ID from getting client!"),
    WEB_002("Cannot get addressDTOs by customer login!"),
    WEB_003("Cannot save order!"),
    WEB_004("Cannot save coffee!"),
    WEB_005("Cannot get coffeeDTO from server by unique ID!"),
    WEB_006("Cannot update coffee!"),
    WEB_007("THE PAGE CAN`NOT BE DISPLAYED!!! SORRY..."),
    WEB_008("THIS LOGIC IS NOT REALIZED YET! SORRY, TRY LATER!"),
    WEB_009("Cannot delete coffee!"),
    WEB_010("Cannot get sailDTO from server by unique ID!"),
    WEB_011("Cannot update sailDTO!"),
    WEB_012("Cannot save Customer!"),
    WEB_013("Cannot save Address!"),
    WEB_014("Cannot find Coffee by search parameter from client!");

    private final String value;

    private WebExceptionCode(String s) {
        value = s;
    }

    public boolean equalsValue(String value2) {
        return (value2 != null) && value.equals(value2);
    }

    public String toString() {
        return value;
    }
}
