import java.util.ArrayList;

public class tree {
    //根据字符串建造一棵树
    public node creatTree(String string){
        ArrayList<node> list = new ArrayList<>();
        for (int i = 0 ; i < string.length() ; i ++){
            list.add(new node(string.charAt(i)));
        }
        for (int i = 0 ; i < string.length() ; i ++){

            //树的左右子树都没有超过边界
            if (2 * i + 2 <= string.length() - 1){
                if (string.charAt(i) == '*'){
                    continue;
                }
                //树的左子树为空而右子树却不为空
                if (string.charAt(2*i+1) == '*' && string.charAt(2*i+2) != '*'){
                    list.get(i).left = null;
                    list.get(i).right = list.get(2 * i + 2);
                }
                //树的右子树为空而左子树不为空
                if (string.charAt(2*i+1) != '*' && string.charAt(2*i+2) == '*'){
                    list.get(i).right = null;
                    list.get(i).left = list.get(2 * i + 1);
                }
                //树的左右子树都不为空
                if(string.charAt(2*i+1) != '*' && string.charAt(2*i+2) != '*') {
                    list.get(i).left = list.get(2 * i + 1);
                    list.get(i).right = list.get(2 * i + 2);
                }
            }
            //树的左子树的位置正好为整个树的边界
            if (2 * i + 1 == string.length() - 1){
                list.get(i).right = null;
                if (string.charAt(2 * i + 1) == '*'){
                    list.get(i).left = null;
                }
                else {
                    list.get(i).left = list.get(2 * i + 1);
                }
            }
            //没有子树的情况
            else if (2 * i + 1 > string.length() - 1){
                list.get(i).left = null;
                list.get(i).right = null;
            }

            //失败的算法
            /*
            if (((2 * i + 1 )< string.length()) && string.charAt( 2 * i + 1) != '*'){
                list.get(i).left = list.get(2 * i + 1);
            }
            else list.get(i).left = null;

            if (((2 * i + 2) < string.length()) && string.charAt( 2 * i + 2) != '*'){
                list.get(i).left = list.get(2 * i + 2);
            }
            else list.get(i).left = null;
            */
        }
        return list.get(0);
    }

    //先序遍历一棵树
    public void prePrint(node tree){
        System.out.print(tree.content);
        if (tree.left != null){
            prePrint(tree.left);
        }
        if (tree.right != null){
            prePrint(tree.right);
        }
    }

    //中序遍历
    public void midPrint(node tree){
        if (tree.left != null){
            midPrint(tree.left);
        }
        System.out.print(tree.content);
        if (tree.right != null){
            midPrint(tree.right);
        }
    }


    //后序遍历
    public void aftPrint(node tree){
        if (tree.left != null){
            aftPrint(tree.left);
        }
        if (tree.right != null){
            aftPrint(tree.right);
        }
        System.out.print(tree.content);
    }

}
