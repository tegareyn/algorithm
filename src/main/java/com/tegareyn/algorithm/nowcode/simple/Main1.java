package com.tegareyn.algorithm.nowcode.simple;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description 数字颠倒
 * @Author mocheng
 * @Since 2021/11/18 22:02
 * @Version 1.0
 **/
public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        char[] b = a.toCharArray();
        for (int i= 0;i<a.length();i++) {
            System.out.print(b[b.length-1-i]);
        }
    }
}
