package com.boot.crm.broadband.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Constraint;

/**
 * @author Hogan_Lee
 * @create 2019-12-06 12:17
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }
}
