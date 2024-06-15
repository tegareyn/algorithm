package com.tegareyn.algorithm.nowcode.oj;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：敏感字段加密
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/9/7 16:40
 **/
public class OJ01 {

    public static void main(String[] args) {
        String key = "aaa_password_\"a12_45678\"_timeout__100_\"\"_";
        System.out.println(solution(1, key));
    }

    public static String solution(int k, String key) {
        if (key != null) {
            while (key.charAt(0) == '_') {
                key = key.substring(1);
            }
            while (key.charAt(key.length() - 1) == '_') {
                key = key.substring(0, key.length() - 1);
            }
            List<String> list = new ArrayList<>();
            int i = 0, left = i, right = i;
            for (; i < key.length(); i++) {
                char c = key.charAt(i);
                if (c == '\"') {
                    String temp = key.substring(i+1);
                    temp = temp.substring(0, temp.indexOf("\""));
                    list.add("\"" + temp + "\"");
                    final int len = temp.length() + 2;
                    String t2 = key.substring(i + len);
                    i = i + len + trimF(t2);// 要看后面有几个下划线
                    left = i;
                    right = i;
                }
                if (c != '_') {
                    right++;
                } else {
                    if (right > left) {
                        list.add(key.substring(left, right));
                    }
                    left = i + 1;
                    right = i + 1;
                }
            }
            if (key.charAt(key.length() - 1) != '\"') {
                list.add(key.substring(left, right));
            }
            list.set(k, "******");
            return String.join("_", list);
        }
        return "ERROR";
    }

    private static int trimF(String key) {
        int times = 0;
        int i = 0;
        while (i < key.length() && key.charAt(0) == '_') {
            times++;
            key = key.replaceFirst("_", "");
        }
        return times;
    }

}
