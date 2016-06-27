package org.mliuframework.spring.orm.ibatis.mapper;

import org.mliuframework.spring.orm.ibatis.bo.Customer;

import java.util.List;

/**
 * Created by Michael on 6/25/16.
 */
public interface CustomerMapper {

    Customer selectByPrimaryKey(Long id);

    List<Customer> selectAll();

    Customer insert(Customer customer);

    Customer insertSelective(Customer customer);

    void updateByPrimaryKeySelective(Customer customer);

}