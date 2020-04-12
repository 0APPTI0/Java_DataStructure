package Sorting.SelectionSort.TournamentSorting;

/*
https://blog.csdn.net/weixin_40790474/article/details/79823474
树形选择排序也叫锦标赛排序，我们可以类比比赛过程。有n个待排序的元素，把它们两两一组进行比较，取出较小的，然后在这n/2个较小者中再两两一组进行比较，取出较小的，重复上述步骤，直到取出最小元素。
这个过程用一棵满二叉树表示，在选出最小关元素后，将这个元素对应的叶子节点的值置为∞，然后把不为∞的兄弟节点移到父节点的位置。一直重复这个过程就可以了

其实跟排序算法的思想是一样的，都是通过不断寻找剩余队列的最小值的一个过程；
优化的点在于，锦标赛排序"寻找剩余最小值"的过程经过优化了，比较次数变少了；但是需要额外的存储空间。
 */
public class TournamentSorting {
    /* 对a[]按升序排列 */
    public static void treeSelectSort(int[] a) {
        // 构造出所需要的二叉树
        int len = a.length;// 数组长度
        int nodeSize = len * 2 - 1; // 对一个满二叉树，节点总数 = 叶子节点数*2-1
        int[] tree = new int[nodeSize + 1]; // 这里将用数组表示二叉树的存储结构
        /* 填充叶子节点 */
        for (int i = len - 1, j = 0; i >= 0; i--, j++) {
            tree[nodeSize - j] = a[i];
        }
        /* 通过锦标赛筛选两两比较的较小值，填充其他节点 */
        for (int i = nodeSize - len; i > 0; i--) {
            tree[i] = tree[i * 2] < tree[i * 2 + 1] ? tree[i * 2] : tree[i * 2 + 1];
        }

        /* 将每次找出的最小元素移走 */
        int index = 0;// 数组a的索引
        int minIndex = 0;// 最小值的索引
        while (index < len) {
            int min = tree[1]; // 这是tree的根节点，也是最小元素
            a[index++] = tree[1]; // 将tree中最小的元素取到a[0]中
            minIndex = nodeSize;
            /* 从最后的叶子节点开始，直到找到最小值的索引 */
            while (tree[minIndex] != min) {
                minIndex--;
            }
            tree[minIndex] = Integer.MAX_VALUE; // 将这个最小元素置为最大
            /* 如果这个节点还有父节点，那么就将它的兄弟节点升到父亲节点位置 */
            while (minIndex > 1) {// 根结点的索引是1
                if (minIndex % 2 == 0) {// 这个节点是左节点
                    tree[minIndex / 2] = tree[minIndex] < tree[minIndex + 1] ? tree[minIndex] : tree[minIndex + 1];
                    minIndex = minIndex / 2;
                } else {// 这个节点是右节点
                    tree[minIndex / 2] = tree[minIndex] < tree[minIndex - 1] ? tree[minIndex] : tree[minIndex - 1];
                    minIndex = minIndex / 2;
                }
            }
        }

    }/* treeSelectSort */

    public static void main(String[] args) {
        int[] a = { 12, 34, 23, 38, 65, 97, 76, 13 };
        TournamentSorting.treeSelectSort(a);
        for (int i : a) {
            System.out.print(i + "  ");
        }
    }
}

