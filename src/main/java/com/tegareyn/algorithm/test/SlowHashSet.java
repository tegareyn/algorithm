package com.tegareyn.algorithm.test;

import java.util.LinkedList;

/**
 * @ClassName SlowHashSet
 * @Description 请描述类的业务用途
 * @Author mocheng
 * @Since 2021/10/20 17:14
 * @Version 1.0
 **/
class Person {
    public int id;
    public String name;

    @Override
    public int hashCode() {
        return id + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("比较了");
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return this.id == p.id && this.name.equals(p.name);
        }
        return false;
    }
}

public class SlowHashSet {

    private LinkedList[] arr = new LinkedList[100];

    public void add(Object obj) {
        int hash = obj.hashCode();
        int i = hash % arr.length;

        if (arr[i] == null) {
            arr[i] = new LinkedList();
            arr[i].add(obj);
        } else {
            int j;
            for (j = 0; j < arr[i].size(); j++) {
                if (arr[i].get(j).equals(obj)) {
                    break;
                }
            }

            if (j == arr[i].size()) {
                arr[i].add(obj);
            }

        }

    }

    // �Լ�����remove(Object obj);
    // �Լ�����contains(Object obj);

    public int size() {
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                size += arr[i].size();
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.id = 2;
        p.name = "a";
        Person p2 = new Person();
        p2.id = 1;
        p2.name = "b";

        System.out.println(p.hashCode());
        System.out.println(p2.hashCode());

        SlowHashSet set = new SlowHashSet();
        set.add(p);
        set.add(p2);

        System.out.println(set.size());

    }

}
