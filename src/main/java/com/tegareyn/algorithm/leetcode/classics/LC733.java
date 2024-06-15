package com.tegareyn.algorithm.leetcode.classics;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 图像渲染
 * @Author mocheng
 * @Since 2022/11/24 13:54
 * @Version 1.0
 **/
public class LC733 {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return floodFillDfs(image, sr, sc, color);
    }

    public static int[][] floodFillDfs(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        if (target != color) {
            dfs(image, sr, sc, target, color);
        } else {
            // 若 初始像素值 的 颜色 与 目标颜色值 相同，其 相连像素值 的 颜色值 有两种情况：
            // 1.与目标颜色值相同，则无需染色
            // 2.与目标颜色值不相同，即与初试色块不相连，也无需染色
            // 所以，综上，当初始像素的颜色值与目标颜色值相同，无需染色，直接返回原图即可
        }
        return image;
    }

    // 深度优先 一个方向进行到底，再从其他方向开始到底..
    public static void dfs(int[][] image, int sr, int sc, int target, int color) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == target) {
            image[sr][sc] = color;
            dfs(image, sr, sc + 1, target, color);
            dfs(image, sr, sc - 1, target, color);
            dfs(image, sr + 1, sc, target, color);
            dfs(image, sr - 1, sc, target, color);
        }
    }

    public static int[][] floodFillBfs(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        if (target == color) {
            return image;
        }
        Queue<int []> queue = new LinkedList<>();// 存放符合条件的像素点
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            sr = index[0];
            sc = index[1];
            bfs(queue, image, sr, sc, target, color);
        }
        return image;
    }

    // 广度优先(结合队列)
    public static void bfs(Queue<int []> queue, int[][] image, int sr, int sc, int target, int color) {
        image[sr][sc] = color;
        // 放入上下左右 符合要求的像素点坐标
        fillColorPoint(queue, image, sr, sc + 1, target, color);
        fillColorPoint(queue, image, sr, sc - 1, target, color);
        fillColorPoint(queue, image, sr + 1, sc, target, color);
        fillColorPoint(queue, image, sr - 1, sc, target, color);
    }

    public static void fillColorPoint(Queue<int []> queue, int[][] image, int sr, int sc, int target, int color) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == target) {
            queue.offer(new int[]{sr, sc});
        }
    }

}
