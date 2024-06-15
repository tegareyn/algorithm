package com.tegareyn.algorithm.nowcode.niuke;

import java.util.Scanner;

/**
 * @Ref NCxx
 * @Description 将这个数变成 所有位数上的数字的乘积。比如285经过一次变换后转化成2*8*5=80.
 * 问题是，要做多少次变换，使得这个数变成个位数
 * @Author Spindrift
 * @Since 2023/3/15 10:33
 * @Version 1.0
 **/
public class ChangeNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer num = scanner.nextInt();
        int count = 0;
        while (num >= 10) {
            count++;
            int temp = 1;
            for (int i = 0; i < num.toString().length(); i++) {
                int temp1 = Integer.parseInt(num.toString().substring(i, i+1));
                temp *= temp1;
            }
            num = temp;
        }
        System.out.println(count);
    }

}
