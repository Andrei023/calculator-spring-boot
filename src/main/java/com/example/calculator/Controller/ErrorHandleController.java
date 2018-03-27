package com.example.calculator.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ErrorHandleController implements ErrorController{

    private static final String PATH="/error";

    @RequestMapping(value=PATH)
    public String error(){
        return "Error page";
    }

    @Override
    public String getErrorPath(){
        return PATH;
    }
}
