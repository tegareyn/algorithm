package com.tegareyn.algorithm.utils;

import com.tegareyn.algorithm.model.ListNode;

import java.util.Arrays;

/**
 * @Ref 注:如果是算法训练,请保留该注解并备注所属算法网站及题目序号.如：LCxx或NCxx
 * @Description 业务用途描述
 * @Author Spindrift
 * @Since 2022/12/20 22:20
 * @Version 1.0
 **/
public class StringUtil {

    /**
     *  数字字符串转数组
     *
     * @param line eg: [x,x,x,...]
     * @return 转换后的数字数组
     */
    public static int[] string2IntArray(String line) {
        String substring = line.substring(1, line.length() - 1);
        String[] split = substring.split(",");
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i].trim());
        }
        return result;
    }

    public static ListNode string2ListNode(String line) {
        String[] split = line.split(",");
        ListNode ans = new ListNode();
        ListNode node = new ListNode(Integer.parseInt(split[0].trim()));
        ans.next = node;
        for (int i = 1; i < split.length; i++) {
            node.next = new ListNode(Integer.parseInt(split[i].trim()));
            node = node.next;
        }
        return ans.next;
    }

    /**
     * 判断字符串是否为回文串
     *
     * @param sentence 原始串
     * @return 是否为回文串
     */
    public static boolean isPalindrome(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            // 注意这里屏蔽了空串 ""
            return false;
        }
        for (int i = 0, j = sentence.length() -1; i < sentence.length() / 2; i++, j--) {
            if (sentence.charAt(i) != sentence.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 根据方法层级打印空串前缀。一般用于递归调用时，观察代码的调用流程
     *
     * @param level 递归层级
     * @return 打印空串
     */
    public static String tabByLevel(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(string2IntArray("[-4,-1,0,3,10]")));
    }
}
