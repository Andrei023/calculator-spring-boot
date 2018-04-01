package com.example.calculator.Controller;

import com.example.calculator.Model.Calculator;
import com.example.calculator.Service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class IndexController {

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model, Calculator calculator) {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String indexx(HttpServletRequest request, @Valid Calculator calculator, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "index";
        }

        HttpSession session = request.getSession();

        if (request.getParameter("operator").equals("clear")) {
            session.invalidate();
            return "index";
        } else {
            if (session.isNew()) {
                String display = request.getParameter("display");
                String operator = request.getParameter("operator");
                session.setAttribute("display", display);
                session.setAttribute("operator", operator);
            } else {

                String result;

                String display = (String) session.getAttribute("display"); //old operand
                String operator = (String) session.getAttribute("operator"); //old operator

                String display2 = request.getParameter("display"); //new operand
                String operator2 = request.getParameter("operator"); //new operator


                if (display.equals("0") && (operator.equals("*"))) {
                    session.setAttribute("display", display2);
                    session.setAttribute("operator", operator2);
                    return "index";
                }

                result=calculatorService.operate(display,display2,operator);

                session.setAttribute("display", result);
                session.setAttribute("operator", operator2);

                result=calculatorService.format(result);
                model.addAttribute("result", result);

                if (operator2.equals("+")) {
                    model.addAttribute("result", "");
                }

                if (operator2.equals("-")) {
                    model.addAttribute("result", "");
                }

                if (operator2.equals("*")) {
                    model.addAttribute("result", "");
                }

                if (operator2.equals("/")) {
                    model.addAttribute("result", "");
                }

            }
            return "index";
        }
    }
}