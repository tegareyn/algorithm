package com.tegareyn.algorithm.facecode;

/**
 * 描述：货币转换
 * 100CNY=1825JPY=123HKD=14EUR=12GBP,
 * 1CNY=100fen, 1HKD=100cents, 1JPY=100sen, 1EUR=100eurocents, 1GBP=100pence
 * 将给定的带单位金额转换为 fen 汇总后输出，结果只保留整数，小数舍弃
 * @author mocheng
 * @version 1.0
 * @see Currencies
 * @since 2024/2/28 15:59
 **/
public class Currencies {

    public static void main(String[] args) {
        Currencies currencies = new Currencies();
        String[] s = new String[]{"53HKD87cents", "1CNY", "20CNY53fen", "12GBP", "100pence"};
        double sum = 0d;
        for (String ss : s) {
            sum += currencies.currencies(0.0d, ss);
        }
        System.out.println(new Double(sum).intValue());
    }

    public double currencies(double sum, String money) {
        char pre = 'A';
        StringBuilder num = new StringBuilder("0");
        StringBuilder unit = new StringBuilder();
        for (char c : money.toCharArray()) {
            if (Character.isDigit(c) && !Character.isDigit(pre)) {
                // transfer
                sum += transfer(Double.parseDouble(num.toString()), unit);
                num = new StringBuilder();
                unit = new StringBuilder();
            }
            // divide
            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                unit.append(c);
            }
            pre = c;
        }
        sum += transfer(Double.parseDouble(num.toString()), unit);
        return sum;
    }

    // * 100CNY=1825JPY=123HKD=14EUR=12GBP,
    // * 1CNY=100fen, 1HKD=100cents, 1JPY=100sen, 1EUR=100eurocents, 1GBP=100pence
    private double transfer(double num, StringBuilder unit) {
        double sum = 0.0d;
        switch (unit.toString()) {
            case "CNY":
                sum = transfer(num * 100d, new StringBuilder("fen"));
                break;
            case "JPY":
                sum = transfer(100d / 1825d * num, new StringBuilder("CNY"));
                break;
            case "HKD":
                sum = transfer(100d / 123d * num, new StringBuilder("CNY"));
                break;
            case "EUR":
                sum = transfer(100d / 14d * num, new StringBuilder("CNY"));
                break;
            case "GBP":
                sum = transfer(100d / 12d * num, new StringBuilder("CNY"));
                break;
            case "fen":
                sum = num;
                break;
            case "cents":
                sum = transfer(num / 100d, new StringBuilder("HKD"));
                break;
            case "sen":
                sum = transfer(num / 100d, new StringBuilder("JPY"));
                break;
            case "eurocents":
                sum = transfer(num / 100d, new StringBuilder("EUR"));
                break;
            case "pence":
                sum = transfer(num / 100d, new StringBuilder("GBP"));
                break;
            default:

        }
        return sum;
    }


}
