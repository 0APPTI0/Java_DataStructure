package Lists.Jpsephus;


/*
据说著名犹太历史学家 Josephus有过以下的故事：
在罗马人占领乔塔帕特后，39 个犹太人与Josephus及他的朋友躲到一个洞中，39个犹太人决定宁愿死也不要被人抓到，
于是决定了一个自杀方式，41个人排成一个圆圈，由第1个人开始报数，每报数到第3人该人就必须自杀，然后再由下一个重新报数，直到所有人都自杀身亡为止。

然而Josephus 和他的朋友并不想遵从，Josephus要他的朋友先假装遵从，他将朋友与自己安排在第16个与第31个位置，于是逃过了这场死亡游戏。
 */
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
            //当数到一定数字的时候，将该节点从队列中剔除
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
