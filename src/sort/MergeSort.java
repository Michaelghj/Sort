/**
 * Copyright (C), 2019-2019,
 * FileName: MergeSort
 * Author:   Administrator
 * Date:     2019/4/12 15:20
 * Description: 归并排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package sort;

/**
 *归并排序：基于分治和归并思想的一个排序
 * 1.分治思想：把数组分成两个部分，分别进行排序，最后在合并
 * 2.时间复杂度：O(nlogn);
 * 3.空间复杂度：O(n) 把已经排好顺序的两个数组合并到这个新数组
 * 4.稳定性：稳定
 */
public class MergeSort {
    public static void mergeSort(int[] arr){
        if(arr == null||arr.length < 2){
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if(l==r){
            return;
        }
        int mid = 1 + ((r - 1) >> 1);
        mergeSort(arr,1,mid);
        mergeSort(arr,mid,1);
        merge(arr,1,mid,r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int help[] = new int[r - l + 1];
        int i = 0;
        int p1 = 1;
        int p2 = m + 1;
        while (p1 <= m && p2 < r){
            help[i++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m){
            help[i++] = arr[p1++];
        }
        while (p1 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[l + i] = help[i];
        }
    }
}
