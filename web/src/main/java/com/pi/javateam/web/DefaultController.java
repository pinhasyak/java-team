package com.pi.javateam.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
    @RequestMapping(value = "/")
    public String defaultPage(){
        return "EvenytDetails";
    }
}
