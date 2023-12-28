package com.kylindemo.cglib;

/**
 * @auth kylin
 * @date 2023/12/28 11:11
 */
public class Test {

    public static void main(String[] args) {
        Solver solver = new Solver();
        Solver proxyInstance = (Solver) new CglibProxyFactory(solver).getProxyInstance();
        String test = proxyInstance.test();
        System.out.println(test);
    }
}
