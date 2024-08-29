package Graph.MediumQuestions;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
Given a weighted, undirected and connected graph of V vertices and an adjacency list adj where 
adj[i] is a list of lists containing two integers where the first integer of each list j denotes 
there is edge between i and j , second integers corresponds to the weight of that  edge . You are 
given the source vertex S and You to Find the shortest distance of all the vertex's from the source 
vertex S. You have to return a list of integers denoting shortest distance between each node and 
Source vertex S.
Note: The Graph doesn't contain any negative weight cycle.

Example 1:
Input:
V = 2
adj [] = {{{1, 9}}, {{0, 9}}}
S = 0
Output:
0 9
Explanation:
The source vertex is 0. Hence, the shortest distance of node 0 is 0 and the shortest distance from node 1 is 9.

Example 2:

Input:
V = 3, E = 3
adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}
S = 2
Output:
4 3 0
Explanation:
For nodes 2 to 0, we can follow the path- 2-1-0. This has a distance of 1+3 = 4,
whereas the path 2-0 has a distance of 6. So, the Shortest path from 2 to 0 is 4.
The shortest distance from 0 to 1 is 1 .
*/

public class QDjikstraAlgorithm {

    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V];
        // Initialising dist[] list with infinity initially.
        for (int i = 0; i < V; i++)
            dist[i] = (int) (1e9);

        dist[S] = 0; // Source initialised with dist=0.
        pq.add(new Pair(0, S));

        // Now, pop the minimum distance node first from the min-heap and traverse for
        // all its adjacent nodes.
        while (pq.size() != 0) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            // Check for all adjacent nodes prev dist is larger than current or not.
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                // If current distance is smaller, push it into the queue.
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        // Return the list containing shortest distances from source to all the nodes.
        return dist;
    }

    class Pair {
        int node;
        int distance;

        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }
}