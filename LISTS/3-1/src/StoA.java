import java.util.Stack;


/*
1.检测算式
2.如果遇到数字 先压栈；
3.遇到运算符；压栈；
4.遇到第二个数字，压栈；
5.遇到第二个运算符。如果这个运算符比栈里的第一个运算符优先级高，那么继续，压入这个运算符下一个数字；
 */
public class StoA{


    public static void main(String[] args) {
        evaluate("3 + 2 - 5 * 6 / 3 ;");
    }
    public static float evaluate(String exp) {
        //操作数栈
        Stack<Float> opnd = new Stack<>();
        //操作符栈
        Stack<String> optr = new Stack<>();
        //将#放入栈中成为栈尾元素，结束就靠它来鉴别。
        optr.push("#");
        //打散exp中的操作符和操作数
        String[] list = exp.split(" ");
        //temp用来表示从栈里pop出来的操作符
        String temp;
        //m,n用啦表示从栈中pop出来的两个操作数
        float m;
        float n;
        //操作开始
        int i = 0;
        while (true) {
            //判断是否为非零数字
            if (isNumeric(list[i])) {
                opnd.push(Float.valueOf(list[i]));
            } else if (list[i].equals("+") || list[i].equals("-") || list[i].equals("*") || list[i].equals("/") || list[i].equals("#") || list[i].equals("(") || list[i].equals(")")) {
                if (optr.peek().equals("#")) {
                    optr.push(list[i]);
                    i++;
                    continue;
                }
                switch (Precede(optr.peek(), list[i])) {
                    //栈顶的运算符的优先级不如新来的运算符，将新运算符压入栈中
                    case "<":
                        optr.push(list[i]);
                        i++;
                        continue;
                    case "=":
                        temp = optr.pop();
                        n = opnd.pop();
                        m = opnd.pop();
                        opnd.push(Operate(m, temp, n));
                        optr.push(list[i]);
                        i++;
                        continue;
                    //栈顶的运算符的优先级高于新运算符，进行运算，并将运算结果存入数据栈中，新运算符存入运算符栈中
                    case ">":
                        temp = optr.pop();
                        n = opnd.pop();
                        m = opnd.pop();
                        opnd.push(Operate(m, temp, n));
                        optr.push(list[i]);
                        i++;
                        continue;
                }

            } else if (list[i].equals(";")) {
                while (!optr.peek().equals("#")){
                    temp = optr.pop();
                    n = opnd.pop();
                    m = opnd.pop();
                    opnd.push(Operate(m, temp, n));
                }
                System.out.println("结果是 --:" + opnd.peek()); // 打印输出表达式值
                return opnd.peek();
            }
            i++;
        }
    }






    //从博客上看到的比较好的比较运算符优先级的方法
    public static String Precede(String a , String b){
        int i,j;
        String[][] Table = {{ " ", "+", "-", "*", "/", "(", ")", "#" }, { "+", ">", ">", "<", "<", "<", ">", ">" }, { "-", ">", ">", "<", "<", "<", ">", ">" }, { "*", ">", ">", ">", ">", "<", ">", ">" }, { "/", ">", ">", ">", ">", "<", ">", ">" }, { "(", "<", "<", "<", "<", "<", "=", " " }, { ")", ">", ">", ">", ">", " ", ">", ">" }, { "#", "<", "<", "<", "<", "<", " ", "=" }};
        for (i = 0; i < 8 ; i ++){
            if (Table[0][i].equals(a)){
                break;
            }
        }
        for (j = 0 ; j < 8 ; j ++){
            if (Table[0][j].equals(b)){
                break;
            }
        }
        return Table[i][j];
    }

    // 转化成小的表达式进行逐步求值
    public static float Operate(float a, String theta, float b){
        float c;
        if (theta.equals("+"))
            c = a + b;
        else if (theta.equals("-"))
            c = a - b;
        else if (theta.equals("*"))
            c = a * b;
        else
            c = a / b;
        return c;
        }

    //判断是否是数字的方法
    public static boolean isNumeric(String str){
        if (Character.isDigit(str.charAt(0))){
            return true;
        }
        for (int i = 0; i < str.length(); i++){
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }


}

