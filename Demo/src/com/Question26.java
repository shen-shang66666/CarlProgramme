package com;

import java.util.Arrays;

public class Question26 {
    public static int[] removeDuplicates(int[] nums) {
        int l = nums.length;
        int i;
        int slowIndex = 0;
        for(i = 0; i < l; i++){
            int fastIndex;
            slowIndex = 0;
            int flag = 0;
            for(fastIndex = 0; fastIndex < l; fastIndex++){
                if(nums[i] != nums[fastIndex]){
                    nums[slowIndex++] = nums[fastIndex];
                }
                else if(flag == 0){
                    flag = 1;
                    nums[slowIndex++] = nums[fastIndex];
                }
            }
            l = slowIndex;
        }
        System.out.println(slowIndex);
        return nums;
    }

    public static void main(String[] args){
        int[] nums={1, 1, 2};
        System.out.println(Arrays.toString(removeDuplicates(nums)));
    }
}
