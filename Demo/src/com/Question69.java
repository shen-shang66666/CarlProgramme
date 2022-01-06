package com;

import java.util.Arrays;

public class Question69 {
    //二分法
//    public static int mySqrt(int x) {
//        if(x == 0) return 0;
//        if(x == 1) return 1;
//        int left = 0;
//        int right = x;
//        while(left < right){
//            int middle = left + ((right - left) >> 1);
//            if (x / middle == middle){
//                return middle;
//            }
//            if(x / middle < middle){
//                right = middle;
//                if(x / (middle - 1) >= (middle - 1)){
//                    return (middle - 1);
//                }
//            }
//            if(x / middle > middle){
//                left = middle + 1;
//                if(x / left < left){
//                    return left - 1;
//                }
//                if (x / left == left){
//                    return left;
//                }
//            }
//        }
//        return (left );
//    }

    // 改进二分法
    public static int mySqrt(int x) {
        // 特殊值判断
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1;
        int right = x / 2;
        // 在区间 [left..right] 查找目标元素
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 注意：这里为了避免乘法溢出，改用除法
            if (mid < x / mid) {
                // 下一轮搜索区间是 [left..mid - 1]
                left = mid + 1;
                if(x / left < left){
                    return (left - 1);
                }
            }
            else if(mid == x/mid){
                return mid;
            }
            else {
                // 下一轮搜索区间是 [mid..right]
                right = mid;

            }
        }
        return left;
    }

//    // 牛顿法
//    public int mySqrt(int x) {
//        // 一切都要转换成double来进行计算，x0和x1没有转换成double，可能出现x0和x1的差的绝对值一直为1的情况
//        // x不为0，则在x=1的时候，会因为int除法精度不够，导致x0=1/2=0，从而越界
//        double x0 = ((double)x) / 2;
//        double x1 = x0 / 2 + x / (x0 * 2);
//        // while((x0 - x1) > 1 || (x1 - x0) > 1){
//        while( Math.abs(x0 - x1) >= 1){
//            x0 = x1;
//            x1 = x0 / 2 + x / (x0 * 2);
//        }
//        return ((int)x1);
//    }

    public static void main(String[] args){
        int target = 6;
        System.out.println(mySqrt(target));
    }
}

//牛顿法
// import java.lang.Math;
//
//class Solution {
//
//}