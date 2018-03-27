package com.example.calculator.Controller;

import com.example.calculator.Model.Calculator;
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

    @RequestMapping(value="/",method= RequestMethod.GET)
        public String index(HttpServletRequest request,Model model, Calculator calculator){
           return "index";
    }

    @RequestMapping(value="/",method= RequestMethod.POST)
    public String indexx(HttpServletRequest request, @Valid Calculator calculator, BindingResult bindingResult, Model model) {

        //System.out.println("POST!");
        if (bindingResult.hasErrors()) {
            return "index";
        }

        HttpSession session = request.getSession();

        //System.out.println("Display is: "+display);
        //System.out.println("Operator is: "+operator);


        if (request.getParameter("operator").equals("clear")) {
            //session.setAttribute("display", "");
            //session.setAttribute("operator", "");
            session.invalidate();
            System.out.println("you pressed del");
            return "index";
        } else {
            if (session.isNew()) {
                String display = request.getParameter("display");
                String operator = request.getParameter("operator");
                session.setAttribute("display", display);
                session.setAttribute("operator", operator);
            } else {

                String display = (String) session.getAttribute("display"); //old
                String operator = (String) session.getAttribute("operator"); //old

                String display2 = request.getParameter("display"); //new
                String operator2 = request.getParameter("operator"); //new

//            try {
//                String deleteButton = request.getParameter("deleteButton");
//                if(deleteButton.equals("del")){
//                    model.addAttribute("result",0);
//                    return "index";
//                }
//            }catch(Exception e){}

                double result = 23;

                if (display.equals("0") && (operator.equals("*"))) {
                    session.setAttribute("display", display2);
                    session.setAttribute("operator", operator2);
                    return "index";
                }



                if (operator.equals("=")) {
                    result = Double.parseDouble(display);
                    System.out.println("session operator is '='");
                    //model.addAttribute("result",Double.toString(result));
                }
                if (operator.equals("+")) {
                    result = Double.parseDouble(display) + Double.parseDouble(display2);
                }
                if (operator.equals("-")) {
                    result = Double.parseDouble(display) - Double.parseDouble(display2);

                }
                if (operator.equals("*")) {
                    result = Double.parseDouble(display) * Double.parseDouble(display2);

                }

                session.setAttribute("display", Double.toString(result));
                session.setAttribute("operator", operator2);

                model.addAttribute("result", result);
                //request.setAttribute("display",Integer.toString(result));

                if(operator2.equals("+")){
                    model.addAttribute("result","");
                }

                if(operator2.equals("-")){
                    model.addAttribute("result","");
                }

                if(operator2.equals("*")){
                    model.addAttribute("result","");
                }

            }
            return "index";
        }
    }
}