package com.tegareyn.algorithm.leetcode.classics;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName LT695Island
 * @Description 岛屿的最大面积
 * @Author mocheng
 * @Since 2022/11/26 15:48
 * @Version 1.0
 **/
public class LC695Island {
    public static int[][] grid = new int[][]
            {
                    {0,0,1,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,1,1,1,0,0,0},
                    {0,1,1,0,1,0,0,0,0,0,0,0,0},
                    {0,1,0,0,1,1,0,0,1,0,1,0,0},
                    {0,1,0,0,1,1,0,0,1,1,1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,1,0,0},
                    {0,0,0,0,0,0,0,1,1,1,0,0,0},
                    {0,0,0,0,0,0,0,1,1,0,0,0,0}
            };
    public static void main(String[] args) {

        System.out.println(maxAreaOfIsland(grid));
    }


    public static int maxAreaOfIsland(int[][] grid) {
        // 先按顺序找到第一个岛屿坐标，作为临时变量记录下来，以备下次继续顺序查找
        // 1。当找到岛屿时，开始使用算法计算其最大面积，计算过的岛屿置为水
        // 2。计算面积结束后，再继续顺序查找岛屿，当查找到岛屿时，重复1。2动作，直到遍历完整个数组

        // bfs
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = findIslandArea(grid, new int[]{i, j}, max);
                }
            }
        }
        return max;
    }

    public static int findIslandArea(int[][] grid, int[] island, int max) {
        Queue<int[]> queue = new LinkedList<>();
        int area = 0;
        queue.offer(island);
        while (!queue.isEmpty()){
            area += bfs(queue, grid, queue.poll());
        }
        return Math.max(max, area);
    }

    public static int bfs(Queue<int[]> queue, int[][] grid, int[] index) {
        int x = index[0]; int y = index[1];
        int count = 0;
        if (grid[x][y] == 1) {
            count++;
            offerIsland(queue, grid, x + 1, y);
            offerIsland(queue, grid, x - 1, y);
            offerIsland(queue, grid, x, y + 1);
            offerIsland(queue, grid, x, y - 1);
            grid[x][y] = 0;
        }
        return count;
    }

    public static void offerIsland(Queue<int[]> queue, int[][] grid, int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
            queue.offer(new int[] {x, y});
        }
    }

//    public static String findIsLand(int[][] grid, String index) {
//        String[] split = index.split(",");
//        int x = Integer.parseInt(split[0]); int y = Integer.parseInt(split[1]);
//        for (int i = x; i < grid.length; i++) {
//            for (int j = i > x ? 0 : y; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    return i+","+j;
//                }
//            }
//        }
//        return "";
//    }






}
