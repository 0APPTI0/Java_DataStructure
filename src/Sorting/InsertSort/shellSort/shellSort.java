package Sorting.InsertSort.shellSort;

/*
希尔排序，缩小增量排序
将一个待排序列分割成若干个小段，分别进行直接插入排序，待整个序列基本有序之后，在细化小段的粒度再进行直接插入排序；最后对整个序列进行直接插入排序。


1. 取一个增量（间隔gap<n），按照增量分组，对每一组使用直接插入排序或者其他方法（交换排序）进行排序。
2. 减少增量（分的组减少，但是每一组的记录增多）。直到增量为1（已经合并为一个组，即原有的队列实现了排序）
        注明：这里不是一开始就把组分好然后分别进行插入排序；在下面的例子之中：
		a. 取0-3位置上的元素插入排序
		b. 排好序放回去
		c. 再取1-4位置上面的排序
不是所有的组一同进行分组和排序，第二个组的排序事实上是基于第一个组的部分结果排序的
 */

/*
本质上就是取不同长度的间隔，然后对间隔两端的数进行交换；然后缩小间隔，与其说属于插入排序，但是其实感觉是一种比较奇特的排序算法。
 */

public class shellSort
{
    public static void main(String[] args)
    {
        int[] ins = {2,3,5,1,23,6,78,34,23,4,5,78,34,65,32,65,76,32,76,1,9};
        int[] ins2 = sort(ins);
        InsertionSort(ins,0,ins.length);
        for(int in: ins){
            System.out.println(in);
        }
    }
    public static int[] sort(int[] ins){
        int n = ins.length;
        // gap为增量（代表了间隔）
        int gap = n/2;
        while(gap > 2){
            // 对每一个小组进行插入排序；
//            for(int j = gap; j < n; j++){
//                int i=j;
//                while(i >= gap && ins[i-gap] > ins[i]){
//                    // 如果在小组内有两个数顺序不对的话就做一个调换
//                    int temp = ins[i-gap]+ins[i];
//                    ins[i-gap] = temp-ins[i-gap];
//                    ins[i] = temp-ins[i-gap];
//                    i -= gap;
//                }
//            }
            for (int i = 0; i < n - gap; i ++){
                InsertionSort(ins,i,i+gap);
            }
            // 不断的缩小增量，再来一次。
            gap = gap/2;
        }

        return ins;
    }

    static void InsertionSort(int[] arr, int begin, int end){
        if (end-begin<1)
            return;
        if (arr[begin+1] < arr[begin]){
            int temp = arr[begin+1];
            arr[begin] = arr[begin+1];
            arr[begin+1] = temp;
        }

        if(end-begin<=1)
            return;
        // 对从第三个开始的元素进行插入
        for (int i = begin+2; i < end; i ++){
            // 遍历待插入的序列，找到插入位置
            for (int j = begin; j < i; j ++){
                if (arr[i] < arr[j]){
                    int temp = arr[i];
                    // 将插入点之后的序列往后移动一位，"让位置"
                    for (int k = i; k > j; k --){
                        arr[k] = arr[k - 1];
                    }
                    arr[j] = temp;
                    break;
                }
            }
        }
    }



}
