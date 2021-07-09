package util;

import DataStructures.Node;

public final class GraphUtil {
    private GraphUtil(){
    }

    public static Node createNoneTreeGraph(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.neighbors.add(four);
        one.neighbors.add(three);
        two.neighbors.add(four);
        two.neighbors.add(three);
        three.neighbors.add(one);
        three.neighbors.add(two);
        four.neighbors.add(one);
        four.neighbors.add(two);
        return two;
    }

    public static Node createTree(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        one.neighbors.add(two);
        one.neighbors.add(three);
        two.neighbors.add(four);
        three.neighbors.add(five);
        three.neighbors.add(six);
        return one;
    }
}
