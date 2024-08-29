package Graph.MediumQuestions;

import java.util.ArrayList;
import java.util.Stack;

/*
Given an adjacency list for a Directed Acyclic Graph (DAG) where adj_list[i] contains a list of 
all vertices j such that there is a directed edge from vertex i to vertex j, with  V  vertices and 
E  edges, your task is to find any valid topological sorting of the graph.
In a topological sort, for every directed edge u -> v,  u must come before v in the ordering.

Example 1:
Input:
Output:
1
Explanation:
The output 1 denotes that the order is valid. So, if you have, implemented your function correctly, then output
would be 1 for all test cases. One possible Topological order for the graph is 3, 2, 1, 0.

Example 2:
Input:
Output:
1
Explanation:
The output 1 denotes that the order is valid. So, if you have, implemented your function correctly, then output
would be 1 for all test cases. One possible Topological order for the graph is 5, 4, 2, 1, 3, 0.
*/

public class QTopologicalSort {
    
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }

        int ans[] = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }
        return ans;
    }
    private static void dfs(int node, int vis[], Stack<Integer> st,
            ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0)
                dfs(it, vis, st, adj);
        }
        st.push(node);
    }
}