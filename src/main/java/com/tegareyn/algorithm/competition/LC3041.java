package com.tegareyn.algorithm.competition;


import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * 描述：输入单词需要的最少按键次数 I
 *
 * @author mocheng
 * @version 1.0
 * @see LC3041
 * @since 2024/3/18 14:44
 **/
public class LC3041 {

    public static void main(String[] args) {
        String word = "abcdefthuiddsscxx";
        System.out.println(minimumPushes(word));
    }
    public static int minimumPushes(String word) {
        if (null == word) {
            return 0;
        }
        word = word.trim();
        if(word.length() <= 8) {
            return word.length();
        }
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (char c : word.toCharArray()) {
            if (treeMap.containsKey(c)) {
                treeMap.put(c, treeMap.get(c) + 1);
            } else {
                treeMap.put(c, 1);
            }
        }
        System.out.println(treeMap);
        int[] count = new int[treeMap.size()];
        final Iterator<Character> iterator = treeMap.keySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            final Character next = iterator.next();
            count[i++] = treeMap.get(next);
        }
        Arrays.sort(count);
        System.out.println(Arrays.toString(count));
        int result = 0;
        for (int x = 0, y = count.length - 1; y >= 0; y--, x++) {
            result += count[y] * (x / 8 + 1);
        }
        return result;
    }

}
