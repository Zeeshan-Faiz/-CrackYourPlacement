package Graph.MediumQuestions;

import java.util.ArrayList;

/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it 
contains any cycle or not.
*/

public class QDirectedGraphCycle {

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vis[] = new int[V];
        int pathVis[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfsCheck(i, adj, vis, pathVis) == true)
                    return true;
            }
        }
        return false;
    }

    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[]) {
        vis[node] = 1;
        pathVis[node] = 1;

        // traverse for adjacent nodes
        for (int it : adj.get(node)) {
            // when the node is not visited
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis) == true)
                    return true;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        return false;
    }
}