package com.tegareyn.algorithm.nowcode.niuke;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSonSerializable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");
            int sum = Integer.valueOf(scanner.nextLine());
            List<Integer> list = new ArrayList<>(0);
            for(String s : line){
                list.add(Integer.valueOf(s));
            }
            /*
            1.找到所有连续子序列，并分别保存至独立的list；
            2.设符合要求(序列和为sum)的最长子序列的长度为maxLength = 0；
            3.遍历所有连续子序列：
                a.小于maxLength长度的子序列，则无需再遍历，
                b.找到子序列中和(包括其子序列)为sum，记录满足要求的子序列长度tempLength
                    (若tempLength>=maxLength, 则maxLength=tempLength)

             */





        }
    }




}
