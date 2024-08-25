package Graph.MediumQuestions;

import java.util.ArrayList;

/*
Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether it 
contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the 
nodes ith node is having edge with.

Example 1:
Input:  
V = 5, E = 5
adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
Output: 1
Explanation: 
1->2->3->4->1 is a cycle.

Example 2:
Input: 
V = 4, E = 2
adj = {{}, {2}, {1, 3}, {2}}
Output: 0
Explanation: 
No cycle in the graph.
*/

public class QUndirectedGraphCycle {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int vis[] = new int[V];
        //this will take care of all different components
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(i, -1, vis, adj) == true)
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> adj) {
        
        vis[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (vis[neighbor] == 0) {
                if (dfs(neighbor, node, vis, adj) == true)
                    return true;
            }
            // if adjacent node is visited and is not its own parent node
            else if (neighbor != parent)
                return true;
        }
        return false;
    }
}