package com.tegareyn.algorithm.facecode;

import java.util.*;

/**
 * 描述：最大括号深度
 *
 * @author mocheng
 * @version 1.0
 * @see MaxDepthOfBracket
 * @since 2024/1/23 22:29
 **/
public class MaxDepthOfBracket {
    private static final Set<Character> bracket = new HashSet<>();
    private static final Map<Character, Character> bMap = new HashMap<>();
    static {
        bracket.add('(');
        bracket.add(')');
        bracket.add('[');
        bracket.add(']');
        bracket.add('{');
        bracket.add('}');
        bMap.put(')', '(');
        bMap.put(']', '[');
        bMap.put('}', '{');
    }

    public static void main(String[] args) {
        String line = "({{{{..([])}}}}{})";
        System.out.println(maxDepthBracket(line));
    }

    public static int maxDepthBracket(String line) {
        int max = 0;
        if (line == null || line.length() == 0 || line.length() % 2 != 0) {
            return max;
        }
        Stack<Character> stack = new Stack<>();
        for (Character c : line.toCharArray()) {
            if (!bracket.contains(c)) {
                continue;
            }
            if ((stack.size() == 0 && bMap.containsKey(c))
                    || (bMap.containsKey(c) && bMap.get(c) != stack.pop())) {
                return 0;
            }
            if (!bMap.containsKey(c)) {
                stack.push(c);
            }
            max = Math.max(max, stack.size());
        }
        return max;
    }

}
