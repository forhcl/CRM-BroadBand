package com.boot.crm.broadband.exception;

import com.boot.crm.broadband.entity.Customer;

/**
 * @author Hogan_Lee
 * @create 2019-12-02 16:50
 */
public class CustomerNotFoundException extends RuntimeException {
    private Integer cust_id;

    public CustomerNotFoundException(Integer CustomerId){
        cust_id=CustomerId;
    }

    public Integer getCust_id() {
        return cust_id;
    }
}
