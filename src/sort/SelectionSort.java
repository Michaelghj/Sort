/**
 * Copyright (C), 2019-2019,
 * FileName: SelectionSort
 * Author:   Administrator
 * Date:     2019/4/12 9:22
 * Description: 选择排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ghj.sort;

/**
 * 选择排序
 * 1.从数组中找出最小（大）的元素放在数组的起始位置进行排序；
 * 2.从剩余元素中找出最小（大）的放在数组的第二个位置；
 * 3.重复执行以上操作直到只剩下一个元素；
 * 最好时间复杂度：O(n*n);
 * 最坏时间复杂度：O(n*n);
 * 时间复杂度：O(n*n);
 * 空间复杂度：O(1);
 * 稳定性：不稳定；
 */
public class SelectionSort {
    public static void selectionSort(int[] arr){
        //如果数组是空，或者数组只有一个元素不用排序直接返回；
        if(arr == null || arr.length < 2){
            return;
        }else{
            //遍历数组，找到最小的一个值
            for(int i = 0;i < arr.length-1;i++){
                //最小值的下标为i
                int minIndex = i;
                //从i+1位置开始继续查找数组的次最小值
                for(int j = i+1;j < arr.length-1;j++){
                    //如果j位置上的数比i+1位置上的数小就返回j,否则i+1位置上的数是最小的
                    minIndex = arr[j] < arr[minIndex] ? j :minIndex;
                }
                swap(arr,i,minIndex);
            }
        }
    }
    //交换方法，交换方法，i和j交换
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
