package com.strsong.calculator;

public class Calculator {

    private double number1;
    private double number2;
    private String operators;

    public  String ADD = "+";
    public  String SUBTRACT = "-";
    public  String MULTIPLY = "X";
    public  String DIVIDE = "/";
    public  String SQUAREROOT = "√";
    public  String SQUARED = "x²";
    public  String INVERT = "1/x";
    public  String SIGN = "+/-";
    public  String SINE = "sin";
    public  String COSINE = "cos";
    public  String TANGENT = "tan";
    public  String Clear = "C";
    public  String LOG = "Log";
    public  String E = "E";
    public  String FACTORIAL = "!";
    public  String EXPONENTIAL = "^";


    public Calculator() {

        number1 = 0;
        number2 = 0;
        operators = "";
    }

    public void setNumber(double number) {
        number1 = number;
    }

    public double getResult() {
        return number1;
    }

    public String toString() {
        return Double.toString(number1);
    }

    protected double doTheMath1(String operator) {

        if (operator.equals(Clear)) {
            number1 = 0;

        } else if (operator.equals(SQUAREROOT)) {
            number1 = Math.sqrt(number1);

        } else if (operator.equals(SQUARED)) {
            number1 = number1 * number1;

        } else if (operator.equals(INVERT)) {
            if (number1 != 0) {
                number1 = 1 / number1;
            }
        } else if (operator.equals(SIGN)) {
            number1 = -number1;
        } else if (operator.equals(SINE)) {
            number1 = Math.sin(Math.toRadians(number1)); // Math.toRadians(number1) converts result to degrees
        } else if (operator.equals(COSINE)) {
            number1 = Math.cos(Math.toRadians(number1)); // Math.toRadians(number1) converts result to degrees
        } else if (operator.equals(TANGENT)) {
            number1 = Math.tan(Math.toRadians(number1)); // Math.toRadians(number1) converts result to degrees
        } else if (operator.equals(LOG)) {
            number1 = Math.log10(number1);
        } else if (operator.equals(E)) {
            number1 = Math.exp(number1);
        } else if (operator.equals(FACTORIAL)) {
            int factor = 1;
            for (int i = 1; i <= number1; i++) {
                factor = factor * i;
            }
            number1 = factor;
        } else {
            doTheMath2();
            operators = operator;
            number2 = number1;
        }

        return number1;
    }

    protected void doTheMath2() {

        if (operators.equals(ADD)) {
            number1 = number2 + number1;
        } else if (operators.equals(SUBTRACT)) {
            number1 = number2 - number1;
        } else if (operators.equals(EXPONENTIAL)) {
          number1 = Math.pow(number2,number1);
        } else if (operators.equals(MULTIPLY)) {
            number1 = number2 * number1;
        } else if (operators.equals(DIVIDE)) {
            if (number1 != 0) {
                number1 = number2 / number1;
            }
        }

    }
}