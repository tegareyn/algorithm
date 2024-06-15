package com.tegareyn.algorithm.nowcode.niuke;

import java.util.Scanner;

public class IPTest{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] recode = new int[7];
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] address = line.split("~");
            String[] ip = address[0].split("\\.");
            String[] dns = address[1].split("\\.");
            //私有ip
            checkPrivateIp(recode, ip);
            //ip校验
            checkPublicIp(recode, ip);
            //掩码校验
            checkDnsCode(recode, dns);

        }
        printRecode(recode);
    }

    private static void checkPrivateIp(int[] recode, String[] ip) {
        int ip0 =Integer.parseInt(ip[0]);
        int ip1 =Integer.parseInt(ip[1]);
        //私有ip
        if(ip0 == 10 || (ip0==172 && ip1>=16 && ip1<=31) || (ip0==192 && ip1==168)) {
            recode[6]++;
        }
    }

    private static void checkPublicIp(int[] recode, String[] ip) {
        if (!ip[0].startsWith("0")&&!ip[0].startsWith("127")) {
            int ip0 =Integer.parseInt(ip[0]);

            //A类
            if(1<=ip0 && ip0<=126) {
                recode[0]++;
            }
            //B类
            else if (ip0>=128 && ip0<=191){
                recode[1]++;
            }
            //C类
            else if (ip0>=192 && ip0<=223){
                recode[2]++;
            }
            //D类
            else if (ip0>=224 && ip0<=239){
                recode[3]++;
            }
            //E类
            else if (ip0>=240 && ip0<=255){
                recode[4]++;
            } else{
                recode[5]++;
            }
        }
    }

    public static void checkDnsCode(int[] recode, String[] dns){
        for(String d: dns){
            String n = Integer.toBinaryString(Integer.parseInt(d));
            int index = n.lastIndexOf("1");
            if(n.length()<8 || (index == 7||index<0 ||n.substring(0,index).contains("0"))){
                recode[5]++;
                break;
            }
        }
    }

    private static void printRecode(int[] var) {
        for(int var0:var){
            System.out.print(var0+" ");
        }
        System.out.println();
    }
}