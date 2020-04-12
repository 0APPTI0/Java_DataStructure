package Sorting.SelectionSort.DirectSelectionSort;

import java.util.Arrays;

/*
在n个记录中选出关键码最小的记录，然后与第一个记录交换位置，再在其余的n-1个记录中选关键码最小的记录，然后与第二个记录交换位置，直至选择了n-1个记录。
（在n个记录中选出关键码最大的记录，然后与第n记录交换位置，再在其余的n-1个记录中选关键码最大的记录，然后与第n-1记录交换位置，直至选择了n-1个记录。）

算法分析
比较次数n-1+n-2+...+1=n(n-1)/2=O(n^2)，与原始记录次序无关
稳定性
不稳定的
 */
public class DirectionSelectionSort {
    static int[] list = { 12, 34, 23, 38, 65, 97, 76, 13};

    static void directionSelectionSort(int[] list){
        if (list.length == 1)
            return;
        for (int i = 0; i < list.length - 1; i ++){
            int tempMin = list[i+1];
            int minIndex = i+1;
            for (int j = i; j < list.length; j ++){
                if (list[j] < tempMin) {
                    tempMin = list[j];
                    minIndex = j;
                }
            }
            list[minIndex] = list[i];
            list[i] = tempMin;
        }
    }

    public static void main(String[] args) {
        directionSelectionSort(list);
        System.out.println(Arrays.toString(list));
    }
}
