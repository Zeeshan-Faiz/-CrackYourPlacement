package Graph.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
A directed graph of V vertices and E edges is given in the form of an adjacency list adj. Each 
node of the graph is labelled with a distinct integer in the range 0 to V - 1.
A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible 
path starting from that node leads to a terminal node.
You have to return an array containing all the safe nodes of the graph. The answer should be sorted 
in ascending order.

Example 1:
Input:
Output:
2 4 5 6
Explanation:
The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no 
outgoing edges from either of them. 
Every path starting at nodes 2, 4, 5, and 6 all 
lead to either node 5 or 6.
*/

public class QEventualSafeStates {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        int vis[] = new int[V];
        int pathVis[] = new int[V];
        int check[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i] == 1)
                safeNodes.add(i);
        }
        return safeNodes;
    }

    private boolean dfsCheck(int node, List<List<Integer>> adj, int vis[], int pathVis[], int check[]) {

        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        for (int neighbor : adj.get(node)) {
            // when the node is not visited
            if (vis[neighbor] == 0) {
                if (dfsCheck(neighbor, adj, vis, pathVis, check) == true)
                    return true;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if (pathVis[neighbor] == 1) {
                return true;
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
}