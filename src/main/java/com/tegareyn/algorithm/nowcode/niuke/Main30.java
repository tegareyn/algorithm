package com.tegareyn.algorithm.nowcode.niuke;

import java.util.*;

public class Main30 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine()+scanner.nextLine();
            List<Character> dubbo = new ArrayList<>();
            List<Character> single = new ArrayList<>();
            Map<Integer, Character> map = new LinkedHashMap<>();
            int d=0, s=0;
            for(int i=0;i<line.length();i++){
                String s1 = line.charAt(i) + "";
                if(!s1.matches("[A-Za-z0-9]+")) {
                    map.put(i, line.charAt(i));
                }else {
                    if(i%2==0) {
                        dubbo.add(line.charAt(i));
                        d++;
                    } else {
                        single.add(line.charAt(i));
                        s++;
                    }
                }
            }
            Collections.sort(dubbo);
            Collections.sort(single);
            d=0;
            s=0;
            char c = 'a';
            StringBuilder sb = new StringBuilder();
            Iterator<Integer> iterator = map.keySet().iterator();
            for(int i=0;i<line.length();i++) {
                if(contian(map,i)) {
                    sb.append(map.get(i));
                }
                if(i%2==0) {
                    d = getD(dubbo, d, sb);
                } else {
                    s = getD(single, s, sb);
                }
            }
            System.out.println(sb.toString());

        }



    }

    private static int getD(List<Character> dubbo, int d, StringBuilder sb) {
        String s1 = Integer.toBinaryString(dubbo.get(d));
        d++;
        char c1 = (char) get(s1);
        sb.append((c1+"").toUpperCase());
        return d;
    }

    //默认一切输出合法
    public static int get(String str) {
        int sum =0;
        for(int i=0;i<str.length();i++){

            if(!"0".equals(str.charAt(i)+"")) {
                double pow = Math.pow(2, i);
                sum+= pow;
            }

        }
        return sum;
    }


    public static List<Character> removeNull(char[] c) {
        List<Character> ccc = new ArrayList<>();
        for(char cc :c) {
            if ((cc+"").length()!=0) {
                ccc.add(cc);
            }
        }
        return ccc;
    }

    public static boolean contian(Map<Integer, Character> map, int i) {
        Iterator<Map.Entry<Integer, Character>> iterator = map.entrySet().iterator();
        boolean flag = false;
        while (iterator.hasNext()) {
            if(iterator.next().getKey() == i) {
                iterator.remove();
                flag = true;
            }
        }
        return flag;
    }
}
