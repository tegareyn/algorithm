package com.tegareyn.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * 描述：
 *
 * @author MoCheng
 * @version 1.0
 * @since 2023/8/4 12:34
 **/
public class LC1047 {

    public static void main(String[] args) {
        System.out.println(solution("abdfsssggsfdbaca"));
    }

    public static String solution(String line) {
        Stack<Character> stack = new Stack<>();
        for (Character c : line.toCharArray()) {
            if (stack.size() > 0) {
                Character pop = stack.pop();
                if (!c.equals(pop)) {
                    stack.push(pop);
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack){
            sb.append(c);
        }
        return sb.toString().trim();
    }
}
