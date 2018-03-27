package com.example.calculator.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(HttpServletRequest request){
        String s="Ahoy";
        HttpSession session=request.getSession();
        s=(String)session.getAttribute("display");
        return s;
    }
}
