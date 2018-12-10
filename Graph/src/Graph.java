import java.util.*;
public class Graph {
    /*要求：判断一个有向图中是否有回路，并且打印出所有的回路。
    思路：通过修改的DFS算法遍历有向图。
    在遍历的过程中，把遍历到的所有的元素都存储到一个队列里面，然后每次遍历到一个节点的时候就检查一下这个队列；要是队列里面已经有重复的元素
    那就表明已经形成了回路，然后打印出来这个回路；然后中断遍历，回去遍历别的节点。
    */

    //用邻接表来初始化要检查的有向图
    private Map<String,List<String>> Graph = new HashMap<String, List<String>>();

    public void initGraph(){
        this.Graph.put("A", Arrays.asList("B"));
        this.Graph.put("B", Arrays.asList("C","D"));
        this.Graph.put("C", Arrays.asList("D"));
        this.Graph.put("D", Arrays.asList("A"));

    }


    //建造一个HashMap来记录每一个点的状态（是否被访问过）
    private HashMap<String,Boolean> NodeState = new HashMap<String, Boolean>();



    //用来存放已经被遍历过的点
    private ArrayList<String> nodeList = new ArrayList<String>();


    public void SearchingStart(String firstNode){
        nodeList.add(firstNode);
        NodeState.put(firstNode,true);
        List<String> tempList = Graph.get(firstNode);
        //遍历x的邻接节点
        for (String x : tempList){

/*

            for (String mmm : nodeList){
                System.out.print(mmm);
            }

            System.out.println();
            System.out.println("现在正在访问的是"+x);

*/

            //检测这个点是否已经在list中，如果已经在list中说明x与x之后遍历的所有元素形成了一个回路，打印出来
            if (nodeList.contains(x)){
                List<String> loopList = nodeList.subList(nodeList.indexOf(x),nodeList.size());
                for (String points:loopList){
                    System.out.print(points+"-");
                }
                System.out.println();
                continue;
            }

            else {
                /*
                if (NodeState.getOrDefault(x,false)){
                    SearchingStart(x);
                }
                */

                //如果这个节点没有邻接点了
                if (Graph.get(x).isEmpty()) {
                    NodeState.put(x,true);
                    continue;
                }



                //如果这个节点指向的所有邻接点都已经被访问过了
                boolean allVisited = true;
                for (String neighborPoints : Graph.get(x)){
                    if (!NodeState.containsKey(neighborPoints)){
                        allVisited = false;
                        break;
                    }
                    if (NodeState.get(neighborPoints) == true){
                        continue;
                    }
                    else {
                        allVisited = false;
                        break;
                    }
                }
                //描述"所有的邻接点都被访问过，但是其中有能够构成回路的邻接点"
                boolean b1 = false;
                for (String neighborPoints : Graph.get(x)) {
                    if (nodeList.contains(neighborPoints)) {
                        b1 = true;
                    }
                }
                if (allVisited && b1){
                    allVisited = false;
                }
                //描述"所有的邻接点都被访问过，而且这些邻接点都不能构成回路"
                if (allVisited){
                    continue;
                }


                //如果这个节点有没有被访问过的邻接点
                else {
                    SearchingStart(x);
                }

            }

        }
        nodeList.remove(nodeList.size() - 1);
    }

    public static void main(String[] args) {
        Graph a = new Graph();
        a.initGraph();
        a.SearchingStart("A");
    }


}
