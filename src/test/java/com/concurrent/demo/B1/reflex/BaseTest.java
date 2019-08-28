package com.concurrent.demo.B1.reflex;

import java.lang.reflect.Field;

public class BaseTest {
    public static void main(String[] args) {
        BaseClass baseClass = new BaseClass("1","1");
        Class<? extends BaseClass> aClass = baseClass.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields){
            System.out.println(field.getName());
        }
    }
}
