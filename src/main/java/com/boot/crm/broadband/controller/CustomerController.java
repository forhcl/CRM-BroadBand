package com.boot.crm.broadband.controller;

import com.boot.crm.broadband.entity.Customer;
import com.boot.crm.broadband.entity.User;
import com.boot.crm.broadband.exception.CustomerNotFoundException;
import com.boot.crm.broadband.service.CustomerService;
import com.boot.crm.broadband.service.impl.UserDetailServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * @author Hogan_Lee
 * @create 2019-12-02 13:55
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @GetMapping
    public PageInfo<Customer> findAll(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "4") int pageSize,
                                      @RequestParam(value = "name", required = false) String customerName,
                                      @RequestParam(value = "major", required = false) String major,
                                      @RequestParam(value = "level", required = false) String level) {
        List<Customer> customers = customerService.customerList(pageNum, pageSize, customerName, major, level);
        PageInfo<Customer> customerPageInfo = new PageInfo(customers);
        return customerPageInfo;
    }

    @PostMapping
    public Customer addOne(@RequestBody @Valid Customer customer, HttpServletRequest request) {
        //将当前登录用户的id取出来，并设置到对应字段中
        Principal principal = request.getUserPrincipal();
        User user = (User) userDetailService.loadUserByUsername(principal.getName());
        customer.setCust_create_id(user.getId());
        int nums = customerService.addCustomer(customer);
//        if(nums==0){
//            //插入失败
//        }
        return customer;
    }

    @DeleteMapping("/{id:\\d+}")
    public void deleteOne(@PathVariable Integer id) {
        //删除操作影响的行数
        int nums = customerService.deleteCustomer(id);
        if (nums == 0)
            throw new CustomerNotFoundException(id);
    }

    @GetMapping("/{id:\\d+}")
    public Customer findOne(@PathVariable Integer id) {
        //删除操作影响的行数
        Customer customer = customerService.findCustomer(id);
        if (customer == null)
            throw new CustomerNotFoundException(id);
        return customer;
    }

    @PutMapping("/{id:\\d+}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setCust_id(id);
        int nums = customerService.updateCustomer(customer);
        if (nums == 0) {
            throw new CustomerNotFoundException(id);
        }
        return customer;
    }
}
