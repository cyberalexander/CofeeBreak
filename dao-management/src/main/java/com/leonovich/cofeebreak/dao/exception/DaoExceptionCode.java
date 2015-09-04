package com.leonovich.cofeebreak.dao.exception;

/**
 * Error codes for exceptions in Dao layer
 * Created by alexanderleonovich on 28.08.15.
 */
public enum DaoExceptionCode {

    DAO_01("Can`t get object by id!"),
    DAO_02("Can`t get list of objects!"),
    DAO_03("Can`t add object!"),
    DAO_04("Can`t update object!"),
    DAO_05("Can`t delete object!"),
    DAO_06("Can`t create hql!");

    private final String value;

    DaoExceptionCode(String s) {
        value = s;
    }

    public boolean equalsValue(String value2) {
        return (value2 != null) && value.equals(value2);
    }

    public String toString() {
        return value;
    }
}
