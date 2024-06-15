package com.tegareyn.algorithm.nowcode.niuke;

import java.util.Scanner;

public class Main001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            int slength = 0;
            int dlength = 0;
            String s = scanner.nextLine();
            String ds = new StringBuilder(s).reverse().toString();
            for(int i = 0; i<s.length(); i++) {
                slength = Math.max(slength, get(s, i));
            }
            for(int i = 0; i<ds.length(); i++) {
                dlength = Math.max(dlength, get(ds, i));
            }

            System.out.println(Math.max(slength, dlength));
        }
    }

    private static int get(String s, int l) {
        int length = 1;
        while(l>=0 && l<s.length()-1 && s.charAt(l)==(s.charAt(++l) -1)) {
            length++;
        }
        return length;
    }
}
