package com.tegareyn.algorithm.leetcode.array;

import java.util.Objects;
import java.util.Queue;

/**
 * 描述：岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围
 * @author mocheng
 * @version 1.0
 * @see LC200
 * @since 2024/2/29 11:00
 **/
public class LC200 {
    public static void main(String[] args) {
        char[][] array = new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println(islandNum(array));
    }

    public static int islandNum(char[][] grid) {
        int islandNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (Objects.equals(grid[i][j], '1')) {
                    islandNum ++;
                    bfs(grid, i, j);
                }
                grid[i][j] = '0';
            }
        }
        return islandNum;
    }

    private static void bfs(char[][] gird, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] moveX = new int[]{0,0,-1,1};
            int[] moveY = new int[]{1,-1,0,0};
            int[] arr = queue.poll();
            gird[arr[0]][arr[1]] = '0';
            for (int i = 0; i < 4; i++) {
                int x = arr[0] + moveX[i];
                int y = arr[1] + moveY[i];
                if (x >= 0 && x < gird.length && y >= 0 && y < gird[0].length) {
                    if (Objects.equals(gird[x][y], '1')) {
                        queue.add(new int[]{x, y});
                        bfs(gird, queue);
                    }
                }
            }
        }
    }

    private static void bfs(char[][] gird, int l, int r) {
        int[] moveX = new int[]{0,0,-1,1};
        int[] moveY = new int[]{-1,1,0,0};
        gird[l][r] = '2';
        for (int i = 0; i < 4; i++) {
            int x = l + moveX[i];
            int y = r + moveY[i];
            if (x >= 0 && x < gird.length && y >= 0 && y < gird[0].length) {
                if (Objects.equals(gird[x][y], '1')) {
                    bfs(gird, x, y);
                } else {
                    gird[x][y] = '2';
                }
            }
        }
    }

}
