package com.tegareyn.algorithm.nowcode.niuke;

import java.util.Scanner;

/**
 * 描述：计算A+B
 * 每行的第一个数N，表示本行后面有N个数。
 * 如果N=0时，表示输入结束，且这一行不要计算
 *
 * 对于每一行数据需要在相应的行输出和。
 *
 * @author mocheng
 * @version 1.0
 * @see Main4
 * @since 2024/1/29 11:55
 **/
public class Main4 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int nums = scanner.nextInt();
            if (nums == 0) {
                break;
            }
            int sum = 0;
            for (int i = 0; i < nums; i++) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        }
    }

}
