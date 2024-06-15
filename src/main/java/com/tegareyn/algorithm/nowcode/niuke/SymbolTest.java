package com.tegareyn.algorithm.nowcode.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SymbolTest {
    public static void main(String[] a) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] tmp = line.split(";");
            List<String> symbol = new ArrayList<>();
            for(String t: tmp){
                if (t.matches("(\\W|\\w)\\d+")){
                    symbol.add(t);
                }
            }
            int x = 0;
            int y = 0;
            for(String s: symbol) {
                if(s.startsWith("A")|| s.startsWith("a")) {
                    x -= Integer.parseInt(s.substring(1));
                } else if(s.startsWith("D")|| s.startsWith("d")) {
                    x += Integer.parseInt(s.substring(1));
                } else if(s.startsWith("W")|| s.startsWith("w")) {
                    y += Integer.parseInt(s.substring(1));
                } else if(s.startsWith("S")|| s.startsWith("s")) {
                    y -= Integer.parseInt(s.substring(1));
                }
            }
            System.out.println(x+","+y);
        }
    }

}
