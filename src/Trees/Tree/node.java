package Trees.Tree;

public class node {
    //这是一个树的节点类
    public node left;

    public node right;

    public char content;

    public node(char content){
        this.content = content;
        this.left = null;
        this.right = null;
    }

    public node(char content , node left , node right){
        this.content = content;
        this.left = left;
        this.right = right;
    }
}
