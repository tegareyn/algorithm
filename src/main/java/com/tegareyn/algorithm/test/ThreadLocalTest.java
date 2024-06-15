package com.tegareyn.algorithm.test;

import java.util.LinkedList;


/**
 * @ClassName TmpTest
 * @Description ThreadLocal
 * @Author mocheng
 * @Since 2021/11/6 13:15
 * @Version 1.0
 **/
public class ThreadLocalTest {

    public static void main(String[] args) {
        String a = new String("aaa");
        String intern = a.intern();//将字符串值aaa强制放入字符串常量池：若已经存在，则直接返回常量池中该串地址；若不存在，则将其放入常量池，并返回常量池中字符串地址
        LinkedList linkedList  = new LinkedList();

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set(a);

        ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
        threadLocal1.set(2);

        System.out.println(threadLocal.get() + " ### " + threadLocal1.get());
        String as = "";
        as.startsWith("");


//        Proxy.newProxyInstance();
    }


    public static int aaa(int num) {
        return num/2;
    }



}
