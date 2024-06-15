package com.tegareyn.algorithm.nowcode.niuke;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class StringUtil {



    public static void test1(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            int[] recode = new int[26];//a --97
            String line = scanner.nextLine();
            char[] tmp = line.toCharArray();
            for(char t : tmp){
                recode[t-97]++;
            }
            int min = 20;
            //计算最小次数，0不算
            for(int i=0;i<recode.length;i++){
                if(recode[i] == 0) continue;
                if(recode[i]<=min) {
                    min = recode[i];
                }
            }
            //拿到出现最少次数的字符，
            List<String> list = new ArrayList<>();
            for(int i=0;i<recode.length;i++) {
                if(recode[i] == min) {
                    list.add((char)(i+97)+"");
                }
            }

            for(String s: list) {
                line = line.replaceAll(s,"");
            }
            System.out.println(line);
        }
    }

    public static void test3()throws Exception {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> m=new LinkedHashMap<String,Integer>();
        String tstr=null;
        while((tstr = cin.readLine()) != null && !tstr.equals("")){      //&& !tstr.equals(""))没有性能影响
            String[] str=tstr.split("\\s+");
            String fname=str[0].substring(str[0].lastIndexOf("\\")+1);
            fname=fname.substring(Math.max(fname.length()-16 ,0))+" "+str[1];  //max 最快推荐 ？：也可以 if太麻烦
            Integer tmp=m.get(fname);  //get==null较快写法
            if(tmp==null)
                m.put(fname,1);
            else
                m.put(fname, tmp+1);
        }
        int cnt=0;
        for(Map.Entry<String,Integer> it:m.entrySet()){
            if(m.size()-cnt<=8)
                System.out.println(it.getKey()+" "+it.getValue());
            cnt++;
        }
    }


    public static void main(String[] args)throws Exception {
        test3();
    }
}
