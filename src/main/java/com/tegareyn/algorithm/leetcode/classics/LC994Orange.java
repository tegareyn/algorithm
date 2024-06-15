package com.tegareyn.algorithm.leetcode.classics;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Ref LC994
 * @Description 腐烂的橘子
 * @Author Spindrift
 * @Since 2022/12/2 16:52
 * @Version 1.0
 **/
public class LC994Orange {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int minutes = 0;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i ,j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        return bfs(grid, queue, minutes, fresh);
    }

    public static int bfs(int[][] grid, Queue<int[]> queue, int minutes, int fresh) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        while (!queue.isEmpty() && fresh > 0) {
            ++minutes;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int z = 0; z < 4; z++) {
                    int mx = cell[0] + dx[z];
                    int my = cell[1] + dy[z];
                    if (mx >= 0 && mx < grid.length && my >= 0 && my < grid[0].length && grid[mx][my] == 1) {
                        grid[mx][my] = 2;
                        queue.offer(new int[]{mx, my});
                        fresh--;
                    }
                }
            }
        }
        return fresh > 0 ? -1 : minutes;
    }
}
