package com;

public class Question209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minlength = 0;
        int add = 0;
        for(int i = 0; i < nums.length; i++){
            add += nums[i];
            if(add >= target){
                right = i;
                minlength = i+1;
                break;
            }
        }
        if(add < target){
            return 0;
        }
        for(left += 1; left < nums.length; left++){
            add -= nums[left - 1];
            for(; right < nums.length - 1; right++){
                if(add >= target){
                    break;
                }
                else{
                    add += nums[right + 1];
                }
            }
            if (right - left + 1 < minlength && add >= target){
                minlength = right - left + 1;
            }
        }
        return minlength;
    }

    public static void main(String[] args){
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums) );
    }
}
