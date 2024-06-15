package com.tegareyn.algorithm.nowcode.niuke;

import java.util.Scanner;

public class Main002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str = scanner.nextLine().replaceAll(",", "");
            Integer sum = Integer.valueOf(scanner.nextLine());
            int length = 0;
            for(int i=0; i<str.length();i++) {
                length = Math.max(length, get(sum, str, i));
            }
            System.out.println(length);
        }
    }

    private static int get(int sum, String s, int i) {
        int tmp = 0;
        int length = 0;
        while(i>=0&& i<s.length()-1) {
            Integer integer = Integer.valueOf(s.charAt(i)+"");
            if(sum - integer >=0) {
                if (sum == integer) { //当前值与和相等  todo：优化：考虑附近的值可不再进行遍历操作
                    length = 1;
                    break;
                } else {
                    if (integer==Integer.valueOf(s.charAt(++i)+"")-1) {//连续
                        tmp += Integer.valueOf(s.charAt(i)+"");
                        length++;
                        if (tmp == sum) {
                            break;
                        } else if (tmp>sum) {
                            length = -1;
                            break;
                        }
                    } else { // 不连续
                        length = -1;
                        break;
                    }
                }
            } else {
                length = -1;
                break;
            }
        }
        return length;
    }
}
