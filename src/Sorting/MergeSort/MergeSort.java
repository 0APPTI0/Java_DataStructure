package Sorting.MergeSort;

import java.util.Arrays;

// 归并排序——将两个有序的文件组合成一个有序的文件
/*
归并策略：
每次取出两个序列中的元素中小的元素输出之；当一个序列输出完了，那么就顺序输出第二个序列。

算法实现
递归算法
	1. 如果N（要处理的文件中的数据个数）=1，那么只有一个元素需要排序，答案是显然的。
	2. 如果N！=1，那么递归地将前半部分数据和后半部分数据各自归并排序，得到排序后的两部分数据，然后使用上面描述的合并算法再将这两部分合并到一起。

算法分析
合并趟数：log2 n，每次比较n次，所以为O(nlog2 n)

稳定性
稳定的算法。
 */
public class MergeSort {
    static int[] list = {8,4,5,7,1,3,6,2,9};

    static void mergeSort(int[] list, int begin, int end){
        if (end - begin <=1){
            if (list[end] < list[begin]){
                int temp = list[end];
                list[end] = list[begin];
                list[begin] = temp;
            }
        }
        else {
            int m = (begin+end)/2;
            mergeSort(list, begin, m);
            mergeSort(list, m+1, end);
            merge(list, begin, m, m+1, end);
        }
    }

    static void merge(int[] list, int begin1, int end1, int begin2, int end2){
        int B = begin1;
        int E = end2;
        int[] list2 = new int[100];
        // begin1,end1分别代表了序列1的开始和结束；begin2，end2代表了序列2的
        for (int i = begin1; i <= end2; ){
            while (begin1 <= end1 && (begin2>end2 || list[begin1] <= list[begin2])){
                list2[i] = list[begin1];
                begin1++;
                i++;
            }
            while (begin2 <= end2 && (begin1>end1 || list[begin2] < list[begin1])){
                list2[i] = list[begin2];
                begin2++;
                i++;
            }
        }
        for (int i = B; i <= E; i++){
            list[i] = list2[i];
        }
    }

    public static void main(String[] args) {
        mergeSort(list, 0, list.length-1);
        System.out.println(Arrays.toString(list));
    }
}
