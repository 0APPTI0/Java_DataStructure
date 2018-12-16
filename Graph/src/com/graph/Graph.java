package com.graph;

import java.io.*;
import java.util.*;
public class Graph {
    /*要求：判断一个有向图中是否有回路，并且打印出所有的回路。
    思路：通过修改的DFS算法遍历有向图。
    在遍历的过程中，把遍历到的所有的元素都存储到一个队列里面，然后每次遍历到一个节点的时候就检查一下这个队列；要是队列里面已经有重复的元素
    那就表明已经形成了回路，然后打印出来这个回路；然后中断遍历，回去遍历别的节点。
    */

    //用邻接表来初始化要检查的有向图
    private Map<String,ArrayList<String>> Graph = new HashMap<String, ArrayList<String>>();

    public void initGraph(String filename) throws IOException {

        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            String[] temp = line.split(",");
            if (this.Graph.containsKey(temp[0])){
                ArrayList<String> A = Graph.get(temp[0]);
                A.add(temp[1]);
                this.Graph.put(temp[0],A);
            }
            else {
                ArrayList<String> newlist = new ArrayList<String>();
                newlist.add(temp[1]);
                this.Graph.put(temp[0],newlist);
            }
        }
        bufferedReader.close();


    }


    //建造一个HashMap来记录每一个点的状态（是否被访问过）
    private HashMap<String,Boolean> NodeState = new HashMap<String, Boolean>();



    //用来存放已经被遍历过的点
    private ArrayList<String> nodeList = new ArrayList<String>();


    //设置以用来存放最后的结果
    ArrayList<ArrayList> result = new ArrayList<ArrayList>();

    public ArrayList SearchingStart(String firstNode){
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
                ArrayList<String> toBeAddedInToReault = new ArrayList<String>();
                for (String points:loopList){
                    toBeAddedInToReault.add(points);
                }
                result.add(toBeAddedInToReault);
                continue;
            }

            else {
                /*
                if (NodeState.getOrDefault(x,false)){
                    SearchingStart(x);
                }
                */

                //如果这个节点没有邻接点了
                if (Graph.get(x) == null) {
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

        return result;
    }

    public static void main(String[] args) {
        Graph a = new Graph();
        try {
            a.initGraph("edges.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList R = a.SearchingStart("5");
        if (R.isEmpty()){
            System.out.println("No");
        }
        else {
            System.out.println(R.size());
            System.out.println("-------------------");




            for (int i = 0 ; i <= R.size() - 1 ; i ++){
                ArrayList A = (ArrayList) R.get(i);
                for (int j = 1 ; j <= A.size() - 1 ; j ++){
                    System.out.print(A.get(j - 1)+"->");
                }
                System.out.println(A.get(A.size() - 1));
            }
        }
    }


}
