package Graph.MediumQuestions;

import java.util.ArrayList;

/*
Given a weighted and directed graph of V vertices and E edges, Find the shortest distance of all 
the vertex's from the source vertex S. If a vertices can't be reach from the S then mark the 
distance as 10^8. Note: If the Graph contains a negative cycle then return an array consisting of 
only -1.

Example 1:
Input:
E = [[0,1,9]]
S = 0

Output:
0 9

Explanation:
Shortest distance of all nodes from source is printed.

Example 2:
Input:
E = [[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]
S = 2

Output:
1 6 0

Explanation:
For nodes 2 to 0, we can follow the path- 2-0. This has a distance of 1. For nodes 2 to 1, we cam follow the path-
2-0-1, which has a distance of 1+5 = 6,
*/

public class QBellmanFordAlgorithm {

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {

        int[] dist = new int[V];
        //initialise each distance as infinity initially
        for (int i = 0; i < V; i++)
            dist[i] = (int) (1e8);
        dist[S] = 0;// from source to itself 0 distance
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Nth relaxation to check negative cycle
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                return new int[] { -1 };
            }
        }
        return dist;
    }
}