public class hanoitower {
    public static void printstep(int n , char from , char to){
        System.out.println("把"+n+"个盘子从"+from+"转移到"+to);
    }
    public static void move(int n , char from , char via , char to){
        if ( n == 1){
            printstep(1,'A','C');
        }
        else {
            move(n-1 , from , to , via);
            printstep(n, from , to );
            move( n - 1 , via , from , to);
        }
    }

    public static void main(String[] args) {
        hanoitower.move(4,'A','B','C');
    }
}
