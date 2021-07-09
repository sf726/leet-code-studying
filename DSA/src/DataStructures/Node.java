package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    public final int value;
    public final List<Node> neighbors;

    public Node(int value){
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", neighbors=" + Arrays.toString(neighbors.toArray()) +
                '}';
    }
}
