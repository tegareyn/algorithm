package com.tegareyn.algorithm.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 描述：有效的括号
 *
 * @author MoCheng
 * @version 1.0
 * @since 2023/8/4 09:16
 **/
public class LC20 {
    public static void main(String[] args) {
        System.out.println(solution("()[({({[})})]{}"));
    }

    public static boolean solution(String line) {
        Map<Character,Character> map = new HashMap<Character,Character>(){{
            put(')', '('); put('}', '{'); put(']', '['); put('?','?');
        }};
        Stack<Character> stack = new Stack<>();
        for (Character c : line.toCharArray()) {
            if (map.containsKey(c)) {
                if (map.get(c).equals(stack.pop())) {
                    continue;
                } else {
                    return false;
                }
            }
            stack.push(c);
        }
        return stack.empty();
    }

    public static boolean solution1(String line) {
        Stack<Character> stack = new Stack<>();
        for (Character c : line.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '['){
                stack.push(']');
            } else if (stack.empty() || stack.pop()!= c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
