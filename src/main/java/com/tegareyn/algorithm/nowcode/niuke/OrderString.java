package com.tegareyn.algorithm.nowcode.niuke;

import java.util.*;

public class OrderString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            List<Character> list = new ArrayList<>();
            for (char c:chars) {
                if(Character.isLetter(c))
                    list.add(c);
            }
            Collections.sort(list, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return Character.toLowerCase(o1) - Character.toLowerCase(o2);
                }
            });
            StringBuilder sb = new StringBuilder();
            for(int i =0,j=0; i<line.length();i++) {
                if (Character.isLetter(line.charAt(i))){
                    sb.append(list.get(j++));
                } else {
                    sb.append(line.charAt(i));
                }
            }

            System.out.println(sb.toString());

        }
    }
}
