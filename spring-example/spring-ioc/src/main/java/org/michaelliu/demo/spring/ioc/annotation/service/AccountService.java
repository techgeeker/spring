package org.michaelliu.demo.spring.ioc.annotation.service;

import org.michaelliu.demo.spring.ioc.annotation.dao.AccountDao;
import org.michaelliu.demo.spring.ioc.annotation.dao.AnotherAccountDao;
import org.michaelliu.demo.spring.ioc.beans.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by michael on 2016/8/2.
 */
@Component
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    // @Resource find beans by name
    @Resource(name = "newAccountDao")
    private AnotherAccountDao myAccountDao;

    public Account findById(Long id) {
        return accountDao.selectById(id);
    }

    public Account findByName(String name) {
        return  myAccountDao.selectByName(name);
    }

}
