public class Node {
    //这个节点的内容
    private int xishu = 0;

    public void setXishu(int xishu) {
        this.xishu = xishu;
    }

    public int getXishu() {
        return xishu;
    }

    private int zhishu = 0;

    public void setZhishu(int zhishu) {
        this.zhishu = zhishu;
    }

    public int getZhishu() {
        return zhishu;
    }

    public Node(int xishu , int zhishu){
        this.xishu = xishu;
        this.zhishu = zhishu;
    }

    //这个节点的下一个节点
    public Node next = null;

}
