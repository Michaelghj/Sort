/**
 * Copyright (C), 2019-2019,
 * FileName: InsterionSort
 * Author:   Administrator
 * Date:     2019/4/12 9:52
 * Description: 插入排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package sort;

/**
 * 插入排序（要执行操作的数组元素之前的所有元素已经有序）
 * 1.默认0位置数组有序
 * 2.0位置和1位置上的数组进行比较。要是0位置比1位置大两个交换位置；
 * 3.1位置和2位置比较，要是1位置比2位置大，交换然后和0位置比较；、
 * 4.重复以上操作，直到最后一个数组插入到已经排好序的部分；
 * 最好时间复杂度：O(n)
 * 最差时间复杂度：O(n*n) 数组是逆序的
 * 时间复杂度：O(n*n)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 */
public class InsterionSort {
    public static void insertSort(int[] arr){
        if(arr == null||arr.length < 2){
            return;
        }else{
            //当前i位置，要想前面有序区插入
            for(int i = 0; i < arr.length-1; i++){
                //i位置上的数和前面已经排好序的元素比较，插入到合适自己的位置   第一次比较i-1和i比较
                for(int j = i-1; j >= 0 && arr[j] > arr[j+1];  j--){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
