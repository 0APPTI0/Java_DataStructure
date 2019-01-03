public class fakemain {
    public static void main(String[] args) {
        tree t1 = new tree();
        node testTree = t1.creatTree("ABCDEF***G");
        t1.prePrint(testTree);
        System.out.println();
        t1.midPrint(testTree);
        System.out.println();
        t1.aftPrint(testTree);
    }
}
