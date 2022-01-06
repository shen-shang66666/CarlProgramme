package com;

import java.util.Arrays;

public class Question34 {
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || target > nums[nums.length - 1] || target < nums[0]){
            return new int[]{-1, -1};
        }
        int right = nums.length;
        int left = 0;
        while (left < right){
            int middle = left + ((right - left) >> 1);
            if(nums[middle] == target){
                int leftcount = middle;
                int rightcount = middle;
                while( leftcount > 0 && nums[leftcount - 1] == target){
                    // System.out.println("here0");
                    leftcount--;
                }
                while( rightcount < nums.length-1 && nums[rightcount + 1] == target ){
                    // System.out.println("here");
                    rightcount++;
                }
                return new int[]{leftcount, rightcount};
            }
            if(nums[middle] < target){
                left = middle + 1;
            }
            if(nums[middle] > target){
                right = middle;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args){
        int[] nums={1};
        int target = 1;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
