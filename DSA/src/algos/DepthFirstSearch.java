package algos;

import DataStructures.Node;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import static util.GraphUtil.createNoneTreeGraph;
import static util.GraphUtil.createTree;

public class DepthFirstSearch {
    public static void dfs(Node head){
        Stack<Node> nodeStack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        nodeStack.push(head);
        while (!nodeStack.empty()){
            System.out.println("stack size is "+nodeStack.size());
            visited.add(head);
            head = nodeStack.pop();
            System.out.println("head is now: "+head.value);
            for(Node node: head.neighbors){
                if(visited.add(node)){
                    System.out.println("adding node "+ node.value + " to stack");
                    nodeStack.push(node);
                }
            }
        }
    }

    public static void main(String[] args){
        System.out.println("-----------------");
        dfs(createTree());
        System.out.println("-----------------");
        dfs(createNoneTreeGraph());

    }

}
