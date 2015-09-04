package com.leonovich.cofeebreak.web.util;

/**
 * Created by alexanderleonovich on 28.08.15.
 * My global server list of constants for web layer
 */
public class WebConstants {

    public static class Const {
        /* view names */
        public static final String SHOWCOFFEEMENU = "showCoffeeMenu";
        public static final String COFFEMENU = "coffeeMenu";
        public static final String CREATEORDER = "createOrder";
        public static final String CHOOSEADDRESS = "chooseAddress";
        public static final String ADDADDRESS = "addAddress";
        public static final String REGISTRATION = "registration";
        public static final String ADDCOFFEE = "addCoffee";
        public static final String EDITCOFFEE = "editCoffee";
        public static final String LOGINFAILED = "loginfailed";
        public static final String ERROR = "error";

        /* Messages in logger */
        public static final String CUSTOMER_FOR_SAVE = "CustomerDTO object for save from client: ";
        public static final String ADDRESS_FOR_SAVE = "AddressDTO object for save from client: ";
        public static final String COFFEE_FOR_SAVE = "Coffee object from client to saving in database = ";
        public static final String COFFEE_FOR_DELETE = "Coffee identifier for delete = ";
        public static final String COFFEE_FOR_UPDATE = "Coffee object for update from page: ";
        public static final String COFFEEID_FOR_UPDATE = "Coffee identifier for update = ";
        public static final String SEARCH_PARAMETER = "Input string for search = ";


        /* FIELD CONSTANTS */
        public static final int ZERO = 0;
        public static final double ZEROD = 0.0;
        public static final int ONE = 1;
        public static final int FIVE = 5;
        public static final int TWELVE = 12;
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String USER = "ROLE_USER";
        public static final String PRICE = "price";
        public static final String COFFEEORDER = "coffeeOrder";
        public static final String ADDRESSDTO = "addressDTO";
        public static final String ADDRESSDTOS = "addressDTOs";
        public static final String CHECKEDADDRESSID = "checkedAddressId";
        public static final String SUCCESS = "cuccess";
        public static final String NUMBERS = "numbers";
        public static final String COFFEEDTOS = "coffeeDTOs";
        public static final String CUSTOMERDTO = "customerDTO";
        public static final String DELIVERY = "delivery";
        public static final String COFFEEDTO = "coffeeDTO";
        public static final String ERRMSG = "errMsg";

    }
}
