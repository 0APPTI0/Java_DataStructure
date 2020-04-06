package Heap.SmallHeadHeap;

public class SmallHeadHeap {
    public static void main(String[] args) {
        int[] arr = {16, 7, 3, 20, 17, 8};

        heapSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void heapSort(int[] arr) {
        // 构建初始化小顶堆
        for (int i = (arr.length - 1)/2; i >= 0; i --){
            adjustHeap(arr, i, arr.length);
        }


        for (int i = arr.length - 1; i > 0; i --){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
    }

    private static void adjustHeap(int[] arr, int parent, int length) {
        // 跟节点的值
        int temp = arr[parent];
        // 左子节点的位置
        int leftChild = 2 * parent + 1;

        while(leftChild < length){
            int rightChild = leftChild + 1;
            if (rightChild < length && arr[leftChild] > arr[rightChild])
                leftChild = rightChild;
            if (temp <= arr[leftChild])
                break;

            arr[parent] = arr[leftChild];
            parent = leftChild;
            //选取孩子结点的左孩子结点,继续向下筛选
            leftChild = 2 * leftChild + 1;
        }
        arr[parent] = temp;
    }
}
