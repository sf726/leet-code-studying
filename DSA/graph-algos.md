GRAPH SEARCH

BFS  : TIME 0(V + E) - SPACE 0(V)
From starting Node, inspect each of its adjacent child nodes before moving to grandchildren.

Pros: Always finds optimal solutions, avoids cycles
Cons: Have to store each vertex in memory

import java.util.*;

public class BFS {
    public int BFSsearch(Node start, int searchKey) {
        Set<Node> visited = new HashSet<>();
        LinkedList<Node> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.key == searchKey) {
                return curr.value;
            }

            for (Node child : curr.adjacent) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.add(child);
                }
            }
        }

        return -1;
    }

    public class Node {
        int key;
        int value;
        List<Node> adjacent;
    }
}




DFS : TIME 0(V + E) - SPACE 0(V)
From starting Node, recursively search down each child of the node before moving on to the next adjacent node.

Pros: Only stores the current branch in memory, finds distant elements more quickly
Cons: Doesn’t guarantee optimal solution, long useless paths might cause slow search times

import java.util.*;

public class DFS {
    Set<Node> visited = new HashSet<>();

    public int DFS(Node curr, Set<Node> visited, int searchKey) {
        visited.add(curr);

        if (curr.key == searchKey) {
            return curr.value;
        }

        int resp = -1;
        for (Node child : curr.adjacent) {
            if (!visited.contains(child)) {
                resp = DFS(child, visited, searchKey);
                if (resp != -1) break;
            }
        }

        return resp;
    }

    public class Node {
        int key;
        int value;
        List<Node> adjacent;
    }
}







Dijkstra  : TIME 0(E*log(V)) - SPACE 0(V)
Nodes are initialized with infinite distance and empty source path. Then, perform a priority queue based BFS updating child nodes with the shortest distance and relevant path for all nodes.

Pros: Low complexity, optimal solution for all nodes
Cons: blind search so wastes a lot of time during processing

public class Dijkstra {
        public void Djikstra(Node startNode) {
            Set<Node> visited = new HashSet<>();
            PriorityQueue<Node> queue = new PriorityQueue<>((x, y) -> Integer.compare(x.distance, y.distance));

            startNode.distance = 0;
            startNode.shortestPath = new ArrayList<>();
            queue.add(startNode);
            while (!queue.isEmpty()) {
                Node curr = queue.poll();
                visited.add(curr);
                for (Node child : curr.adjacent.keySet()) {
                    if (!visited.contains(child)) {
                        setMinimumDistance(curr, curr.adjacent.get(child), child);
                        queue.add(child);
                    }
                }
            }
        }

        private void setMinimumDistance(Node source, int edgeDistance, Node child) {
            if (source.distance + edgeDistance < child.distance) {
                child.distance = source.distance + edgeDistance;
                child.shortestPath = new ArrayList<>(source.shortestPath);
                child.shortestPath.add(source);
            }
        }

        public class Node {
            int key;
            int distance = Integer.MAX_VALUE;
            Map<Node, Integer> adjacent;
            List<Node> shortestPath;
        }
}





PATH FINDING

Back Tracking : TIME 0((M+N) * D^L) where D = #directions - SPACE 0(L)
Given some collection object, for each index, check to see if the algorithm is finished, otherwise check if the current index is valid. If both of those checks aren’t found then assume that the index is valid and replace its place in the collection object with a marker. Now for each of the next indices recursively call backTrack searching for a return true. If for each of the next indices we don’t return true then reset the marker to its original value. Finally, after running these iterations return whether any of the index searches returned true.

import java.util.*;

public class BackTracking {
    public boolean exist(char[][] wordSearch, String word) {
            for (int i = 0; i < wordSearch.length; i++) {
                for (int j = 0; j < wordSearch[0].length; j++) {
                    if (backTrack(wordSearch, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
       }

    public boolean backTrack(char[][] wordSearch, int row, int col, String                   searchWord, int index) {
        if (index >= searchWord.length()) {
            return true;
        }

        if (row < 0 || row >= wordSearch.length 
            || col < 0 || col >= wordSearch[0].length
            || wordSearch[row][col] != searchWord.charAt(index)) {
            return false;
        }

        wordSearch[row][col] = '#';

        boolean ret = false;
        int[] rowOff = {0, 1, 0, -1};
        int[] colOff = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            ret = backTrack(wordSearch, row + rowOff[i], 
                col + colOff[i], searchWord, index + 1);
            if (ret) break;
        }

        if (!ret) {
            wordSearch[row][col] = searchWord.charAt(index);
        }

        return ret;
    }
}








Graph Sorting

Khan’s Algorithm (Topological Sort) : TIME 0(V+E) - SPACE 0(V)
Generates a list of lists (src -> dest list) and an inDegree collection that keeps track of how many directed edges inwards each node has. It adds all 0 indegree nodes to a queue and works until the queue is empty, adding each queue.poll() to an answer array in order then subtracting one from each queue.poll()’s neighbors in-degree and adding them to the queue if they are zero. If you have not filled all values in the topological sort then there is a cycle.

class TopologicalSort {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            List<Integer> lst = adjList.get(src);
            lst.add(dest);
            
            inDegree[dest] += 1;
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int[] topSort = new int[numCourses];
        int topPlace = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            topSort[topPlace++] = curr;
            
            for (int child : adjList.get(curr)) {
                inDegree[child] -= 1;
                if (inDegree[child] == 0) {
                    queue.add(child);
                }
            }
        }
        
        if (topPlace == numCourses) {
            return topSort;
        }
        
        return new int[0];
    }
}


