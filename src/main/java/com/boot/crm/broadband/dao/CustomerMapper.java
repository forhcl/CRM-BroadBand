package com.boot.crm.broadband.dao;

import com.boot.crm.broadband.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hogan_Lee
 * @create 2019-12-02 13:48
 */
@Mapper
@Repository
public interface CustomerMapper {

    /**
     * 查询指定条件的客户列表
     * @return 客户列表
     */
    List<Customer> customerList(String customerName,String major,String level);

    /**
     * 查询指定id的用户
     * @param customerId
     * @return
     */
    Customer findCustomer(Integer customerId);

    /**
     * 删除指定Id的客户
     * @param customerId
     */
    int deleteCustomer(Integer customerId);

    /**
     * 添加用户并返回回填了id的用户
     * @param customer
     * @return
     */
    int addCustomer(Customer customer);

    /**
     * 修改用户
     * @param customer
     * @return
     */
    int updateCustomer(Customer customer);

    /**
     * 查询所有的专业
     * @return
     */
    String[] findAllMajor();

    /**
     * 查询所有的级别
     * @return
     */
    String[] findAllLevel();
}
