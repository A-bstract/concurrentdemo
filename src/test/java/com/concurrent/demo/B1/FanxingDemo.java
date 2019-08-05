package com.concurrent.demo.B1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FanxingDemo<T>{

    private T v1;

    public FanxingDemo(T v1) {
        this.v1 = v1;
    }

    public FanxingDemo() {
        super();
    }

    public T getV1(){
        return v1;
    }

    //前面<F>声明一个泛型 用于后面参数F
    public static <F> F test(F d){
        return (F)new Integer(111);
    }
}
