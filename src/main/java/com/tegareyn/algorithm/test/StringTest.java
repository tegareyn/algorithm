package com.tegareyn.algorithm.test;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/9/8 16:22
 **/
public class StringTest {


    public static void main(String[] args) {
        String aa = "abc";

        final String intern = aa.intern();

        String bb = new String("abc");
        String cc = new String(intern);
        aa.getBytes();

        System.out.println(aa == bb);
        System.out.println(aa == intern);
        System.out.println(aa == cc);
        System.out.println(bb == cc);
    }

}
