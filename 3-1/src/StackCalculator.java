import java.util.*;

public class StackCalculator {

    public static void main(String[] args) {
        String string="1+（2*3）";

        //将字符串转化成char类型数组
        char[] c=new char[string.length()];
        for(int i=0;i<string.length();i++){
            c[i]=string.charAt(i);
        }

        Stack<Integer> stackint=new Stack<Integer>();
        Stack<Character> stackchar=new Stack<Character>();

        for(int i=(string.length()-1);i>=0;i--){
            char ch=c[i];
            if(ch>='0'&&ch<='9'){
                //将char转成string，然后再讲string转成int<调用函数>
                String s=ch+"";
                stackint.push(Integer.parseInt(s));
            }
            if(ch>='('&&ch<='/'){
                stackchar.push(ch);
            }
        }

        char sign;
        int a,b,data=0;

        while(!stackchar.isEmpty()){
            sign=stackchar.pop();
            if(sign=='+'){
                a=stackint.pop();
                b=stackint.pop();
                data=a+b;
                stackint.push(data);
            }
            else if(sign=='-'){
                a=stackint.pop();
                b=stackint.pop();
                data=a-b;
                stackint.push(data);
            }
            else if(sign=='*'){
                a=stackint.pop();
                b=stackint.pop();
                data=a*b;
                stackint.push(data);
            }
            else if(sign=='/'){
                a=stackint.pop();
                b=stackint.pop();
                if(b==0){
                    System.out.println("除数为0！");
                    System.exit(0);
                }
                data=a/b;
                stackint.push(data);
            }
        }
        data=stackint.pop();
        System.out.println("Result="+data);
    }
}
