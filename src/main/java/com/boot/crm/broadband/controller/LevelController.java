package com.boot.crm.broadband.controller;

import com.boot.crm.broadband.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hogan_Lee
 * @create 2019-12-02 20:22
 */
@RestController
@RequestMapping("/level")
public class LevelController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String[] findAllLevel() {
        String[] levels = customerService.findAllLevel();
        return levels;
    }
}
