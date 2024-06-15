package com.tegareyn.algorithm.facecode;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @ClassName MainTest
 * @Description 输出字符串中各字符出现的次数
 * @Author mocheng
 * @Since 2021/11/10 16:21
 * @Version 1.0
 **/
public class CharTimesOfString {

    static String symbol = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] arsh) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            Map<String, Integer> map = fillKeyToMap();
            String line = sc.nextLine();
            for(int i =0; i< line.length();i++) {
                String key = line.charAt(i)+"";
                if(map.containsKey(key)) {
                    map.put(key, map.get(key) +1);
                }
            }
            for (String key : map.keySet()) {
                System.out.println(key + ":" + map.get(key));
            }
        }
    }

    private static Map<String, Integer> fillKeyToMap() {
        Map<String, Integer> map = new TreeMap<>();
        for(int i =0; i< symbol.length();i++) {
            map.put(symbol.charAt(i) + "", 0);
        }
        return map;
    }
}
