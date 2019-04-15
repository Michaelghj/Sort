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
        //递归过程，排序的实质 0--n-1 也就是R--L
        mergeSort(arr,0,arr.length-1);
    }

    public static void mergeSort(int[] arr, int L, int r) {
        //在L--R 这个范围只有一个数
        if(L==r){
            return;
        }
        int mid = L + ((r - L) >> 1);//求中点的位置 （L+R）/2
        mergeSort(arr,L,mid);//排好作伴部分的数
        mergeSort(arr,mid,r);//排好右半部分的数
        merge(arr,L,mid,r);//L--mid有序 mid+1--R这两个部分有序，但是整体无序，merge过程就是让整体有序
    }
    //迭代
    public static void merge(int[] arr, int L, int m, int r) {
        int help[] = new int[r - L + 1];//辅助数组
        int i = 0;//在help中一次填入值
        int p1 = L;//相当于指针，左侧部分的第一个值
        int p2 = m + 1;//右侧部分第一个值
        //谁小填谁
        while (p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //两个边界必有一个越界，p1h耗尽p2没耗尽就得吧p2剩余的部分拷贝到辅助数组
        while (p1 <= m){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        //help数组拷贝回原数组
        for(i = 0; i < help.length; i++){
            arr[L + i] = help[i];
        }
    }
}
