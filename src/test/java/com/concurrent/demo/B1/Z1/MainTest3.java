package com.concurrent.demo.B1.Z1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest3 {
    public static void main(String args[]){
        /*String str = "abccba";
        String reg = "(..)\\1(..)\\2";
        System.out.println(str.matches(reg));*/

        /*System.out.println("\\e22".matches("[\\\\][a-z][\\d]+"));
        System.out.println(stringFilter("\\12e2334", "[\\\\][\\d]*"));
        System.out.println("\\12e2334".replaceAll("\\d",""));*/

        String source = "jhdhj222\\";
        String regGroup = "(\\d+)([a-z]+)";
        Pattern compile = Pattern.compile(regGroup);
        Matcher matcher = compile.matcher(source);
        matcher.find();
        //System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        //System.out.println(matcher.group(3));
    }


    public static String stringFilter(String sourceString, String regExStr){
        Pattern p = Pattern.compile(regExStr);
        Matcher m = p.matcher(sourceString);
        return m.replaceAll("").trim();
    }
}
