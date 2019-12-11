package com.boot.crm.broadband.service.impl;

import com.boot.crm.broadband.dao.CustomerMapper;
import com.boot.crm.broadband.entity.Customer;
import com.boot.crm.broadband.service.CustomerService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hogan_Lee
 * @create 2019-12-02 13:52
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> customerList(int pageNum, int pageSize,String customerName,String major,String level) {
        //调用pagehelper分页，采用startPage方式。注意：startPage应放在Mapper查询函数之前
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("cust_id ASC");
        List<Customer> customers=customerMapper.customerList(customerName,major,level);
        return customers;
    }

    @Override
    public Customer findCustomer(Integer customerId) {
        return customerMapper.findCustomer(customerId);
    }

    @Override
    public int deleteCustomer(Integer customerId) {
        return customerMapper.deleteCustomer(customerId);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public int addCustomer(Customer customer) {
        return customerMapper.addCustomer(customer);
    }

    @Override
    public String[] findAllMajor() {
        return customerMapper.findAllMajor();
    }

    @Override
    public String[] findAllLevel() {
        return customerMapper.findAllLevel();
    }
}
