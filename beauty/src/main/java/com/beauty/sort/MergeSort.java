package com.beauty.sort;

import java.util.Arrays;

/**
 * @author Huangxulin
 * @date 2019/11/22 - 11:04
 * 归并排序 时间复杂度为线性O(n)
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    //分 + 合
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间的索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * @param arr   排序的原有数组
     * @param left  最左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 最右边索引
     * @param temp  做中转的数组，长度和arr数组一样
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //初始化i，左边有序序列的初始索引
        int j = mid + 1; //初始化j，右边有序序列的初始化索引
        int t = 0; //指向temp数组的当前索引

        //先把左右两边有序的数据按照规则填充到temp数组
        //直到左右两边有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                ++i;
                ++t;
            } else {
                temp[t] = arr[j];
                ++t;
                ++j;
            }
        }
        //把有剩余的数据一边，所有的数据一次加到temp中
        while (i <= mid) {
            temp[t] = arr[i];
            ++i;
            ++t;
        }
        while (j <= right) {
            temp[t] = arr[j];
            ++j;
            ++t;
        }
        //将temp数组拷贝到arr，特别注意，并不是每次都要拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            ++t;
            ++tempLeft;
        }
    }
}
