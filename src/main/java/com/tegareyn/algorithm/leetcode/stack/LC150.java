package com.tegareyn.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * 描述：逆波兰表达式求值
 *
 * @author MoCheng
 * @version 1.0
 * @since 2023/8/14 11:39
 **/
public class LC150 {

    public static void main(String[] args) {
        String[] array = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(solution(array));
    }

    public static int solution(String[] array) {
        Stack<String> stack = new Stack<>();
        int first, second;
        for (String s : array) {
            switch (s) {
                case "+":
                    second = Integer.parseInt(stack.pop());
                    first = Integer.parseInt(stack.pop());
                    stack.push(first + second + "");
                    break;
                case "-":
                    second = Integer.parseInt(stack.pop());
                    first = Integer.parseInt(stack.pop());
                    stack.push(first - second + "");
                    break;
                case "*":
                    second = Integer.parseInt(stack.pop());
                    first = Integer.parseInt(stack.pop());
                    stack.push(first * second + "");
                    break;
                case "/":
                    second = Integer.parseInt(stack.pop());
                    first = Integer.parseInt(stack.pop());
                    stack.push(first / second + "");
                    break;
                default:
                    stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
