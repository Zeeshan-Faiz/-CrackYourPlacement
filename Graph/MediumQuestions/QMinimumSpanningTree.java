package Graph.MediumQuestions;

import java.util.List;
import java.util.PriorityQueue;

/*
Given a weighted, undirected, and connected graph with V vertices and E edges, your task is to 
find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph. The graph 
is represented by an adjacency list, where each element adj[i] is a vector containing vector of 
integers. Each vector represents an edge, with the first integer denoting the endpoint of the edge 
and the second integer denoting the weight of the edge.

Example 1:
Input:
3 3
0 1 5
1 2 3
0 2 1
Output:
4
Explanation:
The Spanning Tree resulting in a weight of 4 is shown above.

Example 2:
Input:
2 1
0 1 5
Output:
5
Explanation:
Only one Spanning Tree is possible which has a weight of 5.
*/

public class QMinimumSpanningTree {

    // Using Prim's Algorithm
    public int spanningTree(int V, int E, List<List<int[]>> adj) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        int[] vis = new int[V];
        pq.add(new Pair(0, 0));
        int sum = 0;
        while (pq.size() > 0) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node] == 1)
                continue;

            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i)[1];
                int adjNode = adj.get(node).get(i)[0];
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(edW, adjNode));
                }
            }
        }
        return sum;
    }
}