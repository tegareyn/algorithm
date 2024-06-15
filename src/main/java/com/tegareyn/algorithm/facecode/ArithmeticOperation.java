package com.tegareyn.algorithm.facecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName Main
 * @Description 四则运算
 * @Author mocheng
 * @Since 2022/7/24 17:01
 * @Version 1.0
 **/
public class ArithmeticOperation {

    // stack

    /**
     * 取成对括号，内部括号入栈
     * 1. 拿到所有字符串：(op num1 num2)
     * 2. 字符串入栈：
     *      当匹配到的字符串以）结尾时，开始字符串出栈；将出栈的字符串放入顺序队列；当出栈字符串以（开头时，停止出栈，并开始计算
     *          此时顺序队列的字符串格式为：num2)，num1，(op
     *          则开始计算结果，并将计算结果再次入栈；
     *      继续2步骤。
     * @param args
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] lisps = scanner.nextLine().split(" ");
            Stack<String> stack = new Stack<>();
            for (String s : lisps) {
                stack.push(s);
                while (stack.peek().charAt(stack.peek().length() - 1) == ')') {
                    List<String> list = new ArrayList<>();
                    while (!stack.peek().startsWith("(")) {
                        list.add(stack.pop());
                    }
                    list.add(stack.pop());
                    String result = solution(list); // jisuan
                    if (result.startsWith("error")) {
                        System.out.println("error");
                        return;
                    }
                    stack.push(result);
                }
            }
            System.out.println(stack.pop());
        }
    }

    private static String solution(List<String> lisps) {
        System.out.println(lisps);
        int a = Integer.parseInt(lisps.get(1));
        String lispB = lisps.get(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lispB.length(); i ++) {
            sb.append(lispB.charAt(i));
            if (lispB.charAt(i) == ')') {
                break;
            }
        }
        int b = Integer.parseInt(sb.substring(0, sb.length() -1));
        int result = 0;
        if ("(mul".equals(lisps.get(2))) {
            result = a * b;
        }
        if ("(add".equals(lisps.get(2))) {
            result = a + b;
        }
        if ("(dev".equals(lisps.get(2))) {
            if (b == 0) {
                return "error";
            }
            result = a / b;
        }
        if ("(sub".equals(lisps.get(2))) {
            result = a - b;
        }
        String keepString = lispB.replace(sb.toString(), "");
        return result + keepString;
    }
}
