package com.beauty.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Huangxulin
 * @date 2019/11/21 - 17:34
 * 快速排序，时间复杂度非常的低
 */
public class QuickSort {

    public static void main(String[] args) {
        //int[] arr = {-9,78,0,23,-576,70,23,-6,888};
        int[] arr = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            arr[i] = (int) (Math.random() * 900000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date1);
        System.out.println(format1);

        quickSort(arr, 0, arr.length - 1);

        Date date2 = new Date();
        String format2 = simpleDateFormat.format(date2);
        System.out.println(format2);
        // System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left; //设置最左侧下标
        int r = right; //设置最右侧下标
        int pivot = arr[(left + right) / 2]; //设置中轴值
        //System.out.println("pivot="+pivot);
        int temp = 0; //临时的变量，作为交换时的作用
        //while循环的目的是让比pivot值小的放到左边，比pivot值大的放到右边
        while (l < r) {
            //在pivot的左边一直找，找到大于等于pivot的值，才退出
            while (arr[l] < pivot) {
                l++;
            }
            //在pivot的右边一直找，找到小于等于pivot的值，才退出
            while (arr[r] > pivot) {
                r--;
            }
            //如果l >= r,则说明pivot左右两边的值，已经按照左边的数都小于pivot值
            //右边的数都大于pivot值
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现arr[l] == pivot，则r--
            if (arr[l] == pivot) {
                r--;
            }
            //如果交换完后，发现arr[r] == pivot,则l++
            if (arr[r] == pivot) {
                l++;
            }
        }
        //如果 l == r,必须l++，r--，否则会出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
