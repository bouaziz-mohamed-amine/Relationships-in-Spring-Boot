package com.cudapp.crud.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {


    @RequestMapping({"/hello"})
    public String hello(){
        return  "hello World";
    }
}
