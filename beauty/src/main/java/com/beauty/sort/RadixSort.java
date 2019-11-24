package com.beauty.sort;

/**
 * @author Huangxulin
 * @date 2019/11/22 - 18:00
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {

    }

    //基数排序方法
    public static void radixSort(int[] arr){
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组，二维数组包含10个一维数组
        //为了防止在放入数的时候，数据溢出，则每个一维数组（桶），大小定为arr.length
        //从大小这点看，很明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
    }
}
