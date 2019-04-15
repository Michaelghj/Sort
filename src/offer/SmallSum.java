/**
 * Copyright (C), 2019-2019,
 * FileName: SmallSum
 * Author:   Administrator
 * Date:     2019/4/13 8:48
 * Description: 小和问题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package offer;

/**
 * 小和问题：在一个数组中，每一个数左边比他小的数累加起来就是小和；
 * [1,2,4,6,2,5]
 * 1.左侧比1小的数，没有0
 * 2.左侧比2小的数,1
 * 3.左侧比4小的数,1,2
 * 4.左侧比6小的数,1,2,4
 * 5.左侧比2小的数,1
 * 6.左侧比5小的数,1,2,4,2
 * 7.所以小和为 1+1+2+1+2+4+1+1+2+4+2=21
 * 思路1：遍历数组，每次遍历数组中每个数左边的值；平均时间复杂度O(n*n)
 * 思路2：归并排序思想
 */
public class SmallSum {
    public static int smallSum(int[] arr){
        if(arr == null||arr.length<2){
            return 0;
        }
        return mergeSort(arr,0,arr.length-1);
    }
    public static int mergeSort(int[] arr, int L, int R){
        if(L == R){
            return 0;
        }
        int mid = L + ((R - L) >>1);
        return mergeSort(arr,L,mid)+
            mergeSort(arr,mid+1,R)+
            merge(arr,L,mid,R);
    }
    public static int merge(int[] arr, int L, int m, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 < R) {
            res += arr[p2] > arr[p1] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p2] > arr[p1] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while(p2 <= R){
            help[i++] = arr[p2++];
        }
        for(i=0;i<help.length-1;i++){
            arr[L+i] = help[i];
        }
        return res;
    }
}
