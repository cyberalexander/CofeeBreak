INSERT INTO `coffeebreak`.`T_CUSTOMER` (`F_CUSTOMER_ID`, `F_FIRST_NAME`, `F_LAST_NAME`, `F_LOGIN`, `F_PASSWORD`, `F_ROLE`)
VALUES ('1', 'Alexander', 'Leonovich', 'CyberAlexander', '81dc9bdb52d04dc20036dbd8313ed055', 'ROLE_ADMIN');
INSERT INTO `coffeebreak`.`T_CUSTOMER` (`F_CUSTOMER_ID`, `F_FIRST_NAME`, `F_LAST_NAME`, `F_LOGIN`, `F_PASSWORD`, `F_ROLE`)
VALUES ('2', 'Dmitry', 'Vysotskiy', 'dima', '0f5b25cd58319cde0e6e33715b66db4c', 'ROLE_USER');
INSERT INTO `coffeebreak`.`T_CUSTOMER` (`F_CUSTOMER_ID`, `F_FIRST_NAME`, `F_LAST_NAME`, `F_LOGIN`, `F_PASSWORD`, `F_ROLE`)
VALUES ('3', 'Karlos', 'Valentino', 'karl', 'f47636673b14c54021a69dc06f6a19fb', 'ROLE_USER');

INSERT INTO `coffeebreak`.`T_ADDRESS` (`F_STREET`, `F_HOUSE`, `F_APARTMENT`, `F_CUSTOMER_ID`)
VALUES ('Kirova', '8', '34', '1');
INSERT INTO `coffeebreak`.`T_ADDRESS` (`F_STREET`, `F_HOUSE`, `F_APARTMENT`, `F_CUSTOMER_ID`)
VALUES ('Leningradskaia', '17', '89', '1');
INSERT INTO `coffeebreak`.`T_ADDRESS` (`F_STREET`, `F_HOUSE`, `F_APARTMENT`, `F_CUSTOMER_ID`)
VALUES ('Kalinina', '22', '17', '2');

INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Espresso', 'Espresso 1oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Espresso Machiato', 'Espresso 2oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Espresso con Panna', 'Whipped cream 3oz, espresso 2oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Freddo', 'Espresso 2oz, vanilla ice cream 3oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Marocchino', 'Streamed milk 2oz, french pressed coffee 2oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Stretto', 'Espresso 2oz, ice cubes', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Caffe Latte', 'Milk foam 0.1oz, Streamed milk 10oz, espresso 2oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Flat White', 'Streamed milk 4oz, espresso 2oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Caffe Breve', 'Half & half 3oz, espresso 2oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Ristretto', 'Concentrated espresso 0.75oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Irish', 'Chocolate 2oz, espresso 4oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Granita con Panna', 'Espresso 2oz, ice cubes, foamed milk 1oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Cappuccino', 'Foamed milk 2oz, streamed milk 2oz, espresso 2oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Caffe Mocha', 'Streamed milk 1oz, chocolate 2oz, espresso 2oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Americano', 'Hot water 3oz, espresso 2oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Corretto', 'Concentrated espresso 0.75oz, hot water 0.75oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Con Leche', 'Whipped cream 3oz, espresso 2oz, hot water 2oz', '10');
INSERT INTO `coffeebreak`.`T_COFFEE` (`F_SORT`, `F_DESCRIPTION`, `F_COST`)
VALUES ('Crappa', 'Hot water 3oz, espresso 2oz, streamed milk 1oz', '10');

INSERT INTO `coffeebreak`.`T_SAIL` (`F_FREE_CUP`, `F_FREE_DELIVERY`, `F_DELIVERY`) VALUES ('5', '10', '2');

INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('1', '1');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('1', '1');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('4', '1');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('4', '1');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('4', '1');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('4', '1');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('4', '1');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('4', '1');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('2', '2');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('7', '2');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('7', '2');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('7', '2');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('7', '2');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('7', '2');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('7', '2');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('7', '2');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('10', '2');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('10', '2');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('10', '2');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('12', '3');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('12', '3');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('12', '3');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('12', '3');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('12', '3');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('14', '3');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('14', '3');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('14', '3');
INSERT INTO `coffeebreak`.`T_COFFEE_CUP` (`F_COFFEE_ID`, `F_ORDER_ID`) VALUES ('15', '3');

INSERT INTO `coffeebreak`.`T_ORDER` (`F_ORDER_DATE`, `F_TOTAL_PRICE`, `F_CUSTOMER_ID`)
VALUES ('2015-09-04 17:18:10', '80', '1');
INSERT INTO `coffeebreak`.`T_ORDER` (`F_ORDER_DATE`, `F_TOTAL_PRICE`, `F_CUSTOMER_ID`)
VALUES ('2015-09-04 17:20:45', '90', '1');
INSERT INTO `coffeebreak`.`T_ORDER` (`F_ORDER_DATE`, `F_TOTAL_PRICE`, `F_CUSTOMER_ID`)
VALUES ('2015-09-04 17:22:38', '70', '2');

