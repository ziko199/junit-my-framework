package de.junit.framework;

public class Calculator {

    public int add(int x, int y){
        return x+y;
    }

    public int multiply(int x, int y){
        return x*y;
    }

    public int divide(int x, int y){
        return x/y;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(40,2));
    }
}
