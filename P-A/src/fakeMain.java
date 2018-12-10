public class fakeMain {
    public static void main(String[] args) {
        LinkList l = new LinkList();
        Node Nodea = l.creatlist("1,2 1,3");
        Node Nodeb = l.creatlist("1,1 1,2 1,3 1,4");
        Node Nodec = l.addlinks(Nodea,Nodeb);
        l.printLink(Nodec);
    }

}
