import java.util.*;
public class GraphLoopTest {
private Map<String,List<String>> graph = new HashMap<String,List<String>>();


//初始化图的数据：使用邻接表来表示图的数据
    public void initGraphDate(){
//        图结构如下
//          1
//        /   \
//       2     3
//      / \   / \
//     4  5  6  7
//      \ |   \ /
//        8    9
        //每个graph里面的元素，后面arraylist里面装的都是和这个节点邻接的节点
        graph.put("1", Arrays.asList("2", "3"));
        graph.put("2", Arrays.asList("1", "4", "5"));
        graph.put("3", Arrays.asList("1", "6", "7"));
        graph.put("4", Arrays.asList("2", "8"));
        graph.put("5", Arrays.asList("2", "8"));
        graph.put("6", Arrays.asList("3", "9"));
        graph.put("7", Arrays.asList("3", "9"));
        graph.put("8", Arrays.asList("4", "5"));
        graph.put("9", Arrays.asList("6", "7"));

    }


    /*
    * 宽度优先搜索(BFS,Breadth Firth Search)
    * BFS使用队列（queue）来试试运算过程
    * */
    private Queue<String> queue = new LinkedList<String>();
    //这里使用了一个map，来映射每一个节点"有没有被遍历过";如果没有使用这个hashmap，那么就需要考虑使用类
    private Map<String,Boolean> status = new HashMap<String, Boolean>();

    /**
     * 开始点
     *
     * @param startPoint
     * 为遍历设置一个入口
     */
    public void BFSSearch(String startPoint){
        //1.把起始点放入queue
        queue.add(startPoint);
        status.put(startPoint,true);
        bfsLoop();
    }

    private void bfsLoop(){
        //1)从queue中取出队列头的点；更新状态为已经遍历
        String currentQueueHeader = queue.poll();//出队
        status.put(currentQueueHeader,true);
        System.out.println(currentQueueHeader);
        //2)找出和这个点邻接的且还没有被遍历的点，进行标记，然后全部放入queue中。
        List<String> neighborPoints = graph.get(currentQueueHeader);
        for (String point : neighborPoints){
            //getOrDefault这个函数，可以从一个map里面取出相应的元素然后跟目标的
            if (!status.getOrDefault(point,false)){//这个元素尚未被遍历
                if (queue.contains(point)){
                    continue;
                }
                queue.add(point);
                status.put(point,false);
            }
        }
        if (!queue.isEmpty()){//如果队列还不为空，那么就继续遍历
            bfsLoop();
        }
    }






    /**
     * 深度优先搜索(DFS, Depth First Search)
     * DFS使用队列(queue)来实施算法过程
     * stack具有后进先出LIFO(Last Input First Output)的特性，DFS的操作步骤如下：
     */
//     1、把起始点放入stack；
//     2、重复下述3步骤，直到stack为空为止：
//    从stack中访问栈顶的点；
//    找出与此点邻接的且尚未遍历的点，进行标记，然后全部放入stack中；
//    如果此点没有尚未遍历的邻接点，则将此点从stack中弹出。
    private Stack<String> stack = new Stack<String>();

    /**
     * 开始点
     *
     * @param startPoint
     * 为遍历设置一个入口
     */
    public void DFSSearch(String startPoint){
        stack.push(startPoint);
        status.put(startPoint,true);
        System.out.println(startPoint);
        dfsLoop();
    }

    private void dfsLoop(){
        if (stack.isEmpty()){
            return;
        }

        //查看栈顶元素，并不出栈
        String stackTopPoint = stack.peek();
        //找出和这个点邻接的并且还没有被遍历过的点，进行标记，然后全部放入queue中
        List<String> neighborPoints = graph.get(stackTopPoint);
        for (String points : neighborPoints){
            if (!status.getOrDefault(points,false)){//表示这个点还没有被遍历
                stack.push(points);
                status.put(points,true);
                System.out.println(points);
                dfsLoop();
            }
        }
        //如果没有邻居了，表明已经到了最边缘，那么就pop出来然后再回头去遍历别的节点
        stack.pop();
    }


    public static void main(String[] args) {
        GraphLoopTest test1 = new GraphLoopTest();
        test1.initGraphDate();
        test1.DFSSearch("1");
        //test1.DFSSearch("1");
        System.out.println();
    }
}
