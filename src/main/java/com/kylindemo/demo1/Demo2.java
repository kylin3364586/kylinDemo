package com.kylindemo.demo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auth kylin
 * @date 2023/12/26 18:56
 */
public class Demo2 {

    private String name;
    public  String nickName;
    public  Integer  age;
    public void test() throws ClassNotFoundException {

    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Demo2 demo2 = new Demo2();
        Class<? extends Demo2> aClass = demo2.getClass();
        Class<Demo2> demo2Class = Demo2.class;
        Class<?> aClass1 = Class.forName("com.kylindemo.demo1.Demo2");


        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        Field[] fields = aClass.getFields();


        Constructor<?> declaredConstructor1 = aClass1.getDeclaredConstructor();
        declaredConstructor1.setAccessible(true);
        Object object = declaredConstructor1.newInstance();
        Class<?> aClass3 = object.getClass();
        Field[] fields1 = aClass3.getFields();


        Method[] methods = demo2Class.getMethods();
        System.out.println(methods);

        long id = Thread.currentThread().getId();
        System.out.println(id );
    }
}
