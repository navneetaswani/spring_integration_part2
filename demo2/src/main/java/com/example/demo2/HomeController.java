package com.example.demo2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/hello")
    public String hello(){
    	return "Hello";
    }
    
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name){
    	return "Hello "+name;
    }

}
