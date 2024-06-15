package com.tegareyn.algorithm.leetcode.classics;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Ref LC542
 * @Description 矩阵：单元格 距离
 * @Author Spindrift
 * @Since 2022/12/1 15:04
 * @Version 1.0
 **/
public class LC542 {

    public static void main(String[] args) {
        int[][] mat = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
        updateMatrix(mat);
    }

    // bfs
    public static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i ++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    mat[i][j] = -1;
                }
                queue.offer(new int[]{i, j});
            }
        }
        bfs(queue, mat);
        return mat;
    }

    public static void bfs(Queue<int[]> queue, int[][] mat) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int z = 0; z < 4; z++) {
                int mx = cell[0] + dx[z], my = dy[z] + cell[1];
                if (mx >= 0 && mx < mat.length && my >= 0 && my < mat[0].length && mat[mx][my] == -1) {
                    mat[mx][my] = mat[cell[0]][cell[1]] + 1;
                    // fifo队列
                    queue.offer(new int[]{mx, my});
                }
            }
        }
    }


    //  超时解法！！
    public static int[][] updateMatrix1(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i ++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    continue;
                }
                LinkedList<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i, j});
                bfs1(queue, mat, res, i, j, 0);
            }
        }
        return res;
    }

    public static void bfs1(LinkedList<int[]> queue, int[][] mat, int[][] res, int x, int y, int instance) {
        instance++;
        LinkedList<int[]> next = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int z = 0; z < 4; z++) {
                int mx = cell[0] + dx[z], my = dy[z] + cell[1];
                if (mx >= 0 && mx < mat.length && my >= 0 && my < mat[0].length) {
                    if (mat[mx][my] == 0) {
                        res[x][y] = instance;
                        return;
                    }
                    next.offer(new int[]{mx, my});
                }
            }
        }
        bfs1(next, mat, res, x, y, instance);
    }
}
