package com.tegareyn.algorithm.facecode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述：最大社交距离
 * 疫情期间需要大家保证一定的社交距离，公司组织开交流会议。
 * 座位一排共 N 个座位，编号分别为 [0, N - 1] , 要求员工一个接着一个进入会议室，并且可以在任何时候离开会议室。
 *
 * 满足：
 * 每当一个员工进入时，需要坐到最大社交距离（最大化自己和其他人的距离的座位）；
 * 如果有多个这样的座位，则坐到 索引最小 的那个座位。
 *
 * 输入描述：
 * 会议室座位总数 seatNum 。(1 <= seatNum <= 500)
 * 员工的进出顺序 seatOrLeave 数组，元素值为 1，表示进场；元素值为负数，表示出场（特殊：位置 0 的员工不会离开）。
 * 例如 - 4 表示坐在位置 4 的员工离开（保证有员工坐在该座位上）
 * 输出描述：
 * 最后进来员工，他会坐在第几个位置，如果位置已满，则输出 - 1 。
 *
 * 示例1：
 * 输入
 * 10
 * [1,1,1,1,-4,1]
 * 输出
 * 5
 *
 * 说明
 * seat -> 0 , 空在任何位置都行，但是要给他安排索引最小的位置，也就是座位 0
 * seat -> 9 , 要和旁边的人距离最远，也就是座位 9
 * seat -> 4 , 要和旁边的人距离最远，应该坐到中间，也就是座位 4
 * seat -> 2 , 员工最后坐在 2 号座位上
 * leave [4] , 4 号座位的员工离开
 * seat -> 5 , 员工最后坐在 5 号座位上
 *
 * @author mocheng
 * @version 1.0
 * @see MaxSocialDistance
 * @since 2024/3/9 17:30
 **/
public class MaxSocialDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seatNum = sc.nextInt();
        sc.nextLine();
        String seatOrLeaveLine = sc.nextLine();
        String[] c = seatOrLeaveLine.substring(1,seatOrLeaveLine.length()-1).split(",");
        int[] seatOrLeave = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            seatOrLeave[i] = Integer.parseInt(c[i]);
        }
        // 注意：seatOrLeave指令中不可能有-0，所以0位置一旦坐下，就不能再让出座位了，
        //      可以避免这种情况的下一次入座不符合贵的的问题：0,0,1,1,0,0,0,0,1
        int ans = conferenceSeatDistance(seatNum, seatOrLeave);
        System.out.println(ans);
    }

    /**
     * 暴力求解：计算最后进来的人，坐的位置
     * @param seatNum 会议室座位总数
     * @param seatOrLeave 员工的进出顺序
     * @return 最后进来的人，坐的位置
     */
    public static int conferenceSeatDistance(int seatNum, int[] seatOrLeave) {
        int[] seat = new int[seatNum];
        Arrays.fill(seat, 0);
        int seatNO = -1;
        for (int order : seatOrLeave) {
            if (order < 0) {
                seat[-order] = 0;
                seatNO = order;
            } else {
                // 寻找符合规则的最大连续空位
                int[] maxLastZeroSeri = null;
                for (int i = 0; i < seat.length; i++) {
                    if (seat[i] == 0) {
                        int left = i, right = left; // 快慢指针寻找连续空位的左右指针
                        while(i < seat.length - 1 && seat[++i] != 1) {
                            right++;
                        }
                        if (maxLastZeroSeri == null) {
                            maxLastZeroSeri = new int[2];
                            maxLastZeroSeri[0] = left;
                            maxLastZeroSeri[1] = right;
                            continue;
                        }
                        int distance = right - left;
                        // 如果右指针为 seatNum - 1，距离乘2。因为这段空位入座的坐标只能是 seatNum - 1，所以距离*2，方便对比
                        if (left == 0 || right == seatNum - 1) {
                            distance *= 2;
                        }
                        // 注意：连续空座位数量是偶数时，且比之前max的连续空座位数只多一个，则不更新max
                        if (distance/2 > (maxLastZeroSeri[1] - maxLastZeroSeri[0])/2) {
                            maxLastZeroSeri[0] = left;
                            maxLastZeroSeri[1] = right;
                        }
                    }
                }
                // 根据最大连续空位左右指针，寻找入座编号，maxLastZeroSeri值情况分析：
                // 若为null 则坐满了，反回 -1
                // 若不为null，说明还有空位
                //    优先判断左右指针， 若左指针为0，返回0；若右指针为seat.length - 1，则返回seat.length - 1
                //    否则，返回中间位置： left + (eight - left)/2
                if (maxLastZeroSeri != null) {
                    if (maxLastZeroSeri[0] == 0) {
                        seatNO = 0;
                    } else if (maxLastZeroSeri[1] == seat.length - 1) {
                        seatNO = seat.length - 1;
                    } else {
                        seatNO = maxLastZeroSeri[0] + (maxLastZeroSeri[1] - maxLastZeroSeri[0]) / 2;
                    }
                    seat[seatNO] = 1;
                } else {
                    seatNO = -1;
                }
            }
            System.out.println("seat: " + Arrays.toString(seat) + ", order: " + order + ", seatNO: " + seatNO);
        }
        return seatNO;
    }

}
