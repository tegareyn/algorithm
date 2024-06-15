package com.tegareyn.algorithm.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述：岛屿的最大面积
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * @author mocheng
 * @version 1.0
 * @see LC695
 * @since 2024/2/3 13:27
 **/
public class LC695 {

    public static void main(String[] args) {
        int[][] grid = new int[][]
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
        System.out.println(new LC695().maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int area = grid.length * grid[0].length;
        int max = 0;
        for (int x = 0; x < grid.length && max < area; x++) {
            for (int y= 0; y < grid[0].length && max < area; y++) {
                if (grid[x][y] == 1) {
                    max = Math.max(max, dfs(grid, x, y));
                }
                area--;
            }
        }
        return max;
    }

    private int bfs(int[][] grid, int x, int y) {
        int island = 0;
        grid[x][y] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int[] mx = {0, 0, -1, 1};
        int[] my = {1, -1, 0, 0};
        while(!queue.isEmpty()) {
            int size = queue.size();
            island += size;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int dx = cell[0] + mx[j];
                    int dy = cell[1] + my[j];
                    if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[dx][dy] == 1) {
                        grid[dx][dy] = -1;
                        queue.offer(new int[]{dx, dy});
                    }
                }
            }
        }
        return island;
    }

    public int dfs(int[][] grid, int x, int y) {
        int island = 1;
        grid[x][y] = 0;
        int[] mx = {0, 0, -1, 1};
        int[] my = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int dx = x + mx[i];
            int dy = y + my[i];
            if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[dx][dy] == 1) {
                island += dfs(grid, dx, dy);
            }
        }
        return island;
    }
}
