package com.concurrent.demo.B1.reflex;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ClassReflex {
    public static void main(String[] args) throws Exception {
        TestClass testClass = new TestClass();
        TestClass.ClassInfo classInfo = new TestClass.ClassInfo();
        classInfo.setClassNo("02");
        classInfo.setStudentNum("30");
        TestClass.ClassInfo.TeacherInfo teacherInfo = new TestClass.ClassInfo.TeacherInfo();
        teacherInfo.settAge("40");
        teacherInfo.settName("你爹");
        classInfo.setTeacherInfo(teacherInfo);
        testClass.setClassInfo(classInfo);
        testClass.setName("名字");
        testClass.setSex("性别");
        Map<String, Object> map = getMap(testClass);
        System.out.println(map);
        JSONObject wrap = (JSONObject)JSONObject.wrap(map);
    }

    public static Map<String,Object> getMap(Object obj) throws Exception{
        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        if(fields == null || fields.length == 0){
            return null;
        }

        Map<String,Object> resMap = new HashMap<>();
        for (Field field : fields){
            field.setAccessible(true);
            Class<?> fieldClass = field.get(obj).getClass();
            String className = fieldClass.getName();
            if(className.indexOf("$") > 0){
                Object innerObject = field.get(obj);
                resMap.put(field.getName(),getMap(innerObject));
            }else{
                resMap.put(field.getName(),field.get(obj));
            }
        }
        return resMap;
    }


}
