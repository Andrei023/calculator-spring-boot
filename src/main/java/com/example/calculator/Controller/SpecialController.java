package com.example.calculator.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SpecialController {

    @ResponseBody
    @RequestMapping(value="/special",method= RequestMethod.GET)
    public String special(HttpServletRequest request){
        String name=request.getParameter("name");
        return name;
    }
}
