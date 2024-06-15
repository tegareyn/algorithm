package com.tegareyn.algorithm.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @see ListTest
 * @since 2024/1/15 09:13
 **/
public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Iterator<String> iterator = list.iterator();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        for (String s : list) {
            System.out.println(s);
            list.add(1, "e");
        }
        list.clear();

        LinkedList<Integer> queue = new LinkedList<>();

    }
}
