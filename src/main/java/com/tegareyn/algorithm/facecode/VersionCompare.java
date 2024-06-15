package com.tegareyn.algorithm.facecode;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Mian0726
 * @Description 请描述类的业务用途
 * @Author mocheng
 * @Since 2022/7/26 19:21
 * @Version 1.0
 **/
public class VersionCompare {

    /**
     * 比较版本号
     * 给你两个版本号 version1 和 version2 ，请你比较它们。
     *
     * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。
     * 每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
     *
     * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。
     * 也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。
     * 例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
     *
     * 返回规则如下：
     *
     * 如果 version1 > version2 返回 1，
     * 如果 version1 < version2 返回 -1，
     * 除此之外返回 0。
     *
     * 示例：
     *
     * 假设输入内容如下：
     * version1 = "1.01", version2 = "1.001"
     * version1 = "1.0", version2 = "1.0.0"
     * version1 = "0.1", version2 = "1.1"
     * version1 = "1.1.998", version2 = "1.1.223"
     */


    public static void main(String[] args) {
        String v2 = "1.1.0.0.0.1";
        String v1 = "1.1";

        System.out.println(solution(v1, v2));
    }

    private static int solution(String v1, String v2) {
        List<String> version1 = Arrays.asList(v1.split("\\."));
        List<String> version2 = Arrays.asList(v2.split("\\."));
        int minLength = Math.min(version2.size(), version1.size());
        int change = version1.size() <= version2.size() ? 1 : -1; // flag false, v2在前
        int compare = 0;
        for (int i = 0; i < minLength; i++) {
            int i1 = Integer.parseInt(version1.get(i));
            int i2 = Integer.parseInt(version2.get(i));
            compare = Integer.compare(i1, i2);
            if (compare != 0) {
                return compare  * change;
            }
        }
        if (version1.size() != version2.size()) {
            List<String> max = version2.size() > version1.size() ? version2 : version1;
            int tmp = 0;
            for (int i = minLength; i < max.size(); i++) {
                tmp += Integer.parseInt(max.get(i));
            }
            if (tmp == 0) {
                return 0;
            }
            return tmp > 0 ? 1 : -1  * change;
        }
        return compare;
    }



    private static int compare(int i1, int i2) {
        return Integer.compare(i1, i2);
    }

    private static boolean isNull(String str) {
        return str != null && str.length() >0;
    }
}
