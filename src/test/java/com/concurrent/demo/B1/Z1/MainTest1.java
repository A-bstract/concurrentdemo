package com.concurrent.demo.B1.Z1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest1 {
    //测试邮箱
    public static void main(String args[]){
        String regStr = "[0-9]+[@][a-z\\d]+\\.com";
        String source = "15710563453@qq.com";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(source);
        System.out.println(matcher.matches());
    }
}
