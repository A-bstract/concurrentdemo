package com.concurrent.demo.B1;

public class MainTest2 {
    public static void main(String args[]) throws ClassNotFoundException {
        String regEx = "[`~!]";
        boolean matches = "!".matches(regEx);
        System.out.println(matches);
    }
}