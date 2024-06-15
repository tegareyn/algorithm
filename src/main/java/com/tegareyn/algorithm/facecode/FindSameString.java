package com.tegareyn.algorithm.facecode;

/**
 * 描述：寻找相同子串
 * 给你两个字符串t和p,要求从1中找到一个和p相同的连续子串,并输出该字串第一个字符的下标。
 * 下标从1开始。如果不能则输出"No" ;如果含有多个这样的子串,则输出第一个字符下标最小的
 *
 * @author mocheng
 * @version 1.0
 * @see FindSameString
 * @since 2024/1/24 10:17
 **/
public class FindSameString {

    public static void main(String[] args) {
        String line = "abcdefg";
        String aim = "cfde";
        System.out.println(solution(line, aim));
    }

    public static String solution(String line, String aim) {
        if (line == null || aim == null || line.length() < aim.length()) {
            return "No";
        }
        char[] origin = line.toCharArray();
        char[] target = aim.toCharArray();
        for (int i = 0; i < origin.length; i++) {
            if (origin[i] != target[0]) {
                continue;
            } else if ((i + target.length) < target.length){
                return "No";
            }
            String result = resolve(origin, i, target);
            if (!"No".equals(result)) {
                return result;
            }
        }
        return "No";
    }
    public static String resolve(char[] origin, int start, char[] target) {
        for (char c : target) {
            if (c != origin[start++]) {
                return "No";
            }
        }
        return (start - target.length + 1) + "";
    }

}
