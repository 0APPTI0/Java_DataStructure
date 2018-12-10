public class yuesefu
{
    public static void main(String[] args)
    {
        int N=200,count=17;  //N总数、默认从列表的头部开始数、count数几次
        int n=N;     //n是剩下的人数
        int []a=new int [N + 1];
        //用数组存储人的序号
        a[0] = 0;
        for(int i=1;i<=N;i++)
        {
            a[i]=i;
        }
        int counter = 0;
        while (n > 1){
            for (int i = 1 ; i <= N ; i ++){
                if (a[i] == 0){
                    counter = counter;
                }
                else {
                    counter++;
                }
                if (counter == count){
                    System.out.println(a[i]+"出局了");
                    a[i] = 0;
                    counter = 0;
                    n--;
                }
            }
        }
        for (int i = 0 ; i <a.length ; i ++){
            if (a[i] != 0){
                System.out.println(a[i]+"留了下啦");
            }

        }

    }

}
