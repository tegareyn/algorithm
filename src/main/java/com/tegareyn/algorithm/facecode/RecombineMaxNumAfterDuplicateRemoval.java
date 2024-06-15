package com.tegareyn.algorithm.facecode;

import java.math.BigInteger;
import java.util.*;

/**
 * @ClassName Test
 * @Description 给定一个数字， 消除重复数字，再组成一个最大数字;要考虑超大正数...
 * @Author mocheng
 * @Since 2021/10/20 17:13
 * @Version 1.0
 **/
public class RecombineMaxNumAfterDuplicateRemoval {

    public static void main(String[] args) {

        // 为了解决超大整数，使用BigInteger
        BigInteger i = new BigInteger("43132214325393085324678293060422346");

        // 去除重复数字
        String str = i.toString();
        String[] strs = str.split("");
        Arrays.asList(strs);
        Set<String> set = new TreeSet<>(Arrays.asList(strs));

        // 降序排序
        List<String> list = new ArrayList(set);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        Long result = Long.parseLong(list.toString().replaceAll("\\D", ""));
        System.out.println(result);

    }
}