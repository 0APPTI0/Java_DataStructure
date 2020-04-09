package Sorting.InsertSort.DirectInsertionSort;

/*
直接插入排序对于长度较小的或者基本有序的序列来说非常友好
假设所有的对象是有序的，现在要插入Vi到适当的位置并且保持序列有序

从队列的开头开始；
先将第一、第二个排好序
然后将第三个插入有序队列之中，保持队列有序；
在插入过程中，找到合适的位置之后，将这个位置之后的元素全部向后移动一个单元，然后将元素放入该空出来合适的位置
接着插入第四、第五个

具体流程如下：

1. 首先比较数组的前两个数据，并排序；
2. 比较第三个元素与前两个排好序的数据，并将第三个元素放入适当的位置；
3. 比较第四个元素与前三个排好序的数据，并将第四个元素放入适当的位置；
…
4. 直至把最后一个元素放入适当的位置
 */
public class DirectInsertionSort {
    // 如果用linkedlist实现将会简单很多
    static int[] list = {8,7,6,5,4,3,2,1};

    // 进行一个从小到大的一个排序
    public static void main(String[] args) {
        // 先排好前两个的序，将前两个视为初始序列
        if (list[1] < list[0]){
            int temp = list[1];
            list[0] = list[1];
            list[1] = temp;
        }

        // 对从第三个开始的元素进行插入
        for (int i = 2; i < list.length; i ++){
            // 遍历待插入的序列，找到插入位置
            for (int j = 0; j < i; j ++){
                if (list[i] < list[j]){
                    int temp = list[i];
                    // 将插入点之后的序列往后移动一位，"让位置"
                    for (int k = i; k > j; k --){
                        list[k] = list[k - 1];
                    }
                    list[j] = temp;
                    break;
                }
            }
        }
    }
}
