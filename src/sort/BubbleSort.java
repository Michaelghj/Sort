/**
 * Copyright (C), 2019-2019,
 * FileName: BubbleSort
 * Author:   Administrator
 * Date:     2019/4/12 8:50
 * Description: 冒泡排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ghj.sort;

/**
 * 冒泡排序
 * 1.比较相邻的两个元素，如果前面比后面大就两两交换；
 * 2.整个数组的所有元素从头开始两两进行比较，一次一过程进行完毕后在数组最后的元素就是整个数组的最大值；
 * 3.重复上述过程只不过数组最后一个位置上的数已经是最大值。这次排序只对0---n-2位置上的数进行排序；
 * 4.一直重复3过程直到只剩下1个元素，排序过程结束；
 * 最差时间复杂度：O(n*n);
 * 最好时间复杂度：O(n),数组已经排好序;
 * 时间复杂度：O(n*n);
 * 空间复杂度：O(1);
 * 稳定性：值得是有相同值得时候，能否保证原始的序列中相对次序不变；
 * 稳定性：稳定
 */
public class BubbleSort {
    public static void bubblesort(int[] arr){
        //如果数组是空，或者数组只有一个元素不用排序直接返回；
        if(arr == null||arr.length < 2){
            return;
        }else{
            //遍历整个数组，每次循环数组长度减一
            for(int e = arr.length - 1; e>0 ; e--){
                for(int i = 0; i<e ;i++){
                    if(arr[i] > arr[i+1]) {
                        swap(arr,i,i+1);
                    }
                }
            }
        }
    }
    //交换方法，i和j交换
    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
