package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }
    @RequestMapping("/service")
    public String service(){
        return "service";
    }

    @RequestMapping("contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping(value="/404")
    public String error404(){
        return "404";
    }
}