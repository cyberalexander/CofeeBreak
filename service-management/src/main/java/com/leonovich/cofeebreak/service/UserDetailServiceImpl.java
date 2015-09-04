package com.leonovich.cofeebreak.service;

import com.leonovich.cofeebreak.dao.ICustomerDao;
import com.leonovich.cofeebreak.dao.exception.DaoException;
import com.leonovich.cofeebreak.domain.Customer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static com.leonovich.cofeebreak.service.exception.ServiceExceptionCode.SERVICE_08;
import static com.leonovich.cofeebreak.service.util.ServiceConstants.Const.ERR_CHECK_CUSTOMER;
import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

/**
 * Created by alexanderleonovich on 28.08.15.
 * Spring security immplementation class
 */
@Service
@Transactional(propagation = SUPPORTS, readOnly = true)
public class UserDetailServiceImpl implements UserDetailsService {
    private static final Logger logger = Logger.getLogger(UserDetailServiceImpl.class);

    public UserDetailServiceImpl() {
    }

    @Autowired
    private ICustomerDao customerDao;

    /**
     * Method check parameters of User who try sign in on site
     * @param email - unique login of user
     * @return Spring security userDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        Customer customer = null;
        if (null != email) {
            // с помощью нашего сервиса CustomerService получаем Customer
            try {
                customer = customerDao.getByLogin(email);
            } catch (DaoException e) {
                logger.error(SERVICE_08.toString() + e);
            }
            // указываем роли для этого пользователя
            Set<GrantedAuthority> roles = new HashSet();
            // на основании полученныйх даных формируем объект UserDetails
            // который позволит проверить введеный пользователем логин и пароль
            // и уже потом аутентифицировать пользователя
            if (null != customer) {
                roles.add(new SimpleGrantedAuthority(customer.getRole().name()));
                UserDetails userDetails =
                        new org.springframework.security.core.userdetails
                                .User(customer.getLogin(), customer.getPassword(), roles);
                logger.info("Customer is authorizated "
                        + userDetails.getUsername() + ", user-authorities "
                        + userDetails.getAuthorities());
                return userDetails;
            }else {
                throw new UsernameNotFoundException(ERR_CHECK_CUSTOMER);
            }
        }
        return null;
    }
}
