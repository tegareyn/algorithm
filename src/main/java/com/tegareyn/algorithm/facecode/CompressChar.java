package com.tegareyn.algorithm.facecode;

import java.util.Scanner;


public class CompressChar {

    /**
     * 1. 定义字符串和数字校验规则；字符串不能以数字结尾；字符串不能包含特殊字符和大写字符
     * 2. 顺序遍历字符串的字符，定义一个StringBuilder 变量result，存储解压缩字符串
     * 3. 当字符为数字时(规则：数字后面只能跟一个字符，若后面没有字符 或 有两个以上的相同字符，则证明压缩失败)
     *      取出所有连续的数字字符 和 合规的字符，将数字和对应的字符解压缩写入result
     *      并将遍历下标后移
     * 4. 当字符为小写字符时(规则：不能有两个连续相同字符串，若有则证明压缩失败)
     *      将字符存入result
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String cTarget = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < cTarget.length(); i++) {
                char c = cTarget.charAt(i);
                if (!isNum(c) && !isChar(c)) {
                    System.out.println("!error");
                    return;
                }
                if (isNum(c))  {
                    StringBuilder sNum = new StringBuilder();
                    for (int j = i; j < cTarget.length(); j++) {
                        if (isNum(cTarget.charAt(j))) {
                            sNum.append(cTarget.charAt(j));
                            i = j;
                            continue;
                        }
                        break;
                    }
                    int num = Integer.parseInt(sNum.toString());
                    if (num <= 2) {
                        System.out.println("!error");
                        return;
                    }
                    if (i + 1 >= cTarget.length()) {
                        System.out.println("!error");
                        return;
                    }

                    if (i + 2 < cTarget.length() && cTarget.charAt(i + 1) == cTarget.charAt(i + 2)) {
                        System.out.println("!error");
                        return;
                    }
                    for (int j = num; j > 1; j --) {
                        result.append(cTarget.charAt(i + 1));
                    }
                } else {
                    int num = 0;
                    for (int j = i; j < cTarget.length(); j++) {
                        if (cTarget.charAt(i) == cTarget.charAt(j)) {
                            num ++;
                        }
                    }
                    if (num > 2) {
                        System.out.println("!error");
                        return;
                    }
                    result.append(cTarget.charAt(i));
                }
            }
            System.out.println(result);
        }
    }

    private static boolean isNum(char c) {
        return c <= '9' && c >= '0';
    }

    private static boolean isChar(char c) {
        return c >= 'a' && c <= 'z';
    }

}
