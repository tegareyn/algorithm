package com.tegareyn.algorithm.facecode;


/**
 * 描述：转换字符串中大写字符为小写字符
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/9/14 16:51
 **/
public class TurnToLowercase {

    public static void main(String[] args) {
        System.out.println(toLowerCase("HelloZ"));
    }

    public static String toLowerCase(String s) {
        // 遍历s，当char属于x-y范围时，进行相应转换
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 94) {
                chars[i] = (char)(chars[i] + 32);
            }
        }
        return new String(chars);
    }

}
