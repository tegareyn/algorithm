package com.tegareyn.algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Ref LC567
 * @Description 字符串的排列
 * @Author Spindrift
 * @Since 2022/11/29 17:28
 * @Version 1.0
 **/
public class LC567 {

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        dealString(s1, map);
        int length = s1.length();// 窗口大小
        Map<Character, Integer> ser = new HashMap<>();
        int right;
        for (int i = 0; i < s2.length(); i++) {
            right = i + length;
            if (right > s2.length()) {
                return false;
            }
            char key = s2.charAt(i);
            ser = new HashMap<>();
            if (map.containsKey(key)) {
                boolean flag = true;
                dealString(s2.substring(i, right), ser);
                if (map.size() == ser.size()) {
                    for (Character next : map.keySet()) {
                        if (!ser.containsKey(next) || !ser.get(next).equals(map.get(next))) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void dealString(String s2, Map<Character, Integer> ser) {
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (ser.containsKey(c)) {
                ser.put(c, ser.get(c) + 1);
            } else {
                ser.put(c, 1);
            }
        }
    }
}
