package com.leonovich.cofeebreak.service.exception;

/**
 * Enum of messages with exception-codes for Service-layer
 * @author Alexander Leonovich
 * Created 28.08.15.
 * @version 1.0
 */
public enum ServiceExceptionCode {
    SERVICE_01("Can`t get Customer`s AddressDTOs by LOGIN of Customer! =>"),
    SERVICE_02("Can`t save address! =>"),
    SERVICE_03("Can`t get CoffeeDTO! =>"),
    SERVICE_04("Can`t get all CoffeeDTOs! =>"),
    SERVICE_05("Can`t save Coffee! =>"),
    SERVICE_06("Can`t update Coffee! =>"),
    SERVICE_07("Can`t delete Coffee from database! =>!"),
    SERVICE_08("Can`t get Customer by ID! =>"),
    SERVICE_09("Can`t get all Customers! =>"),
    SERVICE_10("Can`t save Customer! =>"),
    SERVICE_11("Can`t update Customer! =>"),
    SERVICE_12("Can`t delete Customer! =>"),
    SERVICE_13("Can`t get Customer by LOGIN! =>"),
    SERVICE_14("Can`t save Order! =>"),
    SERVICE_15("Can`t get Sail from database! =>"),
    SERVICE_16("Can`t update Sail! =>"),
    SERVICE_17("Can`t find coffies! =>");


    private final String value;

    private ServiceExceptionCode(String s) {
        value = s;
    }

    public boolean equalsValue(String value2) {
        return (value2 != null) && value.equals(value2);
    }

    public String toString() {
        return value;
    }
}
