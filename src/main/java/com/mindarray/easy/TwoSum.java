package com.mindarray.easy;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(calculate(new int[]{10, 9, 2, 3, 4, 8, -1}, 9)));
    }

    public static int[] calculate(int[] nums, int target) {

        var result = new int[2];

        /*The sum of all the nums in the array is going to be greater than the target
         * -1+2+3+4+10+8+9 = 35
         * -1,2,3,4,8,9 = 25
         * 10 = 10*/

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= target / 2) {

            } else {

            }
        }

        return result;
    }
}
