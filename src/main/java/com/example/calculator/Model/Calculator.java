package com.example.calculator.Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Calculator {

    @NotNull
    @Size(min=1, max=7)
    private String display;

    @Override
    public String toString() {
        return "Calculator{" +
                "display=" + display +
                '}';
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
