public class createList {
    node head = new node();
    node tail = head;
    public void Josephus(int numOfMembers,int numOfCal){
        for (int i = 1 ; i <= numOfMembers ; i ++){
            node n = new node();
            //声明每一个的编号
            n.number = i;
            n.next = null;
            tail.next = n;
            tail = tail.next;
        }
        //构造出一个环状结构
        tail.next = head.next;

        int count = 1;
        while (tail.next != tail){
            //移动指针
            tail = tail.next;
            count++;

            if (count == numOfCal){
                System.out.println(tail.next.number + "出局");
                tail.next = tail.next.next;
                count = 1;
            }
        }
        System.out.println(tail.number+"留下来");
    }

    public static void main(String[] args) {
        new createList().Josephus(199,13);
    }
}
