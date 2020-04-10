package Sorting.ExchangeSort.QuickSort;

import java.util.Arrays;

/*
1. 如果S中元素个数为0或者1，则返回
2. 取S中任意一个元素v，称之为枢纽元。
3. 将S - {v}(S中其余元素)划分成两个不相交的集合：S1,S中所有比v小的元素，S2,S中所有比v大的元素}
4. 返回{quickSort(S1)后跟v，继而返回quickSort(S2)}。
5. 在n个对象中，取一个对象（如第一个对象——基准pivot），按照该对象的关键码把所有<=该关键码的对象划分在它的左边，小于这个关键码的对象划分在它的右边。
对左边和右边（子序列）分别再用快排。

算法：操作两个指针，维护一个key（基准数据）
1）设置两个变量i、j，排序开始的时候：i=0，j=N-1；
2）以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
3）从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]的值赋给A[i]；
4）从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]的值赋给A[j]；
5）重复第3、4步，直到i=j； (3,4步中，没找到符合条件的值，即3中A[j]不小于key,4中A[i]不大于key的时候改变j、i的值，使得j=j-1，i=i+1，直至找到为止。找到符合条件的值，进行交换的时候i， j指针位置不变。另外，i==j这一过程一定正好是i+或j-完成的时候，此时令循环结束）。
 */
public class QuickSort {
    static void quickSort(int[] list, int low, int high){
        if (high - low < 1)
            return;
        if (high - low == 1){
            if (list[high] < list[low])
            {
                int T = list[high];
                list[high] = list[low];
                list[low] = T;
                return;
            }
        }
        int key = list[low];//枢纽轴
        int primaryLow = low;
        int primaryHigh = high;
        low++;// 选定基准元素之后，直接针对基准元素右边的序列
        int flag = 0;
        while(high != low){
            if (flag == 0) {
                if (list[high] < key) {
                    int T = list[high];
                    list[high] = list[low];
                    list[low] = T;
                    flag = 1;
                    continue;
                }
                high --;
            }
            else {
                if (list[low] > key){
                    int T = list[high];
                    list[high] = list[low];
                    list[low] = T;
                    flag = 0;
                    continue;
                }
                low ++;
            }
        }
        // 结束循环之后的high和low已经重合；
        if (list[high] < list[primaryLow]) {
            int TT = list[high];
            list[high] = list[primaryLow];
            list[primaryLow] = TT;
        }
        quickSort(list, primaryLow, high - 1);
        quickSort(list, high , primaryHigh);
    }

    public static void main(String[] args) {
        int[] list = {10,9,8,7,6,5,4,3,2,1};
        quickSort(list,0,list.length-1);
        System.out.println(Arrays.toString(list));
    }
}
