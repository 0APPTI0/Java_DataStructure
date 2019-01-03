public class LinkList {

    public Node creatlist(String data){
        //创建头结点
        Node head = new Node(-1 , -1);
        head.next = null;
        //创建尾节点
        Node tail = head;
        String[] restarray = data.split(" ");
        for (String x : restarray){
            String[] temp = x.split(",");
            int xishu = Integer.parseInt(temp[0]);
            int zhishu = Integer.parseInt(temp[1]);
            if (xishu == 0){
                break;
            }
            else {
                Node node = new Node(xishu,zhishu);
                node.next = null;
                tail.next = node;
                tail = tail.next;
            }

        }
        return head;
    }

    public void printLink(Node head){
        while(head != null){
            System.out.format("%d*X^%d + ", head.getXishu(), head.getZhishu());
            head = head.next;
        }
        System.out.println();
    }

    public Node addlinks(Node nodea , Node nodeb){
        Node nodec = new Node(-1,-1);
        //去除头结点
        Node pa = nodea.next;
        Node pb = nodeb.next;
        Node pc = nodec;
        //判断两个链表当前节点的指数是否相等
        int axishu = 0;
        int bxishu = 0;
        while (pa != null && pb != null){
            if (pa.getZhishu() < pb.getZhishu()){
                pc.next = pa;
                pc = pc.next;
                pa = pa.next;
            }
            else if (pa.getZhishu() > pb.getZhishu()){
                pc.next = pb;
                pc = pc.next;
                pb = pb.next;
            }
            else {
                //两者指数相等的情况
                //两者指数和不为0
                if (pa.getXishu() + pb.getXishu() != 0 ){
                    Node n = new Node(pa.getXishu() + pb.getXishu(),pa.getZhishu());
                    pc.next = n;
                    pc = pc.next;
                    pa = pa.next;
                    pb = pb.next;
                }
                else {
                    pa = pa.next;
                    pb = pb.next;
                }
            }
        }


        if (pa != null){
            pc.next = pa;
        }

        if (pb != null){
            pc.next = pb;
        }


        return nodec.next;

    }
}






















