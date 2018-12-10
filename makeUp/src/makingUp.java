import java.util.ArrayList;

public class makingUp {
    /*
    找出从自然数 1, 2, …, n 中任取r个数的所有组合, 编一个递归算法.
     例子:  n = 5     1  2  3  4  5
                r = 3                 5  4  3
                                      5  4  2
                                      5  4  1
                                      5  3  2
                                      5  3  1
                                      5  2  1
                                      4  3  2
                                      4  3  1
                                      4  2  1
                                      3  2  1

     */

    //这里要实现写好r
    private int[] list = new int[3];


    public void makingUp(int n , int r ){
        if (r > 1){
            for (int k = n ; k >= r ; k --){
                this.list[r - 1] = k;
                makingUp(n-1,r-1);
            }
        }
        else {
            for (int l = n ; l > 0 ; l --) {
                this.list[0] = l;
                if (checkbig(list)) {
                    //这里也要写一下r
                    for (int s = 1; s <= 3; s++) {
                        System.out.print(this.list[s - 1] + "   ");
                    }
                }
                else continue;
            System.out.println();
            }
        }
    }

    //用来检测一个int[]里面是否每一个元素逗比前面一个大
    public static boolean checkbig(int[] k){
        int a = k.length;
        if (k.length == 1){
            return true;
        }
        else {
            for (int i = 0; i < a - 1; i++) {
                if (k[i] < k[i + 1]){
                    continue;
                }
                else return false;
            }
            return true;
        }
    }
}

