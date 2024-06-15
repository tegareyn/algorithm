package com.tegareyn.algorithm.nowcode.niuke;

import java.util.*;

public class LengthTest {





    private static void wordLengthText(Scanner scanner) {
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int length = line.length() - 1 - line.lastIndexOf(' ');
            System.out.println(length);
        }
    }

    public static void charNum(Scanner scanner) {

        String line = scanner.nextLine().toLowerCase();
        String c = scanner.nextLine().toLowerCase();
        int num = line.length()-line.replaceAll(c,"").length();
        System.out.println(num);
    }

    public static void sort(Scanner scanner) {
        while(scanner.hasNext()) {
            int length = scanner.nextInt();
            Set<Integer> set = new TreeSet<>();
            for(int i = 0; i < length; i++) {
                set.add(scanner.nextInt());
            }
            Iterator iterator = set.iterator();
            while(iterator.hasNext())
                System.out.println(iterator.next());
        }
    }

    public static void split(String line) {
        int length = line.length();
        StringBuilder s = new StringBuilder(line);
        int zero = length%8;
        for(int i =0; i<8-zero; i++)
            s.append("0");
        line = s.toString();
        while(line.length()>0) {
            System.out.println(line.substring(0,8));
            line = line.substring(8);
        }
    }

    public static void tree(Scanner scanner) {
        while(scanner.hasNextInt()) {
            int initNum = Integer.valueOf(scanner.nextLine());
            Map<Integer, Integer> map = new TreeMap<>();
            for(int n = 0; n <initNum; n++) {
                String next = scanner.nextLine();
                String[] tmp = next.split(" ");
                int key = Integer.parseInt(tmp[0]);
                int value = Integer.parseInt(tmp[1]);
                map.put(key, map.containsKey(key) ? map.get(key) + value: value);
            }
            for (Integer key : map.keySet()) {
                System.out.println(key+ " " +map.get(key));
            }
        }
    }

    public static void test(Scanner scanner) {
        String num = "" +Integer.valueOf(scanner.nextInt());
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<num.length();i++){
            set.add(Integer.parseInt(num.indexOf(i)+""));
        }
        Iterator iterator = set.iterator();
        while(iterator.hasNext())
            System.out.print(iterator.next());
    }

    public static void test1(Scanner scanner) {
        Deque<String> words = new LinkedList<>();
        for (String word : scanner.nextLine().split("\\s+")) {
            words.addFirst(word);
        }
        System.out.println(String.join(" ", words));


    }

    public static void test1_0() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] arr = input.split("\\s");
        for (String str : arr) {
            stack.push(str);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb.toString());
    }

    public static void test2() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] array = new String[num];
        for (int i = 0; i <= num; i++) {
            array[i] = scanner.nextLine();
        }
        Arrays.sort(array);
        for (String str : array) {
            System.out.println(str);
        }
    }

    public static void test3() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str0 = scanner.nextLine();
            String[] tmp = str0.split(" ");
            if (tmp.length < 1) {
                System.out.print(0);
            } else {
                System.out.print(isRevertStr(tmp[0], tmp[1]));
            }

        }
    }


    public static int isRevertStr(String var0, String var1){
        int flag = 1;
        if(var0 == null && var1 == null)
            flag = 1;
        if(var0 == null || var1 == null)
            flag = 0;
        if(var0.length() != var1.length())
            flag = 0;
        else {
            char[] var2 = var0.toCharArray();
            char[] var3 = var1.toCharArray();
            for(int i = 0; i<var2.length;i++) {
                if(var2[i] != var3[var2.length - i - 1]){
                    flag = 0;
                    break;
                }
            }
        }
        return flag;
    }

    public static void test4(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println((isEnoughLong(str)&&isPerfectPwd(str)&&isRepeatStr(str))?"OK":"NG");
        }
    }

    private static boolean isEnoughLong(String var){
        return var.length()>8;
    }
    public static boolean isPerfectPwd(String var) {
        int[] flag = new int[4];//位图大法
        char[] tmp = var.toCharArray();
        for(char t: tmp){
            String tm = t + "";
            if(tm.matches("[a-z]"))
                flag[0] = 1;
            else if(tm.matches("[A-Z]"))
                flag[1] = 1;
            else if(tm.matches("\\d"))
                flag[2] = 1;
            else{
                flag[3] = 1;
            }
        }

        return flag[0] +flag[1] +flag[2] +flag[3]>=3;
    }

    private static boolean isRepeatStr(String var) {
        int kind = var.length()-3;
        Set<String> set = new LinkedHashSet<>();
        for(int i=0;i<kind;i++){
            set.add(var.substring(i,i+3));
        }
        return set.size() == (kind);
    }

    public static void test5() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String fpwd = scanner.nextLine();
            char[] tmp = fpwd.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<tmp.length;i++){
                char t =tmp[i];
                if('a'<=t && t<='z'){
                    String tm = (t+"");
                    sb.append("abc".contains(tm)? 2:
                            ("def".contains(tm)? 3:
                                    ("ghi".contains(tm)? 4:
                                            ("jkl".contains(tm)? 5:
                                                    ("mno".contains(tm)? 6:
                                                            ("pqrs".contains(tm)? 7:
                                                                    ("tuv".contains(tm)? 8:9)))))));
                }else if('A'<=t && t<='Z') {
                    String tm = (t+"").toLowerCase();
                    if(tm.equals("z")) {
                        sb.append("a");
                    } else{
                        sb.append(((char)(t+1)+"").toLowerCase());
                    }
                }else if('0'<=t && t<='9') {
                    sb.append(t);
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
//        wordLengthText(scanner);

//        charNum(scanner);

//        sort(scanner);

//        String line0 = scanner.nextLine();
//        String line2 = scanner.nextLine();
//        split(line0);
//        split(line2);
//        tree(scanner);
//        test(scanner);
//        test2();
        test5();
    }
}
