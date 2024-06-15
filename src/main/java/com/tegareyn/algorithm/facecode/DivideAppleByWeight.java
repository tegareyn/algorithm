package com.tegareyn.algorithm.facecode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class DivideAppleByWeight {

    /**
     * 粉苹果
     * 1. 根据重量排序
     * @param args
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Integer> weightNum = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt).sorted().collect(Collectors.toList());
            int size = 0;
            for (int a = 0; a < n; a++) {
                int b = n - a;
                String aBinaryString = Integer.toBinaryString(a);
                String bBinaryString = Integer.toBinaryString(b);

                int aSize = 0;
                int bSize = 0;

                for (int i = 0; i < aBinaryString.length(); i ++) {
                    if (aBinaryString.charAt(i) == '1') {
                        aSize ++;
                    }
                    if (bBinaryString.charAt(i) == '1') {
                        bSize ++;
                    }
                }

                if (aSize == bSize) {
                    size = a;
                    break;
                }
            }
            int weight = 0;
            if (size > 0) {
                for (int i = size; i < n; i++) {
                    weight += weightNum.get(i);
                }
                System.out.println(weight);
                continue;
            }
            System.out.println(-1);
        }
    }

}
