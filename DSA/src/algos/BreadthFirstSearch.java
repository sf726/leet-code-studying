package algos;

import DataStructures.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static util.GraphUtil.createNoneTreeGraph;
import static util.GraphUtil.createTree;

public class BreadthFirstSearch {


    public static void bfs(Node head){
        Queue<Node> nodeQueue = new ArrayDeque<>();
        List<Node> visited = new ArrayList<>();
        nodeQueue.add(head);

        while (!nodeQueue.isEmpty()) {
            System.out.println("queue size is "+nodeQueue.size());
            head = nodeQueue.poll();
            visited.add(head);
            assert head != null;
            System.out.println("adding node "+ head.value + " to visited");

            for (Node node : head.neighbors) {
                if (!visited.contains(node)) {
                    nodeQueue.add(node);
                }
            }
        }
    }





    public static void main(String[] args){
        System.out.println("-----------------");
        bfs(createTree());
        System.out.println("-----------------");
        bfs(createNoneTreeGraph());

    }
}
