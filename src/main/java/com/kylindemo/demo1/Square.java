package com.kylindemo.demo1;

/**
 * @auth kylin
 * @date 2023/12/27 17:56
 */
public class Square {
    long width;
    public Square(long l) {
        width = l;
    }
    public static void main(String arg[]) {
        Square a, b, c;
        a = new Square(42L);
        b = new Square(42L);
        c = b;
        long s = 42L;
        System.out.println(a == b);
//        System.out.println(s == a);
        System.out.println(b == c);
        System.out.println(a.equals(s));
    }
}