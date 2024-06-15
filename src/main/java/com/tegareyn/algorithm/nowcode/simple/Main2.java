package com.tegareyn.algorithm.nowcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test2
 * @Description 字符串颠倒
 * @Author mocheng
 * @Since 2021/11/17 22:05
 * @Version 1.0
 **/
public class Main2 {

    public static void main(String[] args) {
        String line = "111111aAbbbbbbrbrbr";
        fillMapValue(line);

    }

    private static Integer getValue(Map<String, Integer> map, String symbol) {
        int value = 0;
        if (map!=null&&map.size()>0) {
            String key = symbol.toLowerCase();
            value = map.getOrDefault(key, 0);
        }
        return value;
    }

    private static Map<String, Integer> fillMapValue(String line) {
        Map<String, Integer> map = new HashMap<>();
        if (line!=null&&line.length()>0) {
            char[] chars = line.toCharArray();
            for(Character c : chars) {
                String key = (c + "").toLowerCase();
                map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
            }
        }
        return map;
    }
}
