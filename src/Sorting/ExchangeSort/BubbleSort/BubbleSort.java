package Sorting.ExchangeSort.BubbleSort;

public class BubbleSort {
    static int[] list = {8,7,6,5,4,3,2,1};

    public static void main(String[] args) {
        for (int i = 0; i < list.length - 1; i ++){
            for (int j = 1; j < list.length; j ++){
                if (list[j] < list[i]){
                    int temp = list[j];
                    list[j] = list[i];
                    list[i] = temp;
                }
            }
        }
    }
}
