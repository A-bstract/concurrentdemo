package com.concurrent.demo.B1.model;

import java.io.BufferedInputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class MainTest {
    public static void main(String args[]){
        //静态代理
        /*ITestDao t1 = new TestDao();
        ITestDao p = new ProxyStatic(t1);
        p.getInfo("1");*/

        //动态代理
        ITestDao t1 = new TestDao();
        //中介类
        DynamicProxy dp = new DynamicProxy();
        ITestDao bind = (ITestDao)dp.bind(t1);

        Class<? extends ITestDao> aClass = bind.getClass();
        Field[] fields = aClass.getFields();
        List<Field> fields1 = Arrays.asList(fields);
        fields1.stream().forEach(field -> System.out.println(field.toString()));

        bind.getInfo("1");
    }
}
