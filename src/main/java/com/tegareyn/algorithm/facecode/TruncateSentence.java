package com.tegareyn.algorithm.facecode;

/**
 * @ClassName TrancateSentence
 * @Description 语句截断
 * @Author mocheng
 * @Since 2021/12/6 12:51
 * @Version 1.0
 **/
public class TruncateSentence {

    public static void main(String[] args) {
        System.out.println(truncateSentence( "Ve RsJNCcOl yvl g iyavUURqI oEE l u mHK",7));
    }


    public static String truncateSentence(String sentence, int k) {
        if (sentence != null && sentence.length() > 0) {
            if (k > 0) {
                int count = 0;
                for (int i = 0; i < sentence.length(); i++) {
                    if (' ' == sentence.charAt(i)) {
                        if (++count > k-1) {
                            return sentence.substring(0, i);
                        }
                    }
                }
                return sentence;
            }
        }
        return "";
    }

}
