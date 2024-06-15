package com.tegareyn.algorithm.nowcode.niuke;

import java.util.Scanner;

public class Main32 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            int length = 0;
            String s = scanner.nextLine();
            for(int i = 0; i<s.length(); i++) {
                length = Math.max(length, get(s, i,i+1));
                length = Math.max(length, get(s, i, i));
            }
            System.out.println(length);
        }


    }

    private static int get(String s, int l, int r) {
        while(l>=0 && r<s.length()&& s.charAt(l)==s.charAt(r)) {
            l--;
            r++;
        }
        return r-l-1;
    }


}
