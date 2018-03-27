package com.example.calculator.Service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements CalculatorServiceInterface{

    @Override
    public String operate(String fOperand, String sOperand, String operator){

        double firstOperand=Double.parseDouble(fOperand);
        double secondOperand=Double.parseDouble(sOperand);
        double result=0;

        switch (operator)
        {
            case "+":
                result=firstOperand+secondOperand;
                break;
            case "-":
                result=firstOperand-secondOperand;
                break;
            case "*":
                result=firstOperand*secondOperand;
                break;
            case "/":
                result=firstOperand/secondOperand;
                break;
            case "=":
                result=firstOperand;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");

        }
        return Double.toString(result);
    }

    @Override
    public String format(String result) {
        double x=Double.parseDouble(result);
        if( x%1 == 0) {
            return Integer.toString((int) x);
        }
        else{
            return result;
        }
    }
}
