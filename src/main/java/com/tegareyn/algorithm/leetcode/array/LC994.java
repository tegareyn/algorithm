package com.tegareyn.algorithm.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述：腐烂的橘子
 *
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 *
 * @author mocheng
 * @version 1.0
 * @see LC994
 * @since 2024/2/2 11:58
 **/
public class LC994 {

    public static void main(String[] args) {
        int[][] oranges = new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        LC994 lt994 = new LC994();
        System.out.println(lt994.solution(oranges));
    }

    public int solution(int[][] oranges) {
        // statistic bad and fresh orange
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int y = 0; y < oranges[0].length; y++) {
            for (int x = 0; x < oranges.length; x++) {
                if (oranges[x][y] == 2) {
                    queue.add(new int[]{x, y});
                } else if(oranges[x][y] == 1) {
                    fresh++;
                }
            }
        }

        int minute = 0;
        int[] mx = new int[]{0, 0, -1, 1}; // 上下左右
        int[] my = new int[]{1, -1, 0, 0}; // 上下左右
        // being bad
        while(!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            minute++;
            for (int i = 0; i < size; i++) {
                int[] bad = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = bad[0] + mx[j];
                    int y = bad[1] + my[j];
                    if (x >=0 && x < oranges[0].length && y >=0 && y < oranges.length && oranges[x][y] == 1) {
                        oranges[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        fresh--;
                    }
                }
            }
        }
        return fresh > 0 ? -1 : minute;
    }

}
