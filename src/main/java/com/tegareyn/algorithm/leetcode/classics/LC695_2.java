package com.tegareyn.algorithm.leetcode.classics;

import static com.tegareyn.algorithm.leetcode.classics.LC695Island.grid;

/**
 * @ClassName Main13
 * @Description 岛屿面积(优化版)
 * @Author mocheng
 * @Since 2022/11/26 18:30
 * @Version 1.0
 **/
public class LC695_2 {


    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int x = 0; x < grid.length; x ++) {
            for (int y = 0; y < grid[0].length; y ++) {
                if (grid[x][y] == 1) {// 找到岛屿
                    max = Math.max(dfs(grid, x, y), max);
                }
            }
        }
        return max;
    }

    private static int dfs(int[][] grid, int x, int y) {
        int count = 0;
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
            count++;
            grid[x][y] = 0;
            count += dfs(grid, x+1, y);
            count += dfs(grid, x-1, y);
            count += dfs(grid, x, y+1);
            count += dfs(grid, x, y-1);
        }
        return count;
    }


}
