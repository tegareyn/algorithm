package com.tegareyn.algorithm.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapAndCollectionTest {

    private static int a;
    private int b;
    public static void main(String[] args) throws Exception {
        Hashtable aa = new Hashtable();
        HashMap bb = new HashMap(2);
        bb.put("", "");
        short s1 = 1;
        s1 = (short) (s1 + 1);
        s1 += 1;
        bb.remove("");

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        /*父子线程可继承ThreadLocal*/
        InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
        inheritableThreadLocal.get();

//        setTest();
//        System.out.println(tryCatch());
        mapTest();
//        forTest();

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("", "");
    }

    private static void setTest() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(null);
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("null");
    }

    private static void mapTest() {
        Hashtable<String, String> table = new Hashtable<>();
        HashMap<String, String> hashMap = new HashMap<>();
        TreeMap<String, String> treeMap = new TreeMap<>();
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        table.put("null", "null");
        hashMap.put(null, null);
        treeMap.put("null", null);
        concurrentHashMap.put("null", "null");
    }

    private static String tryCatch() {
        int a = 0;
        try {
            a = 10/0;
//            a = a + 2;
            System.out.println("try 块儿在这呢...");
            return "try" + a;
        } catch (Exception e) {
            a = a + 5;
            System.out.println("catch 块儿在这呢...");
            return "catch" + a;
        } finally {
            a = a + 8;
            System.out.println("finally块儿在这呢...");
//            return "finally" + a;
        }

//        在try块儿或者catch块儿中如果有return语句,则编译器会先将try-catch-finally块儿按顺序编译完成,
//        即：执行时先执行try或catch中return以上的代码,再执行执行finally中已编译的语句；
//                如果finally中也有return语句,则执行完finally块就会就整个结束方法,
//                如果finally中没有return语句,则继续执行已编译完成的try或catch中的return的代码
//
//                -------一切都是因为finally块儿霸气侧漏
    }

    private static void forTest() {
        ok:
        for (int a = 0; a < 10; a++) {
            System.out.println(a);
            if (a == 6) {
                break ok;
            }
        }
    }

    public void test() {

    }

//    public Main test() {
//
//        return  null;
//    }

    private static void test1() {

    }

    public static class Test1{
        private void test() {
            test();
            test1();
            System.out.println(a);
        }
    }

    private class A {
        private A(){}
    }
}
