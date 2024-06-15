package com.tegareyn.algorithm.leetcode.point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Ref 三数之和
 * @Description
 * @Author Spindrift
 * @Since 2023/8/2 09:19
 * @Version 1.0
 **/
public class LC15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(fourSum(nums, 0));
    }

    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int x = 0; x < nums.length - 2; x++) {
            if (x > 0 && nums[x] == nums[x-1]) continue;
            for (int y = x+1; y < nums.length - 1; y++) {
                if (y>x+1 && nums[y] == nums[y-1]) continue;
                for (int z = y+1; z < nums.length; z++) {
                    if (z>y+1 && nums[z] == nums[z-1]) continue;
                    if (nums[x]+nums[y]+nums[z] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[x]);
                        temp.add(nums[y]);
                        temp.add(nums[z]);
                        result.add(temp);
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> solution1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        for (int x = 0; x < length - 2; x++) {
            if (x > 0 && nums[x] == nums[x - 1]) {
                continue;
            }
            for (int y = x + 1; y < length - 1; y++) {
                if (y > x + 1 && nums[y] == nums[y - 1]){
                    continue;
                }
                int z = length - 1;
                while (z > y && nums[x] + nums[y] + nums[z] > target) {
                    z--;
                }
                if (y >= z) {
                    break;
                }
                if (nums[x] + nums[y] + nums[z] == target) {
                    result.add(Arrays.asList(nums[x], nums[y], nums[z]));
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> solution2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int w = 0; w < nums.length - 3; w++) {
            if (w > 0 && nums[w] == nums[w - 1]) {
                continue;
            }
            for (int x = w + 1; x < nums.length - 2; x++) {
                if (x > w + 1 && nums[x] == nums[x - 1]) continue;
                int sum = nums[w] + nums[x];
                int y = x+1, z = nums.length - 1;
                while (y < z) {
                   if (sum + nums[y] + nums[z] > target) {
                       while(z < nums.length - 1 && nums[z] == nums[z + 1]) {
                           z--;
                       }
                       z--;
                   } else if (sum + nums[y] + nums[z] < target) {
                       while (y < z && nums[y] == nums[y -1]) {
                           y++;
                       }
                       y++;
                   } else {
                       List<Integer> temp = new ArrayList<>();
                       temp.add(nums[w]);
                       temp.add(nums[x]);
                       temp.add(nums[y]);
                       temp.add(nums[z]);
                       result.add(temp);
                       break;
                   }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}
