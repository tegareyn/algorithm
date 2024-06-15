package com.tegareyn.algorithm.nowcode.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumWindow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            int num = Integer.valueOf(scanner.nextLine());
            String[] tmp = scanner.nextLine().split(" ");
            int win = Integer.valueOf(scanner.nextLine());
            List<Integer> list = new ArrayList<>();
            for (String t : tmp) {
                list.add(Integer.valueOf(t));
            }
            int max = 0;
            for(int i=0;i< num-win+1;i++){
                max = Math.max(max, list.get(i) + list.get(i+1) + list.get(i+2));
            }
            System.out.println(max);
        }
    }
}
